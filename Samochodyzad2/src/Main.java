//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SamochodOsobowy samochodosobowy = new SamochodOsobowy();
        samochodosobowy.info();
        Samochod samochod = new Samochod();
        Samochod smaochod2 = new Samochod("Volkswagen", "golf", "miejski", "ciorny", 2006, 32423423);
        System.out.println("\ninfor o 1 aucie");
        samochod.info();
        System.out.println("\ninfo o 2 aucie");
        smaochod2.info();
    }
}