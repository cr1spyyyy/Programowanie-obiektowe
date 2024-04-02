import java.util.Scanner;

public class Samochod {
    String marka;
    String model;
    String nadwozie;
    String kolor;
    double rokProd;
    double przebieg;


    public Samochod(String marka, String model, String nadwozie, String kolor, double rokProd, double przebieg) {
        this.marka = marka;
        this.model = model;
        this.nadwozie = nadwozie;
        this.kolor = kolor;
        this.rokProd = rokProd;
        this.przebieg = przebieg;
    }
    public Samochod(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj marke samochodu: ");
        this.marka = scanner.nextLine();
        System.out.println("Podaj model samochodu: ");
        this.model = scanner.nextLine();
        System.out.println("Podaj nadwozie samochodu: ");
        this.nadwozie = scanner.nextLine();
        System.out.println("Podaj kolor samochodu: ");
        this.kolor = scanner.nextLine();
        System.out.println("Podaj rok produkcji samochodu: ");
        this.rokProd = scanner.nextDouble();
        System.out.println("Podaj przebieg samochodu: ");
        this.przebieg = scanner.nextDouble();
        while(przebieg<0){
            System.out.println("przebieg nie moze byc ujemny!");
            System.out.println("Podaj przebieg samochodu: ");
            this.przebieg = scanner.nextDouble();
        }
    }
    public void info(){
        System.out.println("Marka: "+marka+"\nModel: "+ model+"\nNadwozie: "+nadwozie+
                "\nKolor: "+kolor+"\nRok produkcji: "+rokProd+"\nPrzebieg: "+przebieg);
    }
}
