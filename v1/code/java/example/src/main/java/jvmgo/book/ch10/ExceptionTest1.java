package jvmgo.book.ch10;

public class ExceptionTest1 {

    public static void main(String[] args) {
        test(0);
        test(1);
        test(2);
        test(3);
    }

    private static void test(int x) {
        try {
            if (x == 0) {
                throw new IllegalArgumentException("0!");
            }
            if (x == 1) {
                throw new RuntimeException("1!");
            }
            if (x == 2) {
                throw new Exception("2!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(x);
        }
    }

}
