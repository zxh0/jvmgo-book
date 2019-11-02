package com.github.jvmgo.instructions.control;

import com.github.jvmgo.instructions.base.BranchInstruction;
import com.github.jvmgo.instructions.base.BytecodeReader;
import lombok.Getter;
import lombok.Setter;
import com.github.jvmgo.rtda.Frame;
import com.github.jvmgo.rtda.OperandStack;
import com.github.jvmgo.rtda.Thread;

@Setter
@Getter
public class lookupswitch extends BranchInstruction {

    private int defaultOffset;

    private int npairs;

    private int[] matchOffsets;

    @Override
    public int getOpCode() {
        return 0xab;
    }

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset = reader.read32();
        npairs = reader.read32();
        matchOffsets = reader.readInt32s(npairs * 2);
    }

    @Override
    public void execute(Frame frame) throws Exception {
        OperandStack operandStack = frame.getOperandStack();
        Thread thread = frame.getThread();
        int key = operandStack.popInt();
        for (int i = 0; i < npairs * 2; i += 2) {
            if (matchOffsets[i] == key) {
                offset = matchOffsets[i + 1];
                thread.setPc(offset);
                return;
            }
        }
        thread.setPc(defaultOffset);
    }
}
