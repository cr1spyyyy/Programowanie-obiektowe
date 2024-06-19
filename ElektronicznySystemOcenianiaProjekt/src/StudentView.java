import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentView extends JFrame {
    private JTable table1;
    private JPanel studPanel;
    private JLabel powitanieLabel;
    private JButton btnWyloguj;
    private int width = 700, height = 500;
    private int student_id;
    public StudentView(int student_id){
        super("Elektroniczny system oceniania");
        this.student_id = student_id;
        this.setContentPane(this.studPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Przedmiot");
        model.addColumn("Ocena");
        table1.setModel(model);

        viewOceny();

        this.setVisible(true);
        btnWyloguj.addActionListener(e -> {
            new WyborLogowania();
            dispose();
        });
    }
    public void viewOceny() {
        String student = "SELECT imie, nazwisko FROM studenci WHERE student_id = ?";
        String oceny = "SELECT p.nazwa AS Przedmioty, GROUP_CONCAT(FORMAT(o.ocena, 1) ORDER BY o.ocena SEPARATOR ', ') AS Oceny " +
                "FROM oceny o " +
                "JOIN przedmioty p ON o.przedmiot_id = p.przedmiot_id " +
                "WHERE o.student_id = ? " +
                "GROUP BY p.nazwa";

        try (Connection con = DBpolaczenie.getConnection()) {
            try (PreparedStatement studentStmt = con.prepareStatement(student)) {
                studentStmt.setInt(1, student_id);
                ResultSet studentResult = studentStmt.executeQuery();

                if (studentResult.next()) {
                    String imie = studentResult.getString("imie");
                    String nazwisko = studentResult.getString("nazwisko");
                    powitanieLabel.setText("Witaj, " + imie + " " + nazwisko );
                } else {
                    powitanieLabel.setText("Nie znaleziono studenta.");
                }
            }

            try (PreparedStatement ocenyStmt = con.prepareStatement(oceny)) {
                ocenyStmt.setInt(1, student_id);
                ResultSet ocenyRs = ocenyStmt.executeQuery();

                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                while (ocenyRs.next()) {
                    Object[] row = new Object[2];
                    row[0] = ocenyRs.getString("Przedmioty");
                    row[1] = ocenyRs.getString("Oceny");
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            powitanieLabel.setText("Nie udało połączyć się z bazą danych.");
        }
    }

}
