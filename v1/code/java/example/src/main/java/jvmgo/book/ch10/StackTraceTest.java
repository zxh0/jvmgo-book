package jvmgo.book.ch10;

public class StackTraceTest {

    public static void main(String[] args) {
        foo();
    }

    private static void foo() {
        bar();
    }

    private static void bar() {
        throw new RuntimeException("OH!");
    }

}
