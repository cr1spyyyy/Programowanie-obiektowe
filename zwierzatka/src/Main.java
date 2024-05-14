//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Wieloryb wieloryb = new Wieloryb();
        Bocian bocian = new Bocian();
        wieloryb.plyn();
        wieloryb.wynurz();
        wieloryb.zanurz();
        wieloryb.jedz();
        wieloryb.wydalaj();
        System.out.println("-----------");
        bocian.lec();
        bocian.wyladuj();
        bocian.jedz();
        bocian.wydalaj();
    }
}