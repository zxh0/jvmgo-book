package jvmgo.book.ch07.test.instructions;

import static jvmgo.book.ch07.test.Assert.*;

public class SwitchTest {

    public static void main(String[] args) {
        assertTrue(chooseNear(0) ==  0);
        assertTrue(chooseNear(1) ==  1);
        assertTrue(chooseNear(2) ==  2);
        assertTrue(chooseNear(3) == -1);

        assertTrue(chooseFar(-100) == -1);
        assertTrue(chooseFar(0)    ==  0);
        assertTrue(chooseFar(100)  ==  1);
        assertTrue(chooseFar(12)   == -1);
    }

    // tableswitch
    private static int chooseNear(int i) {
        switch (i) {
            case 0:  return  0;
            case 1:  return  1;
            case 2:  return  2;
            default: return -1;
        }
    }

    // lookupswitch
    private static int chooseFar(int i) {
        switch (i) {
            case -100: return -1;
            case 0:    return  0;
            case 100:  return  1;
            default:   return -1;
        }
    }

}
