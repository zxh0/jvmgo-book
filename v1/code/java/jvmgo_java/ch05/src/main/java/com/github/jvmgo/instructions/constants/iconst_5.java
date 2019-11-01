package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class iconst_5 extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x08;
    }

    @Override
    public String getReName() {
        return "iconst_5";
    }

    @Override
    public void execute(Frame frame) throws Exception {
        frame.getOperandStack().pushInt(5);
    }
}
