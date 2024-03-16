import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*System.out.println("podaj wielkosc tablicy");                 zadanie 1
        int n = scanner.nextInt();
        int[] tab = new int[n];
        for(int i : tab){
            tab[i]=losuj();
            System.out.println(tab[i]);
        }
        int suma=0;
        for(int i=0;i < n; i++){
            suma+=tab[i];
        }
        System.out.println("suma wszystkich elementow tablicy wynosi: "+ suma);
        System.out.println("srednia elementow tablicy: "+(suma/n));*/

        /*int[] tab1 = {20,30,-20,23482,234,-22,21312,432};                 zadanie 2
        int[] tab2 = {324,32213,12,3213,342,45,67,7,67,456,13};
        int dlugosc1 = tab1.length;
        int dlugosc2 = tab2.length;
        System.out.println("parzyste elementy pierwszej tbalicy");
        for(int i=0;i< dlugosc1;i++){
            if(tab1[i]%2==0){
                System.out.println(tab1[i]);
            }
        }
        System.out.println("parzyste elementy drugiej tbalicy");
        for(int i=0;i< dlugosc2;i++){
            if(tab2[i]%2==0){
                System.out.println(tab2[i]);
            }
        }*/


/*        String[] tab = new String[5];                         zadanie 3
        System.out.println("podaj elementy tablicy");
        for(int i=0;i<5;i++){
            System.out.println("podaj "+(i+1)+" slowo");
            String slowo = scanner.nextLine();
            tab[i] = slowo;
        }
        System.out.println("tablica z powiekszonymi znakami");
        for(String i : tab){
            System.out.println(i.toUpperCase());
        }*/

/*        String[] tab = new String[5];                     zadanie 4
        String[] tab2 = new String[5];
        for(int i=0;i<5;i++){
            System.out.println("podaj slowo "+(i+1));
            tab[i] = scanner.nextLine();
        }
        for(int i = 4; i>=0;i--){ //odwrocona kolejnosc w tablicy
            tab2[i] = new StringBuilder(tab[i]).reverse().toString(); // tworzenie stringa(istniejacy string).odwracanie.do stringa
            System.out.println(tab2[i]);
        }*/


        /*        int[] tab = new int[5];                           zadanie 6
        int[] tab2 = new int[5];
        for(int i = 0;i<5;i++){
            System.out.println("podaj "+(i+1)+" liczbe");
            int liczba = scanner.nextInt();
            tab[i]=liczba;
        }

        for(int i = 0;i<5;i++){
            int wartosc = tab[i];
            tab2[i]=silnia(wartosc);
        }
        for(int i : tab2){
            System.out.println(i);
        }*/




        /*        String[] tab1 = new String[3];                            zadanie 7
        String[] tab2 = new String[3];
        for(int i=0;i<3;i++){
            System.out.println("podaj "+(i+1)+" wyraz 1 tablicy");
            String wyraz = scanner.nextLine();
            tab1[i]=wyraz;
        }
        for(int i=0;i<3;i++){
            System.out.println("podaj "+(i+1)+" wyraz 2 tablicy");
            String wyraz = scanner.nextLine();
            tab2[i]=wyraz;
        }
        if(porownanie(tab1, tab2)){
            System.out.println("tablice sa takie same");
        }
        else {
            System.out.println("tablice nie sa takie same");
        }*/

        
    }


    /*            public static boolean porownanie(String[] tab1, String[] tab2){           zadanie 7 porownanie tablic
                int d1 = tab1.length;
                int d2 = tab1.length;
                if(!(d1==d2)){
                    return false;
                }

                for(int i = 0; i<d1;i++){
                    if(!tab1[i].equals(tab2[i])){
                        return false;
                    }
                }
                return true;
            }*/


    
/*        public static int silnia(int wartosc){                zadanie 6 oblicznaie silni
            if(wartosc==0){
                return 1;
            }
            else{
                return wartosc*silnia(wartosc-1);
            }

        }*/

/*    public static int losuj(){                            metoda losujaca do zadania 1
        Random random = new Random();
        return random.nextInt();
    }*/


}
