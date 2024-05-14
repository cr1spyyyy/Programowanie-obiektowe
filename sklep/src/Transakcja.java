public abstract class Transakcja {
    protected MetodaPlatnosci metodaPlatnosci;

    public Transakcja(MetodaPlatnosci metodaPlatnosci) {
        this.metodaPlatnosci = metodaPlatnosci;
    }
    public abstract void przetworzTransakcje(double kwota);
    protected void potwierdzTransakcje(){
        System.out.println("Transakcja zostala potwierdzona");
    }
}
