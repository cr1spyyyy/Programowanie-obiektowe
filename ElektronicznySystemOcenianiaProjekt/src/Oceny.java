import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Oceny extends JFrame {
    private JTextField txtocenaid;
    private JTextField txtstudid;
    private JTextField txtprzedid;
    private JTable table1;
    private JButton btnDodaj;
    private JButton btnAktualizuj;
    private JButton btnUsun;
    private JButton btnWyszukaj;
    private JTextField txtwyszukaj;
    private JButton btnWroc;
    private JPanel ocenyPanel;
    private JComboBox<Double> comboBoxOcena;
    private int width = 900, height = 600;

    public Oceny() {
        super("Oceny");
        this.setContentPane(this.ocenyPanel);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        DefaultTableModel model = new DefaultTableModel();
        table1.setModel(model);

        // Dodaj wartości do comboBoxOcena
        Double[] oceny = {2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0};
        comboBoxOcena.setModel(new DefaultComboBoxModel<>(oceny));

        viewOceny();

        this.setVisible(true);
        btnWroc.addActionListener(e -> dispose());
        btnDodaj.addActionListener(e -> {
            if (txtstudid.getText().isEmpty() || txtprzedid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Brak potrzebnych informacji", "Uwaga!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int student_id = Integer.parseInt(txtstudid.getText());
                    int przedmiot_id = Integer.parseInt(txtprzedid.getText());
                    double ocena = (Double) comboBoxOcena.getSelectedItem();
                    if (!czyIstnieje(student_id, przedmiot_id)) {
                        JOptionPane.showMessageDialog(null, "Podano błędne dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    } else {
                        OcenyCRUD ocenyCRUD = new OcenyCRUD();
                        ocenyCRUD.addOcena(student_id, przedmiot_id, ocena);
                        JOptionPane.showMessageDialog(null, "Dodano ocenę", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                        viewOceny();
                        wyczyscPola();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Podaj prawidłowe dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAktualizuj.addActionListener(e -> {
            if (txtstudid.getText().isEmpty() || txtprzedid.getText().isEmpty() || txtocenaid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Brak potrzebnych informacji", "Uwaga!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int student_id = Integer.parseInt(txtstudid.getText());
                    int przedmiot_id = Integer.parseInt(txtprzedid.getText());
                    double ocena = (Double) comboBoxOcena.getSelectedItem();
                    int ocena_id = Integer.parseInt(txtocenaid.getText());
                    if (!czyIstnieje(student_id, przedmiot_id)) {
                        JOptionPane.showMessageDialog(null, "Podano błędne dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                    } else {
                        OcenyCRUD ocenyCRUD = new OcenyCRUD();
                        ocenyCRUD.updateOcena(student_id, przedmiot_id, ocena, ocena_id);
                        JOptionPane.showMessageDialog(null, "Zaktualizowano ocenę", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                        viewOceny();
                        wyczyscPola();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Podaj prawidłowe dane.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUsun.addActionListener(e -> {
            try {
                int ocena_id = Integer.parseInt(txtocenaid.getText());
                OcenyCRUD ocenyCRUD = new OcenyCRUD();
                ocenyCRUD.deleteOcena(ocena_id);
                JOptionPane.showMessageDialog(null, "Usunięto ocenę", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                viewOceny();
                wyczyscPola();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Podaj prawidłowe ID oceny.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnWyszukaj.addActionListener(e -> {
            try {
                int ocena_id = Integer.parseInt(txtwyszukaj.getText());
                OcenyCRUD ocenyCRUD = new OcenyCRUD();
                ResultSet result = ocenyCRUD.searchOcena(ocena_id);

                if (result != null && result.next()) {
                    txtocenaid.setText(String.valueOf(result.getInt("ocena_id")));
                    txtstudid.setText(result.getString("student_id"));
                    txtprzedid.setText(String.valueOf(result.getInt("przedmiot_id")));
                    comboBoxOcena.setSelectedItem(result.getDouble("ocena"));
                } else {
                    JOptionPane.showMessageDialog(Oceny.this, "Nie znaleziono oceny o podanym ID.", "Brak wyników", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Oceny.this, "Podaj prawidłowy numer oceny.", "Błąd", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Oceny.this, "Wystąpił błąd podczas wyszukiwania oceny.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow >= 0) {
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();

                    String ocena_id = model.getValueAt(selectedRow, 0).toString();
                    String student_id = model.getValueAt(selectedRow, 1).toString();
                    String przedmiot_id = model.getValueAt(selectedRow, 2).toString();
                    String ocena = model.getValueAt(selectedRow, 3).toString();

                    txtocenaid.setText(ocena_id);
                    txtstudid.setText(student_id);
                    txtprzedid.setText(przedmiot_id);
                    comboBoxOcena.setSelectedItem(Double.parseDouble(ocena));
                }
            }
        });
    }

    private boolean czyIstnieje(int student_id, int przedmiot_id) {
        String studentQuery = "SELECT COUNT(*) AS count FROM studenci WHERE student_id = ?";
        String przedmiotQuery = "SELECT COUNT(*) AS count FROM przedmioty WHERE przedmiot_id = ?";

        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmtS = con.prepareStatement(studentQuery);
             PreparedStatement pstmtP = con.prepareStatement(przedmiotQuery)) {

            // Sprawdzanie istnienia studenta
            pstmtS.setInt(1, student_id);
            ResultSet rsStudent = pstmtS.executeQuery();
            boolean studentExists = false;
            if (rsStudent.next()) {
                studentExists = rsStudent.getInt("count") > 0;
            }

            // Sprawdzanie istnienia przedmiotu
            pstmtP.setInt(1, przedmiot_id);
            ResultSet rsPrzedmiot = pstmtP.executeQuery();
            boolean przedmiotExists = false;
            if (rsPrzedmiot.next()) {
                przedmiotExists = rsPrzedmiot.getInt("count") > 0;
            }

            // Zwrócenie true tylko jeśli obie wartości istnieją
            return studentExists && przedmiotExists;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void viewOceny() {
        OcenyCRUD ocenyCRUD = new OcenyCRUD();
        ResultSet result = ocenyCRUD.infoOcena();

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

    private void wyczyscPola() {
        txtocenaid.setText("");
        txtstudid.setText("");
        txtprzedid.setText("");
        txtwyszukaj.setText("");
    }
}
