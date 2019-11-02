package com.github.jvmgo.instructions.control;

import com.github.jvmgo.instructions.base.BranchInstruction;
import com.github.jvmgo.instructions.base.BytecodeReader;
import com.github.jvmgo.rtda.Frame;

public class goto_ extends BranchInstruction {
    @Override
    public int getOpCode() {
        return 0xa7;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) throws Exception {
        this.offset = reader.read16();
    }

    @Override
    public void execute(Frame frame) throws Exception {
        branch(frame, offset);
    }
}
