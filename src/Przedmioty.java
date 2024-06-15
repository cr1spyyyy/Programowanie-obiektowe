import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Przedmioty extends JFrame {
    private JPanel przedPanel;
    private JTextField txtprzedid;
    private JTextField txtnazwa;
    private JTextField txtwyklid;
    private JButton btnDodaj;
    private JButton btnUsun;
    private JButton btnWyszukaj;
    private JButton btnAktualizuj;
    private JTable table1;
    private JTextField txtwyszukaj;
    private JButton btnWroc;
    private int width = 900, height = 600;

    public Przedmioty() {
        super("Przedmioty");
        this.setContentPane(this.przedPanel);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        DefaultTableModel model = new DefaultTableModel();
        table1.setModel(model);

        viewPrzed();

        this.setVisible(true);
        btnWroc.addActionListener(e -> dispose());
        btnDodaj.addActionListener(e -> {
            if (txtnazwa.getText().isEmpty() || txtwyklid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Brak potrzebnych informacji", "Uwaga!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String nazwa = txtnazwa.getText();
                    int wykladowca_id = Integer.parseInt(txtwyklid.getText());

                    if(!czyIstniejeWyklad(wykladowca_id)){
                        JOptionPane.showMessageDialog(null,"Podano błędne dane",
                                "Błąd", JOptionPane.WARNING_MESSAGE);
                    }else{
                        PrzedmiotyCRUD przedmiotyCRUD = new PrzedmiotyCRUD();
                        przedmiotyCRUD.addPrzed(nazwa, wykladowca_id);

                        JOptionPane.showMessageDialog(null, "Dodano przedmiot", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                        viewPrzed();
                        wyczyscPola();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Podaj prawidłowe dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAktualizuj.addActionListener(e -> {
            if (txtnazwa.getText().isEmpty() || txtwyklid.getText().isEmpty() || txtprzedid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Brak potrzebnych informacji", "Uwaga!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String nazwa = txtnazwa.getText();
                    int wykladowca_id = Integer.parseInt(txtwyklid.getText());
                    int przedmiot_idW = Integer.parseInt(txtprzedid.getText());

                    if(!czyIstniejeWyklad(wykladowca_id)){
                        JOptionPane.showMessageDialog(null,"Podano błędne dane",
                                "Błąd", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        PrzedmiotyCRUD przedmiotyCRUD = new PrzedmiotyCRUD();
                        przedmiotyCRUD.updatePrzed(nazwa, wykladowca_id, przedmiot_idW);

                        JOptionPane.showMessageDialog(null, "Zaktualizowano przedmiot", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                        viewPrzed();
                        wyczyscPola();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Podaj prawidłowe dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUsun.addActionListener(e -> {
            try {
                int przedmiot_id = Integer.parseInt(txtprzedid.getText());
                PrzedmiotyCRUD przedmiotyCRUD = new PrzedmiotyCRUD();
                przedmiotyCRUD.deletePrzed(przedmiot_id);
                JOptionPane.showMessageDialog(null, "Usunięto przedmiot", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                viewPrzed();
                wyczyscPola();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Podaj prawidłowe ID przedmiotu.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnWyszukaj.addActionListener(e -> {
            try {
                int przedmiot_id = Integer.parseInt(txtwyszukaj.getText());
                PrzedmiotyCRUD przedmiotyCRUD = new PrzedmiotyCRUD();
                ResultSet result = przedmiotyCRUD.searchPrzed(przedmiot_id);

                if (result != null && result.next()) {
                    txtprzedid.setText(String.valueOf(result.getInt("przedmiot_id")));
                    txtnazwa.setText(result.getString("nazwa"));
                    txtwyklid.setText(String.valueOf(result.getInt("wykladowca_id")));
                } else {
                    JOptionPane.showMessageDialog(Przedmioty.this, "Nie znaleziono przedmiotu o podanym ID.", "Brak wyników", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Przedmioty.this, "Podaj prawidłowy numer przedmiotu.", "Błąd", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Przedmioty.this, "Wystąpił błąd podczas wyszukiwania przedmiotu.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow >= 0) {
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();

                    String przedmiot_id = model.getValueAt(selectedRow, 0).toString();
                    String nazwa = model.getValueAt(selectedRow, 1).toString();
                    String wykladowca_id = model.getValueAt(selectedRow, 2).toString();

                    txtnazwa.setText(nazwa);
                    txtwyklid.setText(wykladowca_id);
                    txtprzedid.setText(przedmiot_id);
                }
            }
        });
    }

    public void viewPrzed() {
        PrzedmiotyCRUD przedmiotyCRUD = new PrzedmiotyCRUD();
        ResultSet result = przedmiotyCRUD.infoPrzed();

        try {
            if (result != null) {
                DefaultTableModel model = new DefaultTableModel();

                int columnCount = result.getMetaData().getColumnCount();
                Object[] columnNames = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = result.getMetaData().getColumnName(i);
                }

                model.setColumnIdentifiers(columnNames);

                while (result.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = result.getObject(i);
                    }
                    model.addRow(row);
                }

                table1.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean czyIstniejeWyklad(int wykladowca_id) {
        String sql = "SELECT COUNT(*) AS count FROM wykladowcy WHERE wykladowca_id = ?";

        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, wykladowca_id);
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
        txtprzedid.setText("");
        txtnazwa.setText("");
        txtwyklid.setText("");
        txtwyszukaj.setText("");
    }
}
