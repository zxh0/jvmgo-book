package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

import java.lang.ref.Reference;

public class aload_3 extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x2d;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        Reference ref = frame.getLocalVars().getRef(3);
        frame.getOperandStack().pushRef(ref);
    }
}
