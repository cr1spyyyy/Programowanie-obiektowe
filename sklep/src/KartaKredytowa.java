public class KartaKredytowa implements MetodaPlatnosci{
    private String numerKarty;
    private String dataWaznosci;
    private String cvv;


    @Override
    public void zaplac(double kwota) {
        System.out.println("Platnosc karta kredytowa na kwote: "+kwota);

    }
}
