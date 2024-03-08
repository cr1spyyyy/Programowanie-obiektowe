import java.util.Scanner;

public static void main(String[] args) {
    //System.out.println(imie()+" "+wiek());                    zadanie 1

/*    System.out.println("Podaj liczbe a: ");                   zadanie 2
    int a = InputIn();
    System.out.println("Podaj liczbe b: ");
    int b = InputIn();
    obliczenia(a,b);*/

/*    System.out.println("podaj liczbe");                       zadanie 3
    int a = InputIn();
    czyparzysta(a);*/

/*    System.out.println("podaj liczbe");                       zadanie 5
    double a = InputIn();
    System.out.println(a+" do potegi 3 to: "+ potega(a));*/

/*    System.out.println("podaj liczbe");                       zadanie 6
    double  a = InputIn();
    System.out.println("pierwiastek z liczby "+ a +" to "+ pierw(a));*/

    /*System.out.println("podaj liczbe a: ");                   zadanie 7
    int liczba1 = InputIn();
    System.out.println("podaj liczbe b: ");
    int liczba2 = InputIn();

    int a = losuj(liczba1, liczba2);
    int b = losuj(liczba1, liczba2);
    int c = losuj(liczba1, liczba2);
    System.out.println("liczba 1 "+a);
    System.out.println("liczba 2 "+b);
    System.out.println("liczba 3 "+c);
    czytrojkat(a,b,c);*/

} //koniec main

    /*public static void czytrojkat(int a, int b, int c){       zadanie7
     if(a+b>c && b+c>a && a+c>b){
         System.out.println("mozna utworzyc trojkat");
     }
     else{
         System.out.println("nie mozna utworzyc trojkatu");
     }
    }
    public static int losuj(int liczba1, int liczba2){
       Random random = new Random();
       return random.nextInt(liczba2-liczba1+1)+liczba1;
    }*/

/*    public static double pierw(double a){                     zadaniee 6
        return Math.sqrt(a);
    }*/


/*    public static void czyparzysta(int a){                    zadanie 4
        if(a%2==0){
            System.out.println("liczba: "+a+" jest parzysta");
        }
        else{
            System.out.println("liczba "+a+" jest nieparzysta");
        }
    }*/

/*    public static double potega(double a){                    zadanie 5
        return Math.pow(a, 3);
    }*/

/*public static void obliczenia(int a, int b){                  zadanie 2
    System.out.println("suma");
    System.out.println(a+" + "+b+" = "+ (a+b));
    System.out.println("roznica");
    System.out.println(a+" - "+b+" = "+ (a-b));
    System.out.println("suma");
    System.out.println(a+" * "+b+" = "+ (a*b));
}*/
public static int InputIn(){
    Scanner scanner = new Scanner(System.in);
    int liczba = scanner.nextInt();
    return liczba;
}

/*                                                              zadanie 1
public static String imie(){
    return "michal";
}
public static int wiek(){
    return 20;
}*/
