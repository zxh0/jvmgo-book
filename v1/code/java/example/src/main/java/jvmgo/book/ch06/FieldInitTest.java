package jvmgo.book.ch06;

public class FieldInitTest {

    public static boolean Z;
    public static byte B;
    public static short S;
    public static int I;
    public static long L;
    public static char C;
    public static float F;
    public static double D;
    public boolean z;
    public byte b;
    public short s;
    public int i;
    public long l;
    public char c;
    public float f;
    public double d;

    public static void main(String[] args) {
        System.out.println(Z);
        System.out.println(B);
        System.out.println(S);
        System.out.println(I);
        System.out.println(L);
        System.out.println(C);
        System.out.println(F);
        System.out.println(D);
        FieldInitTest obj = new FieldInitTest();
        System.out.println(obj.z);
        System.out.println(obj.b);
        System.out.println(obj.s);
        System.out.println(obj.i);
        System.out.println(obj.l);
        System.out.println(obj.c);
        System.out.println(obj.f);
        System.out.println(obj.d);
    }

}
