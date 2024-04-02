
class Prostokat extends Figura {
	double wys=0, szer=0;
	Point point;
	Prostokat(double wys,double szer){
		this.wys = wys;
		this.szer = szer;
			
	}

    double getPowierzchnia() {
        return (szer * wys);
    }

	public double getWys() {
		return wys;
	}

	public void setWys(double wys) {
		this.wys = wys;
	}

	public double getSzer() {
		return szer;
	}

	public void setSzer(double szer) {
		this.szer = szer;
	}

	public void przesun(double x, double y){
		point.setX(point.getX()+x);
		point.setY(point.getY()+y);
	}

	public Prostokat(double wys, double szer, double x, double y) {
		this.wys = wys;
		this.szer = szer;
		this.point = new Point(x,y);
	}

	public void infromacje(){
		System.out.format("Prostokat: x: %.2f, y: %.2f, wysokosc: %.2f, szerokosc: %.2f\n", point.getX(),point.getY(),wys,szer);
	}
}