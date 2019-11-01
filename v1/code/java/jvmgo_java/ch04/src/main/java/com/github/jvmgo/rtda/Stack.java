package com.github.jvmgo.rtda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stack {

    private int maxSize;

    private int size;

    private java.util.Stack<Frame> stacks;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stacks = new java.util.Stack<>();
    }

    public void push(Frame frame) {
        if (this.size >= maxSize) {
            System.out.println("java.lang.StackOverflowError");
            System.exit(1);
        }
        stacks.push(frame);
        size++;
    }

    public Frame pop() {
        Frame pop = stacks.pop();
        if (pop == null) {
            System.out.println("java stack is empty");
            System.exit(2);
        }
        size--;
        return pop;
    }

    public Frame current() {
        Frame peek = stacks.peek();
        if (peek == null) {
            System.out.println("java stack is empty");
            System.exit(2);
        }
        return peek;
    }

}
