package jvmgo.book.ch06;

public class FieldResolutionTest {

    private static interface I {
        static int x = 1;
    }

    private static class B {
        public int x;
    }

    private static class C extends B implements I {
        //public int x;
    }

    public static void main(String[] args) {
        C c = new C();
        //System.out.println(c.x);
    }

}
