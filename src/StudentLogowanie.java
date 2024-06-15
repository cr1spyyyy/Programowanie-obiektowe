import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLogowanie extends JFrame {

    private JPanel studentLog;
    private JTextField loginS;
    private JPasswordField hasloS;
    private JButton btnWstecz;
    private JButton btnZaloguj;

    private int width = 600, height = 400;

    public StudentLogowanie(){
        super("Logowanie jako student");
        this.setContentPane(this.studentLog);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        btnWstecz.addActionListener(e -> {
            WyborLogowania wyborLogowania = new WyborLogowania();
            wyborLogowania.setVisible(true);
            dispose();
        });

        btnZaloguj.addActionListener(e -> {
            String login = loginS.getText();
            String haslo = new String(hasloS.getPassword());
            int student_id = logowanie(login, haslo);

            if(student_id != 0){
                new StudentView(student_id);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Podano błędne dane!", "Bład logowania",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
    }
    private int logowanie(String login, String haslo){
        String sql = "SELECT student_id FROM studenci WHERE login = ? AND haslo = ?";
        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, haslo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("student_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
