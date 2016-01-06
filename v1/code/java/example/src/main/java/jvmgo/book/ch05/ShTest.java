package jvmgo.book.ch05;

public class ShTest {

    public static void main(String[] args) {
        int x = -1;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x >> 8));
        System.out.println(Integer.toBinaryString(x >>> 8));
    }

}
