package com.github.jvmgo.rtda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.ref.Reference;

/**
 */
@Setter
@Getter
@ToString
public class LocalVars {

    private Slot[] localVars;

    public LocalVars(int maxLocals) {
        if (maxLocals > 0)
            localVars = new Slot[maxLocals];
        else
            System.exit(-1);
    }

    public void setInt(int index, int val) {
        localVars[index] = Util.setInt(val);
    }

    public int getInt(int index) {
        Slot slot = localVars[index];
        return Util.getInt(slot);
    }

    public void setFloat(int index, float val) {
        int a = Float.floatToIntBits(val);
        setInt(index, a);
    }

    public float getFloat(int index) {
        int a = getInt(index);
        return Float.intBitsToFloat(a);
    }

    public void setLong(int index, long val) {
        Slot[] slots = Util.setLong(val);
        localVars[index] = slots[0];
        localVars[index + 1] = slots[1];
    }

    public long getLong(int index) {
        Slot high = localVars[index];
        Slot low = localVars[index + 1];
        return Util.getLong(new Slot[]{high, low});
    }

    public void setDouble(int index, double val) {
        long v = Double.doubleToLongBits(val);
        setLong(index, v);
    }

    public double getDouble(int index) {
        long v = getLong(index);
        return Double.longBitsToDouble(v);
    }

    public void setRef(int index, Reference ref) {
        Slot slot = new Slot();
        slot.setRef(ref);
        localVars[index] = slot;
    }

    public Reference getRef(int index) {
        return localVars[index].getRef();
    }
}
