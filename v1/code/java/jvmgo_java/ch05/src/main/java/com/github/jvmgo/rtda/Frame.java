package com.github.jvmgo.rtda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Frame {

    private Frame lower;

    private LocalVars localVars;

    private OperandStack operandStack;

    private Thread thread;

    private int nextPc;

    public Frame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        this.localVars = new LocalVars(maxLocals);
        this.operandStack = new OperandStack(maxStack);
    }

}
