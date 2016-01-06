package jvmgo.book.ch07;

public class ClinitTest {

    public static final boolean Z = true;
    public static final byte B = 1;
    public static final short S = 2;
    public static final int I = 3;
    public static final long L = 4;
    public static final char C = 'x';
    public static final float F = 3.14f;
    public static final double D = 2.71828;
    public static final String STR = "abc";
    public static boolean z = true;
    public static byte b = 1;
    public static short s = 2;
    public static int i = 3;
    public static long l = 4;
    public static char c = 'x';
    public static float f = 3.14f;
    public static double d = 2.71828;
    public static String str = "abc";

    public static void main(String[] args) {
        System.out.println(ClinitTest.I);
        System.out.println(ClinitTest.i);
    }

}
