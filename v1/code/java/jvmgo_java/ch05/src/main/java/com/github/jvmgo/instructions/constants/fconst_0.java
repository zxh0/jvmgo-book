package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class fconst_0 extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x0b;
    }

    @Override
    public String getReName() {
        return null;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        frame.getOperandStack().pushFloat(0.0f);
    }
}
