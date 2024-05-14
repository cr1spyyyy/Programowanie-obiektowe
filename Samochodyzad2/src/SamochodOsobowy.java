import java.util.Scanner;

public class SamochodOsobowy extends Samochod{
    double waga;
    double pojSil;
    double iloscOsob;


    public SamochodOsobowy(String marka, String model, String nadwozie, String kolor, double rokProd, double przebieg, double waga, double pojSil, double iloscOsob) {
        super(marka, model, nadwozie, kolor, rokProd, przebieg);
        this.waga = waga;
        this.pojSil = pojSil;
        this.iloscOsob = iloscOsob;
    }
    public SamochodOsobowy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wage: ");
        this.waga = scanner.nextDouble();
        while(waga<2 || waga>4.5){
            System.out.println("Podana waga jest poza przedzialem 2.0t - 4.5t!");
            System.out.println("Podaj wage: ");
            this.waga = scanner.nextDouble();
        }
        System.out.println("Podaj pojemnsoc silnika: ");
        this.pojSil = scanner.nextDouble();
        while(pojSil<0.8 || pojSil>3.0){
            System.out.println("Podana pojemnosc nie istnieje podaj odpowiednia z przedizalu 0.8 - 3.0");
            System.out.println("Podaj pojemnsoc silnika: ");
            this.pojSil = scanner.nextDouble();
        }
        System.out.println("Podaj islosc osob: ");
        this.iloscOsob = scanner.nextDouble();

    }
    public void info(){
        super.info();
        System.out.println("\nWaga: "+waga+"\nPojemnosc silnika: "+pojSil+
                "\nIlosc osob ktora pomiesci samochod: "+ iloscOsob);
    }
}
