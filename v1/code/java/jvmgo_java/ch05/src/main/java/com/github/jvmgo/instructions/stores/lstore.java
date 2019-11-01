package com.github.jvmgo.instructions.stores;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class lstore extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x37;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        long val = frame.getOperandStack().popLong();
        frame.getLocalVars().setLong(index, val);
    }
}
