package jvmgo.book.ch07;

public class AccSuperDemo {

    // lib1.jar
    public static class A {
        public void foo() {
            System.out.println("A.foo");
        }
    }
    public static class B extends A {
        // empty
    }

    // lib2.jar
    public static class C extends B {
        public void foo() {
            super.foo();
        }
    }

    public static void main(String[] args) {
        new C().foo();
    }

}
