package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class lload_0 extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x1e;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        long val = frame.getLocalVars().getLong(0);
        frame.getOperandStack().pushLong(val);
    }
}
