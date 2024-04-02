public class Main {
    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(),
                new Point(2.4,8),
                new Point(-2.5,3)
        };
        Figura figura = new Figura();
        System.out.println(figura.opis());
        Prostokat prostokat = new Prostokat(20,15,10,20);
        System.out.println("Pole prostokata: "+ prostokat.getPowierzchnia());

        Trojkat trojkat = new Trojkat(23,56);

        prostokat.infromacje();
        prostokat.przesun(3,5);
        prostokat.infromacje();

        Kwadrat kwadrat = new Kwadrat(5,10,10);
        

    }
}
