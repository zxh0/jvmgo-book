package jvmgo.book.ch04;

public class Math {

    public static void main(String[] args) {
        System.out.println(circumference(1.6f));
    }

    public static float circumference(float r) {
        float pi = 3.14f;
        float c = 2 * pi * r;
        return c;
    }

}
