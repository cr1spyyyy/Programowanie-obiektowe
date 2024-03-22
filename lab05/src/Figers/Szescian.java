package Figers;

public class Szescian {
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
        return 6*Math.pow(a,2);
    }
    private double objetosc(double a){
        return a*3;
    }
    public void view(){
        System.out.format("Nazwa figury: %s, Dlugosc boku: %.2f, Pole powierzchni: %.2f, Objetosc: %.2f\n",
                name, a, pole(a), objetosc(a));
    }
}
