package com.github.jvmgo.instructions.loads;

import com.github.jvmgo.instructions.base.Index8Instruction;
import com.github.jvmgo.rtda.Frame;

import java.lang.ref.Reference;

public class aload_2 extends Index8Instruction {
    @Override
    public int getOpCode() {
        return 0x2c;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        Reference ref = frame.getLocalVars().getRef(2);
        frame.getOperandStack().pushRef(ref);
    }
}
