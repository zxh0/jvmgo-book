package com.github.jvmgo.instructions.stack;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class pop extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x57;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        frame.getOperandStack().popSlot();
    }
}
