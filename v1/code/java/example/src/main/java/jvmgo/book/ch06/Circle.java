package jvmgo.book.ch06;

public class Circle {
    
    public static float PI;
    
    public float r;
    
    public static void main(String[] args) {
        Circle.PI = 3.14f;
        Circle c = new Circle();
        c.r = 5.5f;
        
        float area = Circle.PI * c.r * c.r;
        System.out.println(area);
    }
    
}
