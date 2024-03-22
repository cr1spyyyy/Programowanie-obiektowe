package Figers;

public class Kula {
    private double r;
    private String name;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double pole(double r){ return 4*Math.PI*Math.pow(r,2);}
    private double objetosc(double r){ return (4*Math.PI*Math.pow(r,3))/3;}
    public void view(){
        System.out.format("Figura: %s, promien: %.2f, pole: %.2f, objetosc: %.2f\n",
                name, r, pole(r), objetosc(r));
    }
}
