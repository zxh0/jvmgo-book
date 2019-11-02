package com.github.jvmgo.instructions.base;

import com.github.jvmgo.rtda.Frame;


public abstract class NoOperandsInstruction implements Instruction {

    @Override
    public void fetchOperands(BytecodeReader reader) {

    }

    @Override
    public abstract void execute(Frame frame) throws Exception;
}
