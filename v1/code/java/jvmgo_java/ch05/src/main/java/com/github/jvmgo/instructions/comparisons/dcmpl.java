package com.github.jvmgo.instructions.comparisons;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

public class dcmpl extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x97;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        double v2 = operandStack.popDouble();
        double v1 = operandStack.popDouble();
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
