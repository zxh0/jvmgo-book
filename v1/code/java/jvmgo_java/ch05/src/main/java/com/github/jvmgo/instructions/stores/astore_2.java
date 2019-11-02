package com.github.jvmgo.instructions.stores;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

import java.lang.ref.Reference;

public class astore_2 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x4d;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        Reference val = frame.getOperandStack().popRef();
        frame.getLocalVars().setRef(2, val);
    }
}
