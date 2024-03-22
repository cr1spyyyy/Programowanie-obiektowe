package Figers;

public class Stozek {
    private double r;
    private double l;
    private double h;
    private String name;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private double pole(double r, double l){
        return Math.PI*r*(r+l);
    }
    private double objetosc(double r, double h){
        return (Math.PI*Math.pow(r,2)*h)/3;
    }
    public void view(){
        System.out.format("Figura: %s, promien: %.2f, wysokosc: %.2f, l: %.2f,  pole: %.2f, objetosc: %.2f\n",
                name, r, h, l, pole(r, l), objetosc(r,h));
    }
}
