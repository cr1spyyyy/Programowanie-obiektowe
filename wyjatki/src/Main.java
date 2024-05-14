import java.util.InputMismatchException;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double liczba;
//        try{
//            System.out.println("Podaj liczbe");
//            liczba = scanner.nextDouble();
//            if(liczba<0){
//                throw new IllegalArgumentException("nie mozna obliczyc pierwiastka");
//            }
//            System.out.println(Math.sqrt(liczba));
//        }
//        catch(IllegalArgumentException e){
//            System.out.println("blad"+e.getMessage());
//        }
//        catch(InputMismatchException e){
//            System.out.println("blad podano ciag znakow");
//        }

        try{
            System.out.println("Podaj liczbe z ktorej obliczynmy silnie");
            int liczba1= scanner.nextInt();
            System.out.println(silnialicz(liczba1));
        }
        catch(BlednaWartoscDlaSilniException e){
            System.out.println(e.getMessage());
        }

    }
    public static int silnialicz(int liczba) throws BlednaWartoscDlaSilniException{
        if(liczba<0){
            throw new BlednaWartoscDlaSilniException("nieodpowiednia liczba");
        }

        int silnia=1;
        for(int i=1;i<=liczba;i++){
            silnia*=i;
        }
        return silnia;
    }

}