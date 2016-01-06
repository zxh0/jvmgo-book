package jvmgo.book.ch08;

public class StringTest {

    public static final String STR = "abc";

    public static void main(String[] args) {
        String s1 = "xyz"; // ldc

        System.out.println(STR);
        System.out.println(s1);
        //String s2 = "abc1";
        //assertSame(s1, s2);
        
        //int x = 1;
        //String s3 = "abc" + x;
        //assertNotSame(s1, s3);
        
        //s3 = s3.intern();
        //assertSame(s1, s3);
    }
    
}
