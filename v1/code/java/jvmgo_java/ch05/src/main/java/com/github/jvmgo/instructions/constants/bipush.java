package com.github.jvmgo.instructions.constants;

import com.github.jvmgo.instructions.base.BytecodeReader;
import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class bipush extends NoOperandsInstruction {

    private int val;

    @Override
    public int getOpCode() {
        return 0x10;
    }

    @Override
    public String getReName() {
        return "bipush";
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        val = reader.read8();
    }

    @Override
    public void execute(Frame frame) throws Exception {
        frame.getOperandStack().pushInt(val);
    }
}
