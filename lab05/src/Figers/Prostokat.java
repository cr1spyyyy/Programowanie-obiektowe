package Figers;

public class Prostokat {
    private double a;
    private double b;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private double pole(double a,double b){
        return a*b;
    }
    private double obwod(double a,double b){
        return 2*a+2*b;
    }
    public void view(){
        System.out.format("Figura: %s, Dlugosc boku A: %.2f, Dlugosc boku B: %.2f, Pole: %.2f, Obwod: %.2f \n",
                name, a, b, pole(a,b), obwod(a,b));
    }
}
