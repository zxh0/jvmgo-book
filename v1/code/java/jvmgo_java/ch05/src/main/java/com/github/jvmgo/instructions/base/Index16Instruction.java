package com.github.jvmgo.instructions.base;

import com.github.jvmgo.rtda.Frame;


public abstract class Index16Instruction implements Instruction {

    private int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.read16();
    }

    @Override
    public abstract void execute(Frame frame);
}
