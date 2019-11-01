package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class iload_1 extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x1b;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        int val = frame.getLocalVars().getInt(1);
        frame.getOperandStack().pushInt(val);
    }
}
