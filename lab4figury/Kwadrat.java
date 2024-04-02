public class Kwadrat extends Prostokat{

    public Kwadrat(double bok, double x, double y) {
        super(bok, bok , x, y);
    }
    public double getBok(){
        return szer;
    }
    public void setBok(double bok){
        setSzer(bok);
        setWys(bok);
    }
}
