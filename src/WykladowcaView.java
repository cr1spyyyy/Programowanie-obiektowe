import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WykladowcaView extends JFrame {
    private JPanel wykladPanel;
    private JLabel powitanieLabel;
    private JTextField txtstudid;
    private JTextField txtprzedid;
    private JTextField txtocenaid;
    private JTable table1;
    private JButton btnDodaj;
    private JButton btnAktualizuj;
    private JButton btnUsun;
    private JButton btnWyszukaj;
    private JTextField txtwyszukaj;
    private JButton btnWyloguj;
    private JComboBox<String> comboBoxPrzed;
    private JComboBox<String> comboBoxOcena;
    private final int wykladowca_id;

    public WykladowcaView(int wykladowca_id) {
        super("Elektroniczny system oceniania");
        this.wykladowca_id = wykladowca_id;
        this.setContentPane(this.wykladPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 800, height = 600;
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        listaPrzed();
        initializeComboBoxOcena();
        this.setVisible(true);

        btnDodaj.addActionListener(e -> dodajOcene());

        btnAktualizuj.addActionListener(e -> aktualizujOcene());

        btnUsun.addActionListener(e -> usunOcene());

        btnWyszukaj.addActionListener(e -> wyszukajStudenta());

        btnWyloguj.addActionListener(e -> {
            new WyborLogowania();
            dispose();
        });

        comboBoxPrzed.addActionListener(e -> {
            String selectedPrzedmiot = (String) comboBoxPrzed.getSelectedItem();
            if (selectedPrzedmiot != null) {
                int przedmiotId = PrzedID(selectedPrzedmiot);
                txtprzedid.setText(String.valueOf(przedmiotId));
                updateTable();
            }

        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow >= 0) {
                    txtstudid.setText(String.valueOf(table1.getValueAt(selectedRow, 0)));
                    txtocenaid.setText(String.valueOf(table1.getValueAt(selectedRow, 4)));
                    String ocena = String.valueOf(table1.getValueAt(selectedRow, 3));
                    comboBoxOcena.setSelectedItem(ocena);
                }
            }
        });
    }

    private void listaPrzed() {
        String sql = "SELECT nazwa FROM przedmioty WHERE wykladowca_id = ?";
        String wykladowca = "SELECT imie, nazwisko FROM wykladowcy WHERE wykladowca_id = ?";

        try (Connection con = DBpolaczenie.getConnection()) {
            try (PreparedStatement studentStmt = con.prepareStatement(wykladowca)) {
                studentStmt.setInt(1, wykladowca_id);
                ResultSet studentResult = studentStmt.executeQuery();

                if (studentResult.next()) {
                    String imie = studentResult.getString("imie");
                    String nazwisko = studentResult.getString("nazwisko");
                    powitanieLabel.setText("Witaj, " + imie + " " + nazwisko);
                } else {
                    powitanieLabel.setText("Nie znaleziono wykładowcy.");
                }
            }

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, wykladowca_id);
                ResultSet rs = pstmt.executeQuery();

                List<String> przedmioty = new ArrayList<>();
                while (rs.next()) {
                    String nazwaPrzedmiotu = rs.getString("nazwa");
                    przedmioty.add(nazwaPrzedmiotu);
                }

                comboBoxPrzed.setModel(new DefaultComboBoxModel<>(przedmioty.toArray(new String[0])));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int PrzedID(String nazwaPrzedmiotu) {
        String sql = "SELECT przedmiot_id FROM przedmioty WHERE nazwa = ? AND wykladowca_id = ?";
        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nazwaPrzedmiotu);
            pstmt.setInt(2, wykladowca_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("przedmiot_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void updateTable() {
        String przedmiot = (String) comboBoxPrzed.getSelectedItem();
        String sql = "SELECT s.student_id AS \"IDstudenta\", s.imie AS \"Imię\", s.nazwisko AS \"Nazwisko\", " +
                "o.ocena_id AS \"IDoceny\", o.ocena AS \"Ocena\" " +
                "FROM studenci s " +
                "LEFT JOIN oceny o ON s.student_id = o.student_id " +
                "LEFT JOIN przedmioty p ON o.przedmiot_id = p.przedmiot_id " +
                "WHERE p.nazwa = ? AND p.wykladowca_id = ? " +
                "ORDER BY s.student_id";

        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, przedmiot);
            pstmt.setInt(2, wykladowca_id);
            ResultSet rs = pstmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("IDstudenta");
            model.addColumn("Imię");
            model.addColumn("Nazwisko");
            model.addColumn("Ocena");
            model.addColumn("IDoceny");

            while (rs.next()) {
                int student_id = rs.getInt("IDstudenta");
                String imie = rs.getString("Imię");
                String nazwisko = rs.getString("Nazwisko");
                double ocena = rs.getDouble("Ocena");
                int ocena_id = rs.getInt("IDoceny");

                if (ocena_id == 0) {
                    model.addRow(new Object[]{student_id, imie, nazwisko, "", ""});
                } else {
                    model.addRow(new Object[]{student_id, imie, nazwisko, ocena, ocena_id});
                }
            }

            table1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dodajOcene() {
        try {
            int student_id = Integer.parseInt(txtstudid.getText());
            String przedmiot = (String) comboBoxPrzed.getSelectedItem();
            double ocena = Double.parseDouble((String) comboBoxOcena.getSelectedItem());

            if (txtstudid.getText().isEmpty() || przedmiot == null) {
                throw new IllegalArgumentException("Proszę wypełnić wszystkie pola.");
            }


            String sqlDodajOcene = "INSERT INTO oceny (student_id, przedmiot_id, ocena) VALUES (?, ?, ?)";

            try (Connection con = DBpolaczenie.getConnection();
                 PreparedStatement pstmtDodaj = con.prepareStatement(sqlDodajOcene)) {

                pstmtDodaj.setInt(1, student_id);
                pstmtDodaj.setInt(2, PrzedID(przedmiot));
                pstmtDodaj.setDouble(3, ocena);
                pstmtDodaj.executeUpdate();

                JOptionPane.showMessageDialog(this, "Ocena została dodana");
                updateTable();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Wystąpił problem podczas dodawania oceny.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Proszę wprowadzić poprawne dane.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Wystąpił błąd, upewnij sie ze wsyzstkie dane są poprawne",
                    "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        wyczyscPola();
    }


    private void aktualizujOcene() {
        try {
            int ocena_id = Integer.parseInt(txtocenaid.getText());
            double ocena = Double.parseDouble((String) comboBoxOcena.getSelectedItem());
            int student_id = Integer.parseInt(txtstudid.getText());

            if (txtocenaid.getText().isEmpty() || txtstudid.getText().isEmpty() || !czyIstniejeStudent(student_id)) {
                throw new IllegalArgumentException("Upewnij się, że wszystkie dane są poprawne");
            }


            String sqlAktualizujOcene = "UPDATE oceny SET ocena = ? WHERE ocena_id = ? AND student_id = ?";

            try (Connection con = DBpolaczenie.getConnection();
                 PreparedStatement pstmtAktualizuj = con.prepareStatement(sqlAktualizujOcene)) {

                pstmtAktualizuj.setDouble(1, ocena);
                pstmtAktualizuj.setInt(2, ocena_id);
                pstmtAktualizuj.setInt(3, student_id);
                pstmtAktualizuj.executeUpdate();

                JOptionPane.showMessageDialog(this, "Ocena została zaktualizowana");
                updateTable();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Wystąpił problem podczas aktualizacji oceny.");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Błąd dodawania danych.",
                    "Błąd",JOptionPane.ERROR_MESSAGE);
        }
        wyczyscPola();
    }


    private void usunOcene() {
        try {
            int ocena_id = Integer.parseInt(txtocenaid.getText());
            int student_id = Integer.parseInt(txtstudid.getText());

            if (txtocenaid.getText().isEmpty() || txtstudid.getText().isEmpty() || !czyIstniejeStudent(student_id)) {
                throw new IllegalArgumentException("Proszę wypełnić pole ID oceny.");
            }

            String sqlUsunOcene = "DELETE FROM oceny WHERE ocena_id = ? AND student_id = ?";

            try (Connection con = DBpolaczenie.getConnection();
                 PreparedStatement pstmtUsun = con.prepareStatement(sqlUsunOcene)) {

                pstmtUsun.setInt(1, ocena_id);
                pstmtUsun.setInt(2, student_id);
                pstmtUsun.executeUpdate();

                JOptionPane.showMessageDialog(this, "Ocena została usunięta");
                updateTable();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Wystąpił problem podczas usuwania oceny.");
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Proszę wprowadzić poprawne dane.");
        }
        wyczyscPola();
    }

    private void wyszukajStudenta() {
        try {
            int student_id = Integer.parseInt(txtwyszukaj.getText());

            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            boolean studentFound = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                int id = (int) model.getValueAt(i, 0);
                if (id == student_id) {
                    table1.setRowSelectionInterval(i, i);
                    txtstudid.setText(String.valueOf(model.getValueAt(i, 0)));
                    txtocenaid.setText(String.valueOf(model.getValueAt(i, 4)));
                    String ocenaValue = String.valueOf(model.getValueAt(i, 3));
                    comboBoxOcena.setSelectedItem(ocenaValue);
                    studentFound = true;
                    break;
                }
            }

            if (!studentFound) {
                JOptionPane.showMessageDialog(this, "Student nie znaleziony!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Proszę wprowadzić poprawne ID studenta.");
        }
        txtwyszukaj.setText("");
    }

    private void initializeComboBoxOcena() {
        comboBoxOcena.setModel(new DefaultComboBoxModel<>(new String[]{"2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0"}));
    }
    private boolean czyIstniejeStudent(int student_id) {
        String sql = "SELECT COUNT(*) AS count FROM studenci WHERE student_id = ?";

        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    private void wyczyscPola() {
        txtstudid.setText("");
        txtprzedid.setText("");
        txtocenaid.setText("");
        txtwyszukaj.setText("");

    }



}
