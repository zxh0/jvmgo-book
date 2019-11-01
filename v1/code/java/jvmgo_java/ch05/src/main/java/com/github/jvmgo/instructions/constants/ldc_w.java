package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class ldc_w extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x13;
    }

    @Override
    public String getReName() {
        return "ldc_w";
    }

    @Override
    public void execute(Frame frame) {
    }
}
