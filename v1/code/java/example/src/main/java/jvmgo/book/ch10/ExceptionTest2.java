package jvmgo.book.ch10;

public class ExceptionTest2 {

    public static void main(String[] args) {
        safe(0);
        safe(1);
    }

    private static void safe(int x) {
        try {
            dangerous(x);
            System.out.println(x);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void dangerous(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("0!");
        }
    }

}
