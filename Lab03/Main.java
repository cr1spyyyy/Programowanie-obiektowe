import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("Podaj liczbe studentow");                             zadanie 1
        int n = scanner.nextInt();
        System.out.println("podaj liczbe punktow kazdego z " + n + " studentow");
        int i = 1;
        int suma = 0;
        while(i <= n){
            System.out.println("liczbe punktow dla "+ i + " studentda");
            int p = scanner.nextInt();
            suma += p;
            i++;
        }
        System.out.println("srednia liczba punktow w grupie to: "+(suma/n));*/



        /*System.out.println("podaj 10 liczb: ");                           zadanie 2
        int sumau = 0;
        int sumad = 0;
        int lu = 0;
        int ld = 0;
        for(int i=1;i<=10;i++){
            System.out.println("podaj liczbe "+i);
            int liczba = scanner.nextInt();
                if(liczba<0){
                    sumau += liczba;
                    lu++;
                }
                else{
                    sumad +=liczba;
                    ld++;
                }
        }
        System.out.println("liczba liczb ujemnych: "+ lu + " suma liczb ujemnych: "+ sumau );
        System.out.println("liczba liczb dodatnich: "+ ld + " suma liczb dodatnich: "+ sumad );*/


        /*System.out.println("podaj dlugosc ciagu liczb");                  zadanie 3
        int n = scanner.nextInt();
            if(n<0){
                System.out.println("podaj liczbe naturalna (0-nieskonczonosc)");
            }
        int suma = 0;
        for(int i=0;i<=n;i++){
            if(i%2==0){
                //System.out.println(i+" "); pokazuje liczby wchodzace do sumy
                suma+=i;
            }
        }
        System.out.println("suma liczb parzystych z przedzialu od 0 do"+ n +" wynosi: "+suma);*/



        /*Random rand = new Random();                                       zadanie 4
        System.out.println("ile chcesz wylosowac liczb?");
        int n = scanner.nextInt();
        int a = 0;
        int suma = 0;
        for(int i=0;i<=n;i++){
            a = rand.nextInt(46)-7;
            System.out.println(a);
            if(a%2==0){
                suma+=a;
            }
        }
        System.out.println("suma liczb parzystych z przedzialu od -10 do 45 to "+ suma);*/

/*        System.out.println("podaj slowo: ");              zadanie 5
        String slowo = scanner.nextLine();
        if(palindrom(slowo)){
            System.out.println(slowo+ " jest palindromem");
        }
        else{
            System.out.println(slowo+ " nie jest palindromem");
        }*/


    }
/*    public static boolean palindrom(String slowo){         metoda do zadania 5
        int dlugosc = slowo.length();
        for(int i=0;i< dlugosc/2;i++){
            if(slowo.charAt(i) != slowo.charAt(dlugosc -1 -i)){
                return false;
            }
        }
        return true;
    }*/
}