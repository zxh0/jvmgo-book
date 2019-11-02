package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class dload_2 extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x28;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        double val = frame.getLocalVars().getDouble(2);
        frame.getOperandStack().pushDouble(val);
    }
}
