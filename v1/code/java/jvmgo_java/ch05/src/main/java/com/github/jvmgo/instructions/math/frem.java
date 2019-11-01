package com.github.jvmgo.instructions.math;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class frem extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x72;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        float v2 = operandStack.popFloat();
        float v1 = operandStack.popFloat();
        if (v2 == 0) {
            throw new ArithmeticException("java.lang.ArithmeticException: / by zero");
        }
        operandStack.pushFloat(v1 % v2);
    }
}
