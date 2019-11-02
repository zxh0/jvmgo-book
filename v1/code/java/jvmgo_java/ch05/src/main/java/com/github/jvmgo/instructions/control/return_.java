package com.github.jvmgo.instructions.control;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;

public class return_ extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0xb1;
    }

    @Override
    public void execute(Frame frame) throws Exception {

    }
}
