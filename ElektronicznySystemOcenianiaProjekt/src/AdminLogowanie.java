import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogowanie extends JFrame{
    private JPanel AdminLog;
    private JTextField loginA;
    private JPasswordField hasloA;
    private JButton btnWstecz;
    private JButton btnZaloguj;
    private int width = 600, height = 400;
    String login="admin", haslo="admin";
    public AdminLogowanie(){
        super("Logowanie jako admin");
        this.setContentPane(this.AdminLog);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        btnWstecz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WyborLogowania();
                dispose();
            }
        });

        btnZaloguj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginInput = loginA.getText();
                String hasloInput = new String(hasloA.getPassword());
                if(loginInput.equals(login) && hasloInput.equals(haslo)){
                    new adminView();
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Podano błędny login lub hasło!",
                            "Błąd logowania!", JOptionPane.ERROR_MESSAGE);
                    loginA.setText("");
                    hasloA.setText("");
                }

            }
        });
    }
}
