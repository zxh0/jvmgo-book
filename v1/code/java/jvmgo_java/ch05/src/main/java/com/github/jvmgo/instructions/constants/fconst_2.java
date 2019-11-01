package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class fconst_2 extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x0d;
    }

    @Override
    public String getReName() {
        return "fconst_2";
    }

    @Override
    public void execute(Frame frame) throws Exception {
        frame.getOperandStack().pushFloat(2.0f);
    }
}
