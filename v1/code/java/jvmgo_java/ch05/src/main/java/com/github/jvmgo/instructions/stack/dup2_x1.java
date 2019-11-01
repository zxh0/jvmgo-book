package com.github.jvmgo.instructions.stack;

import com.github.jvmgo.instructions.base.NoOperandsInstruction;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;
import com.github.jvmgo.rtda.Slot;

public class dup2_x1 extends NoOperandsInstruction {
    @Override
    public int getOpCode() {
        return 0x5d;
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        Slot slot1 = operandStack.popSlot();
        Slot slot2 = operandStack.popSlot();
        Slot slot3 = operandStack.popSlot();

        operandStack.pushSlot(slot2);
        operandStack.pushSlot(slot1);
        operandStack.pushSlot(slot3);
        operandStack.pushSlot(slot2);
        operandStack.pushSlot(slot1);
    }
}
