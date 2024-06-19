import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wykladowcy extends JFrame {
    private JTextField txtwyklid;
    private JTextField txtimie;
    private JTextField txtnazwisko;
    private JTextField txtlogin;
    private JTextField txthaslo;
    private JTextField txtemail;
    private JButton btnDodaj;
    private JButton btnAktualizuj;
    private JButton btnUsun;
    private JButton btnWyszukaj;
    private JTextField txtwyszukaj;
    private JButton btnWroc;
    private JTable table1;
    private JPanel wyklPanel;
    private int width = 900, height = 600;

    public Wykladowcy() {
        super("Wykładowcy");
        this.setContentPane(this.wyklPanel);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        DefaultTableModel model = new DefaultTableModel();
        table1.setModel(model);
        viewWykl();
        this.setVisible(true);

        btnWroc.addActionListener(e -> dispose());
        btnDodaj.addActionListener(e -> {
            if (txtimie.getText().isEmpty() || txtnazwisko.getText().isEmpty() || txtlogin.getText().isEmpty() ||
                    txthaslo.getText().isEmpty() || txtemail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Wszystkie pola muszą być wypełnione", "Błąd", JOptionPane.ERROR_MESSAGE);
            } else {
                String imie = txtimie.getText();
                String nazwisko = txtnazwisko.getText();
                String login = txtlogin.getText();
                String haslo = txthaslo.getText();
                String email = txtemail.getText();

                WykladowcyCRUD wykladowcyCRUD = new WykladowcyCRUD();
                wykladowcyCRUD.addWyklad(imie, nazwisko, login, haslo, email);


                viewWykl();
                wyczyscPola();
            }
        });
        btnAktualizuj.addActionListener(e -> {
            if (txtimie.getText().isEmpty() || txtnazwisko.getText().isEmpty() || txtlogin.getText().isEmpty() ||
                    txthaslo.getText().isEmpty() || txtemail.getText().isEmpty() || txtwyklid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Wszystkie pola muszą być wypełnione", "Błąd", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String imie = txtimie.getText();
                    String nazwisko = txtnazwisko.getText();
                    String login = txtlogin.getText();
                    String haslo = txthaslo.getText();
                    String email = txtemail.getText();
                    int wykladowca_id = Integer.parseInt(txtwyklid.getText());

                    WykladowcyCRUD wykladowcyCRUD = new WykladowcyCRUD();
                    wykladowcyCRUD.updateWyklad(imie, nazwisko, login, haslo, email, wykladowca_id);

                    viewWykl();
                    wyczyscPola();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Podaj prawidłowy numer wykładowcy.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnUsun.addActionListener(e -> {
            try {
                int wykladowca_id = Integer.parseInt(txtwyklid.getText());
                WykladowcyCRUD wykladowcyCRUD = new WykladowcyCRUD();
                wykladowcyCRUD.deleteWyklad(wykladowca_id);
                viewWykl();
                wyczyscPola();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Podaj prawidłowy numer wykładowcy.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnWyszukaj.addActionListener(e -> {
            try {
                int wykladowca_id = Integer.parseInt(txtwyszukaj.getText());
                WykladowcyCRUD wykladowcyCRUD = new WykladowcyCRUD();
                ResultSet result = wykladowcyCRUD.searchWyklad(wykladowca_id);

                if (result != null && result.next()) {
                    txtwyklid.setText(String.valueOf(result.getInt("wykladowca_id")));
                    txtimie.setText(result.getString("imie"));
                    txtnazwisko.setText(result.getString("nazwisko"));
                    txtlogin.setText(result.getString("login"));
                    txthaslo.setText(result.getString("haslo"));
                    txtemail.setText(result.getString("email"));
                } else {
                    JOptionPane.showMessageDialog(Wykladowcy.this, "Nie znaleziono wykładowcy o podanym ID.", "Brak wyników", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Wykladowcy.this, "Podaj poprawny numer wykładowcy.", "Błąd", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Wykladowcy.this, "Wystąpił błąd podczas wyszukiwania wykładowcy.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        table1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table1.getSelectedRow();
                if (selectedRow > 0) {
                    TableModel model1 = table1.getModel();
                    txtwyklid.setText(model1.getValueAt(selectedRow, 0).toString());
                    txtimie.setText(model1.getValueAt(selectedRow, 1).toString());
                    txtnazwisko.setText(model1.getValueAt(selectedRow, 2).toString());
                    txtlogin.setText(model1.getValueAt(selectedRow, 3).toString());
                    txthaslo.setText(model1.getValueAt(selectedRow, 4).toString());
                    txtemail.setText(model1.getValueAt(selectedRow, 5).toString());
                }
            }
        });
    }

    public void viewWykl() {
        WykladowcyCRUD wykladowcyCRUD = new WykladowcyCRUD();
        ResultSet result = wykladowcyCRUD.infoWyklad();

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
        txtwyklid.setText("");
        txtimie.setText("");
        txtnazwisko.setText("");
        txtlogin.setText("");
        txthaslo.setText("");
        txtemail.setText("");
        txtwyszukaj.setText("");
    }
}
