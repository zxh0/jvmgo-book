package com.github.jvmgo.instructions.math;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class drem extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x73;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        double v2 = operandStack.popDouble();
        double v1 = operandStack.popDouble();
        if (v2 == 0) {
            throw new ArithmeticException("java.lang.ArithmeticException: / by zero");
        }
        operandStack.pushDouble(v1 % v2);
    }
}
