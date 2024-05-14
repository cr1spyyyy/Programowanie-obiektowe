public class Main {
    public static void main(String[] args) {
            MetodaPlatnosci payPal = new PayPal();
            MetodaPlatnosci kartakredytowa = new KartaKredytowa();
            Transakcja zakupPayPal = new Zakup(payPal);
            zakupPayPal.przetworzTransakcje(100);
            Transakcja zakupKarta = new Zakup(kartakredytowa);
            zakupKarta.przetworzTransakcje(200);
    }
}