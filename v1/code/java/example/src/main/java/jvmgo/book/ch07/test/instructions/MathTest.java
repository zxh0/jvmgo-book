package jvmgo.book.ch07.test.instructions;

import static jvmgo.book.ch07.test.instructions.Assert.*;

public class MathTest {

    public static void main(String[] args) {
        add();
        sub();
        mul();
        div();
        rem();
        neg();
        sh();
        and();
        or();
        xor();
        iinc();
    }

    private static void add() {
        assertTrue(1 + 1 == 2);
        assertTrue(1L + 1L == 2L);
        assertTrue(1.0f + 1.0f == 2.0f);
        assertTrue(1.0d + 1.0d == 2.0d);
    }

    private static void sub() {
        assertTrue(1 - 1 == 0);
        assertTrue(1L - 1L == 0L);
        assertTrue(1.0f - 1.0f == 0.0f);
        assertTrue(1.0d - 1.0d == 0.0d);
    }

    private static void mul() {
        assertTrue(2 * 3 == 6);
        assertTrue(2L * 3L == 6L);
        assertTrue(2.0f * 3.0f == 6.0f);
        assertTrue(2.0d * 3.0d == 6.0d);
    }

    private static void div() {
        assertTrue(3 / 2 == 1);
        assertTrue(3L / 2L == 1L);
        assertTrue(3.0f / 2.0f == 1.5f);
        assertTrue(3.0d / 2.0d == 1.5d);
    }

    private static void rem() {
        assertTrue(7 % 3 == 1);
        assertTrue(7L % 3L == 1L);
        assertTrue(7.0f % 3.0f == 1.0f);
        assertTrue(7.0d % 3.0d == 1.0d);
    }

    private static void neg() {
        assertTrue(-(1 + 1) == -2);
        assertTrue(-(1L + 1L) == -2L);
        assertTrue(-(1.0f + 1.0f) == -2.0f);
        assertTrue(-(1.0d + 1.0d) == -2.0d);
    }

    private static void sh() {
        // todo
    }

    private static void and() {
        // todo
    }

    private static void or() {
        // todo
    }

    private static void xor() {
        // todo
    }

    private static void iinc() {
        // todo
    }

}
