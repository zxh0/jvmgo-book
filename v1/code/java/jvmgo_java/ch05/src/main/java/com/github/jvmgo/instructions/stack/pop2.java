package com.github.jvmgo.instructions.stack;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class pop2 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x58;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        operandStack.popSlot();
        operandStack.popSlot();
    }
}
