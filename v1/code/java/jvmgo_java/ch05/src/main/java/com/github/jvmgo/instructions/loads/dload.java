package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class dload extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x18;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        double val = frame.getLocalVars().getDouble(index);
        frame.getOperandStack().pushDouble(val);
    }
}
