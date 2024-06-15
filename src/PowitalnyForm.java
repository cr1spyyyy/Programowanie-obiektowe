import javax.swing.*;

public class PowitalnyForm extends JFrame{
    private JProgressBar pasekLadowania;
    private JLabel lblProszeCzekac;
    private JPanel StartowyForm;
    private JLabel textLadowanie;

    private int width = 400, height = 300;
    public PowitalnyForm(){
        super("Ładowanie systemu...");
        this.setContentPane(this.StartowyForm);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        ladowanie();
    }
    private void ladowanie(){
        int counter = 0;
        while (counter <= 100){
            lblProszeCzekac.setText("Proszę czekać...");
            pasekLadowania.setValue(counter);
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            counter+=5;
            if(counter>50){
                textLadowanie.setText("Inicjalizacja...");
            }
        }
        dispose();
        new WyborLogowania();
    }
}
