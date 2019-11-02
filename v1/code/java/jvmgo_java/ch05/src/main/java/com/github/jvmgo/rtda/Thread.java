package com.github.jvmgo.rtda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Thread {

    private int pc;

    private Stack stack;

    public Thread(int maxStack) {
        this.stack = new Stack(maxStack);
    }

    public void pushFrame(Frame frame) {
        this.stack.push(frame);
    }

    public Frame popFrame() {
        return this.stack.pop();
    }

    public Frame currentFrame() {
        return this.stack.current();
    }


}
