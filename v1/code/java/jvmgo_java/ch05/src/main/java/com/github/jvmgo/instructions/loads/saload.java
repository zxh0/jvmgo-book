package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class saload extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x35;
    }

    @Override
    public void execute(Frame frame) {

    }
}
