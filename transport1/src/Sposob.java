public class Sposob extends SrodekTransportu{

    public Sposob(Jedzie jedzie) {
        super(jedzie);
    }

    public Sposob(Plywa plywa) {
        super(plywa);
    }

    public Sposob(Lata lata) {
        super(lata);
    }

    @Override
    public void wybranySrodek(String srodek) {
        switch (srodek){
            case "jedzie"->{
                jedzie.jedz(srodek);
                potwierdzenieWyboru();
                break;
            }
            case "lata"->{
                lata.lec(srodek);
                potwierdzenieWyboru();
                break;
            }
            case "plywa"->{
                plywa.plyn(srodek);
                potwierdzenieWyboru();
                break;
            }
            default->{
                System.out.println("blad");
                break;
            }
        }

    }

}
