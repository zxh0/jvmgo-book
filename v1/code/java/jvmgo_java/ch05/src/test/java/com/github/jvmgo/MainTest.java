package com.github.jvmgo;

public class MainTest {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        int b = sum + 1;

        System.out.println(b);
//        int a = 1;
//        int b = 2;
//        int c = a + b;//3
//        int d = c + a;//4
//        int f = a + b + c + d;//10
//        int e = f + 1;//11
//        System.out.println(f);
    }

}
