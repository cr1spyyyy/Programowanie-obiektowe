import javax.swing.*;

public class WyborLogowania extends JFrame {
    private JPanel wyborLogowania;
    private JButton btnStudent;
    private JButton btnWykladowca;
    private JButton btnAdmin;

    private int width = 660, height = 400;
    public WyborLogowania(){
        super("Wybierz konto");
        this.setContentPane(this.wyborLogowania);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        btnStudent.addActionListener(e -> {
            new StudentLogowanie();
            dispose();
        });
        btnWykladowca.addActionListener(e -> {
            new WykladowcaLogowanie();
            dispose();
        });
        btnAdmin.addActionListener(e -> {
            new AdminLogowanie();
            dispose();
        });
    }

}
