package com.github.jvmgo.instructions.math;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;

/**

 */
public class iushr extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x7c;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        int v2 = operandStack.popInt();
        int v1 = operandStack.popInt();
        int s = v2 & 0x1f;
        operandStack.pushInt(v1 >>> s);
    }
}
