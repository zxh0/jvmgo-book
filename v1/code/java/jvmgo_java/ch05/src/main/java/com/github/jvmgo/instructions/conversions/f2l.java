package com.github.jvmgo.instructions.conversions;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class f2l extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x8c;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        operandStack.pushLong((long) operandStack.popFloat());
    }
}
