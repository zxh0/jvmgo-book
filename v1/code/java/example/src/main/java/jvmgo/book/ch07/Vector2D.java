package jvmgo.book.ch07;

public class Vector2D implements Vector {

    protected double x;
    protected double y;

    public Vector2D() {
        this(1, 1);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void multiply(double s) {
        this.x *= s;
        this.y *= s;
    }

}
