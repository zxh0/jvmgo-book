package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class ldc extends NoOperandsInstruction {

    @Override
    public int getOpCode() {
        return 0x12;
    }

    @Override
    public String getReName() {
        return "ldc";
    }

    @Override
    public void execute(Frame frame) {
    }
}
