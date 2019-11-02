package com.github.jvmgo.instructions.math;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class fneg extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x76;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        operandStack.pushFloat(operandStack.popFloat() * -1);
    }
}
