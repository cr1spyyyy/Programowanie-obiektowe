public abstract class SrodekTransportu {
    protected Jedzie jedzie;
    protected Plywa plywa;
    protected Lata lata;

    public SrodekTransportu(Jedzie jedzie) {
        this.jedzie = jedzie;
    }

    public SrodekTransportu(Plywa plywa) {
        this.plywa = plywa;
    }

    public SrodekTransportu(Lata lata) {
        this.lata = lata;
    }

    public abstract void wybranySrodek(String srodek);
    protected void potwierdzenieWyboru(){
        System.out.println("dobry wybor!");
    }
}
