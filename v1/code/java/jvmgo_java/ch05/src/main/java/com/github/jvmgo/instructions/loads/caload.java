package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class caload extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x34;
    }

    @Override
    public void execute(Frame frame) {

    }
}
