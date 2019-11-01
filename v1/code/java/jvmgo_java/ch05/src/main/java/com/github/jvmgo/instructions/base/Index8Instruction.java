package com.github.jvmgo.instructions.base;

import lombok.Setter;
import com.github.jvmgo.rtda.Frame;

public abstract class Index8Instruction implements Instruction {

    @Setter
    protected int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index = reader.read8();
    }

    @Override
    public abstract void execute(Frame frame) throws Exception;
}
