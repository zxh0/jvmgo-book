package com.github.jvmgo.instructions.stores;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class fstore extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x38;
    }

    @Override
    public void execute(Frame frame) {
        float val = frame.getOperandStack().popFloat();
        frame.getLocalVars().setFloat(index, val);
    }
}
