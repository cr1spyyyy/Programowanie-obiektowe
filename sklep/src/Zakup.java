public class Zakup extends Transakcja{
    public Zakup(MetodaPlatnosci metodaPlatnosci) {
        super(metodaPlatnosci);
    }

    @Override
    public void przetworzTransakcje(double kwota) {
        metodaPlatnosci.zaplac(kwota);
        potwierdzTransakcje();
    }
}
