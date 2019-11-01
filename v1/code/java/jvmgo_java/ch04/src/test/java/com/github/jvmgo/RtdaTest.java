package com.github.jvmgo;

import org.junit.Assert;
import org.junit.Test;
import com.github.jvmgo.rtda.LocalVars;
import com.github.jvmgo.rtda.OperandStack;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class RtdaTest {

    @Test
    public void testLocalVars() {
        LocalVars localVars = new LocalVars(1024);
        localVars.setInt(0, Integer.MAX_VALUE);
        localVars.setInt(1, Integer.MIN_VALUE);
        localVars.setFloat(2, Float.MAX_VALUE);
        localVars.setFloat(3, Float.MIN_VALUE);

        localVars.setLong(4, Long.MAX_VALUE);
        localVars.setLong(6, Long.MIN_VALUE);
        localVars.setDouble(8, Double.MAX_VALUE);
        localVars.setDouble(10, Double.MIN_VALUE);
        Object object = new Object();
        Reference reference = new WeakReference(object);

        localVars.setRef(12, reference);


        Assert.assertEquals(Integer.MAX_VALUE, localVars.getInt(0));
        Assert.assertEquals(Integer.MIN_VALUE, localVars.getInt(1));

        Assert.assertEquals(Float.MAX_VALUE, localVars.getFloat(2), 0);
        Assert.assertEquals(Float.MIN_VALUE, localVars.getFloat(3), 0);

        Assert.assertEquals(Long.MAX_VALUE, localVars.getLong(4), 0);
        Assert.assertEquals(Long.MIN_VALUE, localVars.getLong(6), 0);

        Assert.assertEquals(Double.MAX_VALUE, localVars.getDouble(8), 0);
        Assert.assertEquals(Double.MIN_VALUE, localVars.getDouble(10), 0);

        Assert.assertEquals(object, localVars.getRef(12).get());
    }

    @Test
    public void testOperandStack() throws Exception {
        OperandStack operandStack = new OperandStack(1024);
        operandStack.pushInt(Integer.MAX_VALUE);
        operandStack.pushInt(Integer.MIN_VALUE);
        operandStack.pushFloat(Float.MAX_VALUE);
        operandStack.pushFloat(Float.MIN_VALUE);
        operandStack.pushLong(Long.MAX_VALUE);
        operandStack.pushLong(Long.MIN_VALUE);
        operandStack.pushDouble(Double.MAX_VALUE);
        operandStack.pushDouble(Double.MIN_VALUE);
        Object object = new Object();
        Reference reference = new WeakReference(object);
        operandStack.pushRef(reference);

        Assert.assertEquals(object, operandStack.popRef().get());
        Assert.assertEquals(Double.MIN_VALUE, operandStack.popDouble(), 0);
        Assert.assertEquals(Double.MAX_VALUE, operandStack.popDouble(), 0);

        Assert.assertEquals(Long.MIN_VALUE, operandStack.popLong(), 0);
        Assert.assertEquals(Long.MAX_VALUE, operandStack.popLong(), 0);

        Assert.assertEquals(Float.MIN_VALUE, operandStack.popFloat(), 0);
        Assert.assertEquals(Float.MAX_VALUE, operandStack.popFloat(), 0);

        Assert.assertEquals(Integer.MIN_VALUE, operandStack.popInt());
        Assert.assertEquals(Integer.MAX_VALUE, operandStack.popInt());
    }


    @Test
    public void t0() {
        long a = Long.MAX_VALUE;
        String s = addZero(Long.toBinaryString(a), 64);
        String high = s.substring(0, 32);
        String low = s.substring(32);
        long b = Long.parseLong(high + low, 2);
        Assert.assertEquals(a, b);

    }

    @Test
    public void t2() {
        long a = Long.MIN_VALUE;
        String s = addZero(translate(Long.toBinaryString(a)), 64);
        String high = s.substring(0, 32);
        String low = s.substring(32);
        long b = Long.parseLong(high + low, 2) * -1 - 1;
        Assert.assertEquals(a, b);
    }


    public String addZero(String s, int length) {
        if (s.length() >= length) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length - s.length(); i++) {
            builder.append("0");
        }
        return builder.append(s).toString();
    }

    public String translate(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                builder.append("1");
            } else {
                builder.append("0");
            }
        }
        return builder.toString();
    }
}
