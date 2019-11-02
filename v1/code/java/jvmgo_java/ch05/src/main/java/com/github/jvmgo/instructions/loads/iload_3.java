package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class iload_3 extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x1d;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        int val = frame.getLocalVars().getInt(3);
        frame.getOperandStack().pushInt(val);
    }
}
