package jvmgo.book.ch09;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ArrayClassTest {

    public static void main(String[] args) {
        //Class<int[]> arrClass = int[].class;
        Class<?> arrClass = Object[].class;

        System.out.println(arrClass.getSuperclass());
        for (Class<?> c : arrClass.getInterfaces()) {
            System.out.println(c);
        }

        for (Field f : arrClass.getDeclaredFields()) {
            System.out.println(f);
        }
        for (Method m : arrClass.getDeclaredMethods()) {
            System.out.println(m);
        }
    }

}
