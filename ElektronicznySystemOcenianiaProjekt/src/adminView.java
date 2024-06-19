import javax.swing.*;

public class adminView extends JFrame{
    private JPanel adminPanel;
    private JButton btnStudenci;
    private JButton btnWykladowcy;
    private JButton btnPrzedmioty;
    private JButton btnOceny;
    private JButton btnWyjscie;
    private JButton btnWyloguj;
    private int width = 600, height = 400;
    public adminView() {
        super("Elektroniczny system oceniania");
        this.setContentPane(this.adminPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        btnStudenci.addActionListener(e -> new Studenci());
        btnWykladowcy.addActionListener(e -> new Wykladowcy());
        btnPrzedmioty.addActionListener(e -> new Przedmioty());
        btnOceny.addActionListener(e -> new Oceny());
        btnWyloguj.addActionListener(e -> {
            new WyborLogowania();
            dispose();
        });
        btnWyjscie.addActionListener(e -> dispose());
    }
}
