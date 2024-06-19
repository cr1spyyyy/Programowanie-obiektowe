import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WykladowcaLogowanie extends JFrame {
    private int width = 600, height = 400;
    private JTextField loginW;
    private JPasswordField hasloW;
    private JButton btnWstecz;
    private JButton btnZalouj;
    private JPanel wykladowcaLog;

    public WykladowcaLogowanie(){
        super("Logowanie jako wykładowca");
        this.setContentPane(this.wykladowcaLog);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        btnWstecz.addActionListener(e -> {
            WyborLogowania wyborLogowania = new WyborLogowania();
            wyborLogowania.setVisible(true);
            dispose();
        });
        btnZalouj.addActionListener(e -> {
            String login = loginW.getText();
            String haslo = new String(hasloW.getPassword());
            int wykladowca_id = logowanie(login, haslo);

            if(wykladowca_id != 0){
               new WykladowcaView(wykladowca_id);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Podano błędny login lub hasło!",
                        "Bład logowania", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private int logowanie(String login, String haslo){
        String sql = "SELECT wykladowca_id FROM wykladowcy WHERE login = ? AND haslo = ?";
        try (Connection con = DBpolaczenie.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, haslo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("wykladowca_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
