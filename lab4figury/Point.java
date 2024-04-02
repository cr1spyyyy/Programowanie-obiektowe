public class Point {
    public double x,y;

    public Point() {
        this.x=0.0;
        this.y=0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void zeruj(){
        x=0.0;
        y=0.0;
    }
    public void przesun(int x, int y){
        this.x+=x;
        this.y+=y;
    }
    public void opis(){
        System.out.format("Punkt o wsspolrzednych (%.2f,%.2f)\n",x,y);
    }
}
