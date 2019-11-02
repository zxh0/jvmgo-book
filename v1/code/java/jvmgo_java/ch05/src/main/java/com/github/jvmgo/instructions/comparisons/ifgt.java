package com.github.jvmgo.instructions.comparisons;

import com.github.jvmgo.instructions.base.BranchInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class ifgt extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0x9d;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        int i = operandStack.popInt();
        if (i < 0) {
            branch(frame,offset);
        }
    }
}
