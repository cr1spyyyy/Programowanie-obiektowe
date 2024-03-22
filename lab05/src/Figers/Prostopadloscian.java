package Figers;

public class Prostopadloscian {
    private double a;
    private double b;
    private double c;
    private String name;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private double pole(double a,double b, double c){
        return 2*a*b+2*a*c+2*b*c;
    }
    private double objetosc(double a,double b, double c){
        return a*b*c;
    }
    public void view(){
        System.out.format("Nazwa figury: %s, Dlugosc boku A: %.2f, Dlugosc boku B: %.2f, Dlugosc boku C: %.2f," +
                        " Pole powierzchni: %.2f, Objetosc: %.2f\n",
                name, a, b ,c , pole(a,b,c), objetosc(a,b,c));
    }
}
