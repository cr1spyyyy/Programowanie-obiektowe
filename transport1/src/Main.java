public class Main {
    public static void main(String[] args) {
        Plywa plywa = new Statek();
        Lata lata = new Samolot();
        Jedzie jedzie = new Samochod();

        SrodekTransportu autko = new Sposob(jedzie);
        autko.wybranySrodek("jedzie");

        SrodekTransportu samolocik = new Sposob(lata);
        samolocik.wybranySrodek("lata");

        SrodekTransportu statek = new Sposob(plywa);
        statek.wybranySrodek("plywa");


    }
}