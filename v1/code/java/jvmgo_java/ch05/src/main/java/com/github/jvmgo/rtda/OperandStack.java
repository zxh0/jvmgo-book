package com.github.jvmgo.rtda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.ref.Reference;
import java.util.Stack;

@Getter
@Setter
@ToString
public class OperandStack {

    private Stack<Slot> stacks;

    private int maxStack;

    public OperandStack(int maxStack) {
        this.maxStack = maxStack;
        if (maxStack > 0) {
            stacks = new Stack<>();
        } else
            System.exit(-1);
    }

    public void pushSlot(Slot slot) throws Exception {
        if (stacks.size() >= maxStack) {
            throw new Exception("size > maxStack");
        }
        stacks.push(slot);
    }

    public Slot popSlot() throws Exception {
        if (stacks.size() <= 0) {
            throw new Exception("size <0 ");
        }
        return stacks.pop();
    }

    public void pushInt(int val) throws Exception {
        pushSlot(Util.setInt(val));
    }

    public int popInt() {
        return Util.getInt(stacks.pop());
    }

    public void pushFloat(float val) throws Exception {
        int a = Float.floatToIntBits(val);
        pushInt(a);
    }

    public float popFloat() {
        return Float.intBitsToFloat(popInt());
    }

    public void pushLong(long val) throws Exception {
        Slot[] slots = Util.setLong(val);
        pushSlot(slots[0]);
        pushSlot(slots[1]);
    }

    public long popLong() throws Exception {
        Slot low = popSlot();
        Slot high = popSlot();
        return Util.getLong(new Slot[]{high, low});
    }

    public void pushDouble(double val) throws Exception {
        pushLong(Double.doubleToLongBits(val));
    }

    public double popDouble() throws Exception {
        return Double.longBitsToDouble(popLong());
    }

    public void pushRef(Reference ref) throws Exception {
        Slot slot = new Slot();
        slot.setRef(ref);
        pushSlot(slot);
    }

    public Reference popRef() throws Exception {
        Reference reference = popSlot().getRef();
        return reference;
    }
}
