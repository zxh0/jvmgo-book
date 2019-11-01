package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class iconst_m1 extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x02;
    }

    @Override
    public String getReName() {
        return "iconst_m1";
    }

    @Override
    public void execute(Frame frame) throws Exception {
        frame.getOperandStack().pushInt(-1);
    }
}
