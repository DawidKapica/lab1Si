package parser;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
