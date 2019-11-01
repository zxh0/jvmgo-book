package com.github.jvmgo.instructions.stores;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class dstore_1 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x48;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        double val = frame.getOperandStack().popDouble();
        frame.getLocalVars().setDouble(1, val);
    }
}
