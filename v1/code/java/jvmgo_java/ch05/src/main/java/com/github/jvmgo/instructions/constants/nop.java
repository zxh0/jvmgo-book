package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class nop extends NoOperandsInstruction {


    @Override
    public int getOpCode() {
        return 0x00;
    }

    @Override
    public String getReName() {
        return "nop";
    }

    @Override
    public void execute(Frame frame) {

    }
}
