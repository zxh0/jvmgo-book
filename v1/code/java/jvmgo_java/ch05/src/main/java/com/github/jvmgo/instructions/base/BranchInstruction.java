package com.github.jvmgo.instructions.base;

import com.github.jvmgo.rtda.Frame;

/**
 * 跳转指令
 */
public abstract class BranchInstruction implements Instruction {

    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) throws Exception {
        this.offset = reader.read16();
    }

    @Override
    public abstract void execute(Frame frame) throws Exception;

    public void branch(Frame frame, int offset) {
        int pc = frame.getThread().getPc();
        frame.setNextPc(pc + offset);
    }
}
