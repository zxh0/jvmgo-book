package com.github.jvmgo.instructions.math;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class isub extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x64;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        int v2 = operandStack.popInt();
        int v1 = operandStack.popInt();
        operandStack.pushInt(v1 - v2);
    }
}
