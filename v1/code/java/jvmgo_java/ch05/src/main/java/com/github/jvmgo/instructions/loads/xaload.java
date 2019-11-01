package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

public class xaload extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0;
    }

    @Override
    public void execute(Frame frame) {

    }
}
