package Figers;

public class Kwadrat {
    private double a;
    private String name;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double pole(double a){
        return Math.pow(a,2);
    }
    private double obwod(double a){
        return a*4;
    }
    public void view(){
        System.out.format("Figura: %s, Dlugosc boku: %.2f, Pole: %.2f, Obwod: %.2f \n",
                name, a, pole(a), obwod(a));
    }
}
