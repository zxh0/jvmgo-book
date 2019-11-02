package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class lload_2 extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x20;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        long val = frame.getLocalVars().getLong(2);
        frame.getOperandStack().pushLong(val);
    }
}
