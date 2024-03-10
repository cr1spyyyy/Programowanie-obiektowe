import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
/*                Scanner scanner = new Scanner(System.in);             zadanie 1
                System.out.println("podaj a: ");
                double a = scanner.nextDouble();
                System.out.println("podaj b: ");
                double b = scanner.nextDouble();
                System.out.println("podaj c: ");
                double c = scanner.nextDouble();
                miejscaZer(a,b,c);*/

/*                Scanner scanner = new Scanner(System.in);         zadanie 2
                System.out.println("podaj liczbe: ");
                int x = scanner.nextInt();
                funkcja1(x);
                funkcja2(x);
                funkcja3(x);*/


/*                Scanner scanner = new Scanner(System.in);             zadanie 3
                System.out.println("podaj liczbe x: ");
                int x = scanner.nextInt();
                System.out.println("podaj liczbe y: ");
                int y = scanner.nextInt();
                System.out.println("podaj liczbe z: ");
                int z = scanner.nextInt();
                poarzadkowanie(x,y,z);*/

/*                Scanner scanner = new Scanner(System.in);                 zadanie 4
                System.out.println("Pada deszcz? tak/nie");
                String pada = scanner.nextLine();
                boolean parasol = pada.equals("tak")? true : false;
                System.out.println("Czy na przystanku jest autobus? tak/nie");
                String jest = scanner.nextLine();
                boolean autobus = jest.equals("tak")? true : false;
                cozrobic(parasol, autobus);*/


/*                Scanner scanner = new Scanner(System.in);                                 zadanie 5 
                System.out.println("Posiadasz znizke?");
                String czyZni = scanner.nextLine();
                boolean znizka = czyZni.equals("tak")? true : false;
                System.out.println("Orzymales premie?");
                String czyPre = scanner.nextLine();
                boolean premia = czyPre.equals("tak")? true :false;
                kupnoAuta(znizka, premia);*/


/*                Scanner scanner = new Scanner(System.in);                                                         zadanie 6
                    System.out.println("Podaj pierwsza liczbe: ");
                    int liczba1 = scanner.nextInt();
                    System.out.println("Podaj druga liczbe: ");
                    int liczba2 = scanner.nextInt();
                    System.out.println("Co chcesz z tymi liczbami zrobic? Wpisz odpowiedni znak: ");
                    System.out.println("+ - dodawanie; - - odejmowanie; * - iloczyn; / - iloraz; % - reszta z dzielenia");
                    String znak = scanner.next();
                    kalkulator(liczba1, liczba2, znak);*/


            } // koniec main

/*                public static void kalkulator(int liczba1, int liczba2, String znak){                             zadanie 6
                        switch (znak){
                            case "+":
                                System.out.println(liczba1 + " + " + liczba2 + " = "+(liczba1+liczba2));
                                break;
                            case "-":
                                System.out.println(liczba1 + " - " + liczba2 + " = "+(liczba1-liczba2));
                                break;
                            case "*":
                                System.out.println(liczba1 + " * " + liczba2 + " = "+(liczba1*liczba2));
                                break;
                            case "/":
                                System.out.println(liczba1 + " / " + liczba2 + " = "+(liczba1/liczba2));
                                break;
                            case "%":
                                System.out.println(liczba1 + " % " + liczba2 + " = "+(liczba1%liczba2));
                                break;
                            default:
                                System.out.println("podaj odpowiedni znak");
                        }
                }*/

/*                public static void kupnoAuta(boolean znizka, boolean premia){            zadanie 5
                       if(!znizka){
                           if(premia){
                               System.out.println("mozesz kupic samochod");
                               System.out.println("znizki na samochod nie ma");
                           }
                           else if(!premia){
                               System.out.println("zakup samochodu trzeba odlozyc na pozniej");
                               System.out.println("znizki na samochod nie ma");
                           }
                       }
                       else if(znizka || premia){
                           System.out.println("mozesz kupic samochod");
                       }
               }
               }*/

/*                public static void cozrobic(boolean parasol, boolean autobus){            zadanie 4
                        if(parasol && autobus){
                            System.out.println("Wez parasol, dostaniesz sie na uczelnie");
                        }
                        else if(parasol && !autobus){
                            System.out.println("nie dostnaiessz sie na uczelnie");
                        }
                        else{
                            System.out.println("dostaniesz sie na uczelnie, milego dnia i pieknej pogody");
                        }
                }*/


/*            public static void poarzadkowanie(int x, int y, int z){               zadanie 3
                if(x<=z && x<=y){
                    if(z<=y){
                        System.out.println("Liczby od najmniejszej do najwiekszej: "+ x +" "+ z +" "+y);
                    }
                    else{
                        System.out.println("Liczby od najmniejszej do najwiekszej: "+ x +" "+ y +" "+ z);
                    }
                }
                else if(y<=x && y<=z){
                    if(x<=z){
                        System.out.println("Liczby od najmniejszej do najwiekszej: "+y+" "+x+" "+z);
                    }
                    else{
                        System.out.println("Liczby od najmniejszej do najwiekszej: "+ y +" "+ z+" "+x);
                    }
                }
                else{
                    if(x<=y){
                        System.out.println("Liczby od najmniejszej do najwiekszej: "+ z+" "+ x+" "+y);
                    }
                    else{
                        System.out.println("Liczby od najmniejszej do najwiekszej: "+ z+" "+ y +" "+x);
                    }
                }
            }*/

/*    public static void miejscaZer(double a, double b ,double c){      zadanie 1
            double delta = b*b-4*a*c;
            if(delta>0){
                double pierwzdel = Math.sqrt(delta);
                double x1 = (-b-pierwzdel)/(2*a);
                double x2 = (-b+pierwzdel)/(2*a);
                System.out.println("Rozwiazaniami sa: "+x1+" oraz "+x2);
            }
            else if(delta==0){
                double x1 = -b/(2*a);
                System.out.println("Jedynym rozwiazaniem jest: "+x1);
            }
            else{
                System.out.println("podane rownanie nie ma rozwiazan");
            }
    }*/

/*    public static void funkcja1(int x){                           zadanie 2
            if(x>0){
                System.out.println("x>0, 2x= "+ (2*x));
            }
            else if(x==0){
                System.out.println("x=0, 0 = "+x);
            }
            else{
                System.out.println("x<0, -3x = "+ (-3*x));
            }
    }
    public static void funkcja2(int x){
            if(x>=1){
                System.out.println("x>=1, x^2= "+ (x*x));
            }
            else{
                System.out.println("x<1, x = "+x);
            }
    }
    public static void funkcja3(int x){
            if(x>0){
                System.out.println("x>2, 2+x= "+ (2+x));
            }
            else if(x==0){
                System.out.println("x=2, 8 = 8");
            }
            else{
                System.out.println("x<2, x-4 = "+ (x-4));
            }
    }*/


}


