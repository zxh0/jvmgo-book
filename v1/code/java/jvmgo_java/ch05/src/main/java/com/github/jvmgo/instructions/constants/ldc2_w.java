package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class ldc2_w extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x14;
    }

    @Override
    public String getReName() {
        return "ldc2_w";
    }

    @Override
    public void execute(Frame frame) {
    }
}
