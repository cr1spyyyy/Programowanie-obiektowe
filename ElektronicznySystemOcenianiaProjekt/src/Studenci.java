import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Studenci extends JFrame{
    private JPanel studPanel;
    private JTextField txtstudid;
    private JTextField txtimie;
    private JTextField txtnazwisko;
    private JTextField txtlogin;
    private JTextField txthaslo;
    private JTextField txtrok;
    private JTextField txtemail;
    private JButton btnDodaj;
    private JTable table1;
    private JButton btnAktualizuj;
    private JButton btnUsun;
    private JButton btnWyszukaj;
    private JTextField txtwyszukaj;
    private JButton btnWroc;
    private int width = 900, height = 600;
    public Studenci() {
        super("Studenci");
        this.setContentPane(this.studPanel);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        DefaultTableModel model = new DefaultTableModel();
        table1.setModel(model);

        viewStud();

        this.setVisible(true);
        btnDodaj.addActionListener(e -> {
            String imie = txtimie.getText();
            String nazwisko = txtnazwisko.getText();
            String login = txtlogin.getText();
            String haslo = txthaslo.getText();
            String email = txtemail.getText();
            int rok = Integer.parseInt(txtrok.getText());

            StudentCRUD studentCRUD = new StudentCRUD();
            studentCRUD.addStud(imie, nazwisko, login, haslo, email, rok);

            viewStud();
            wyczyscPola();
        });
        btnAktualizuj.addActionListener(e -> {
            String imie = txtimie.getText();
            String nazwisko = txtnazwisko.getText();
            String login = txtlogin.getText();
            String haslo = txthaslo.getText();
            String email = txtemail.getText();
            int rok = Integer.parseInt(txtrok.getText());
            int student_id = Integer.parseInt(txtstudid.getText());

            StudentCRUD studentCRUD = new StudentCRUD();
            studentCRUD.updateStud(imie, nazwisko, login, haslo, email, rok, student_id);

            viewStud();
            wyczyscPola();
        });
        btnUsun.addActionListener(e -> {
            int student_id = Integer.parseInt(txtwyszukaj.getText());
            StudentCRUD studentCRUD = new StudentCRUD();
            studentCRUD.deleteStud(student_id);
            viewStud();
            wyczyscPola();
        });
        btnWyszukaj.addActionListener(e -> {
            try {
                int student_id = Integer.parseInt(txtwyszukaj.getText());
                StudentCRUD studentCRUD = new StudentCRUD();
                ResultSet result = studentCRUD.searchStud(student_id);

                if (result != null && result.next()) {
                    txtstudid.setText(String.valueOf(result.getInt("student_id")));
                    txtimie.setText(result.getString("imie"));
                    txtnazwisko.setText(result.getString("nazwisko"));
                    txtlogin.setText(result.getString("login"));
                    txthaslo.setText(result.getString("haslo"));
                    txtemail.setText(result.getString("email"));
                    txtrok.setText(String.valueOf(result.getInt("rok")));
                } else {
                    JOptionPane.showMessageDialog(Studenci.this, "Nie znaleziono studenta o podanym ID.",
                            "Brak wyników", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Studenci.this, "Podaj prawidłowy numer studenta (liczbę całkowitą).",
                        "Błąd", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Studenci.this, "Wystąpił błąd podczas wyszukiwania studenta.",
                        "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnWroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow > 0) {
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();

                    String student_id = model.getValueAt(selectedRow, 0).toString();
                    String imie = model.getValueAt(selectedRow, 1).toString();
                    String nazwisko = model.getValueAt(selectedRow, 2).toString();
                    String login = model.getValueAt(selectedRow, 3).toString();
                    String haslo = model.getValueAt(selectedRow, 4).toString();
                    String email = model.getValueAt(selectedRow, 5).toString();
                    String rok = model.getValueAt(selectedRow, 6).toString();

                    txtstudid.setText(student_id);
                    txtimie.setText(imie);
                    txtnazwisko.setText(nazwisko);
                    txtlogin.setText(login);
                    txthaslo.setText(haslo);
                    txtemail.setText(email);
                    txtrok.setText(rok);
                }
            }
        });
    }
    public void viewStud() {
        StudentCRUD studentCRUD = new StudentCRUD();
        ResultSet result = studentCRUD.infoStudent();

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
        txtstudid.setText("");
        txtimie.setText("");
        txtnazwisko.setText("");
        txtlogin.setText("");
        txthaslo.setText("");
        txtemail.setText("");
        txtrok.setText("");
        txtwyszukaj.setText("");
    }


}
