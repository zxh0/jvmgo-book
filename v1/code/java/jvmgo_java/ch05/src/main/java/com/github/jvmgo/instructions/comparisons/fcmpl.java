package com.github.jvmgo.instructions.comparisons;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class fcmpl extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x95;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        float v2 = operandStack.popFloat();
        float v1 = operandStack.popFloat();
        if (v1 > v2)
            operandStack.pushInt(1);
        else if (v1 == v2)
            operandStack.pushInt(0);
        else if (v1 < v2)
            operandStack.pushInt(-1);
        else
            operandStack.pushInt(-1);
    }
}
