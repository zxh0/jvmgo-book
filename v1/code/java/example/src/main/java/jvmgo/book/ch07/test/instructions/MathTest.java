package jvmgo.book.ch07.test.instructions;

import static jvmgo.book.ch07.test.Assert.*;

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
        assertTrue(iadd(1, 1) == 2);
        assertTrue(ladd(1L, 1L) == 2L);
        assertTrue(fadd(1.0f, 1.0f) == 2.0f);
        assertTrue(dadd(1.0d, 1.0d) == 2.0d);
    }

    private static void sub() {
        assertTrue(isub(1, 1) == 0);
        assertTrue(lsub(1L, 1L) == 0L);
        assertTrue(fsub(1.0f, 1.0f) == 0.0f);
        assertTrue(dsub(1.0d, 1.0d) == 0.0d);
    }

    private static void mul() {
        assertTrue(imul(2, 3) == 6);
        assertTrue(lmul(2L, 3L) == 6L);
        assertTrue(fmul(2.0f, 3.0f) == 6.0f);
        assertTrue(dmul(2.0d, 3.0d) == 6.0d);
    }

    private static void div() {
        assertTrue(idiv(3, 2) == 1);
        assertTrue(ldiv(3L, 2L) == 1L);
        assertTrue(fdiv(3.0f, 2.0f) == 1.5f);
        assertTrue(ddiv(3.0d, 2.0d) == 1.5d);
    }

    private static void rem() {
        assertTrue(irem(7, 3) == 1);
        assertTrue(lrem(7L, 3L) == 1L);
        assertTrue(frem(7.0f, 3.0f) == 1.0f);
        assertTrue(drem(7.0d, 3.0d) == 1.0d);
    }

    private static void neg() {
        assertTrue(ineg(1) == -1);
        assertTrue(lneg(1L) == -1L);
        assertTrue(fneg(1.0f) == -1.0f);
        assertTrue(dneg(1.0d) == -1.0d);
    }

    private static void sh() {
        assertTrue(ishl(0xFEDCBA98, 8) == 0xDCBA9800);
        assertTrue(ishr(0xFEDCBA98, 8) == 0xFFFEDCBA);
        assertTrue(iushr(0xFEDCBA98, 8) == 0x00FEDCBA);
        assertTrue(lshl(0xFEDCBA9876543210L, 8) == 0xDCBA987654321000L);
        assertTrue(lshr(0xFEDCBA9876543210L, 8) == 0xFFFEDCBA98765432L);
        assertTrue(lushr(0xFEDCBA9876543210L, 8) == 0x00FEDCBA98765432L);
    }

    private static void and() {
        assertTrue(iand(0b1010, 0b0110) == 0b0010);
        assertTrue(land(0b1010, 0b0110) == 0b0010);
    }

    private static void or() {
        assertTrue(ior(0b1010, 0b0110) == 0b1110);
        assertTrue(lor(0b1010, 0b0110) == 0b1110);
    }

    private static void xor() {
        assertTrue(ixor(0b1010, 0b0110) == 0b1100);
        assertTrue(lxor(0b1010, 0b0110) == 0b1100);
    }

    private static void iinc() {
        // TODO
    }


    private static int iadd (int a, int b) {return a + b;  }
    private static int isub (int a, int b) {return a - b;  }
    private static int imul (int a, int b) {return a * b;  }
    private static int idiv (int a, int b) {return a / b;  }
    private static int irem (int a, int b) {return a % b;  }
    private static int ineg (int a       ) {return -a;     }
    private static int ishl (int a, int b) {return a << b; }
    private static int ishr (int a, int b) {return a >> b; }
    private static int iushr(int a, int b) {return a >>> b;}
    private static int iand (int a, int b) {return a & b;  }
    private static int ior  (int a, int b) {return a | b;  }
    private static int ixor (int a, int b) {return a ^ b;  }

    private static long ladd (long a, long b) {return a + b;  }
    private static long lsub (long a, long b) {return a - b;  }
    private static long lmul (long a, long b) {return a * b;  }
    private static long ldiv (long a, long b) {return a / b;  }
    private static long lrem (long a, long b) {return a % b;  }
    private static long lneg (long a        ) {return -a;     }
    private static long lshl (long a, long b) {return a << b; }
    private static long lshr (long a, long b) {return a >> b; }
    private static long lushr(long a, long b) {return a >>> b;}
    private static long land (long a, long b) {return a & b;  }
    private static long lor  (long a, long b) {return a | b;  }
    private static long lxor (long a, long b) {return a ^ b;  }

    private static float fadd(float a, float b) {return a + b;  }
    private static float fsub(float a, float b) {return a - b;  }
    private static float fmul(float a, float b) {return a * b;  }
    private static float fdiv(float a, float b) {return a / b;  }
    private static float frem(float a, float b) {return a % b;  }
    private static float fneg(float a         ) {return -a;     }

    private static double dadd(double a, double b) {return a + b;  }
    private static double dsub(double a, double b) {return a - b;  }
    private static double dmul(double a, double b) {return a * b;  }
    private static double ddiv(double a, double b) {return a / b;  }
    private static double drem(double a, double b) {return a % b;  }
    private static double dneg(double a          ) {return -a;     }

}
