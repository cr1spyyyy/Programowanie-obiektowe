public class PayPal implements MetodaPlatnosci{
    private String haslo;
    private String email;

    @Override
    public void zaplac(double kwota) {
        System.out.println("Platnosc PayPal na kwote: "+ kwota);
    }
}
