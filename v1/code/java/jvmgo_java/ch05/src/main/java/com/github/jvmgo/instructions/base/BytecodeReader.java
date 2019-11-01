package com.github.jvmgo.instructions.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BytecodeReader {

    private byte[] code;

    private int pc;

    public BytecodeReader(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    public BytecodeReader reset(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
        return this;
    }

    public int read8() {
        int b = code[pc];
        pc += 1;
        return b & 0xFF;
    }

    public int read16() {
        int b1 = code[pc];
        int b2 = code[pc + 1];
        pc += 2;
        return b1 << 8 | b2;
    }

    public int read32() {
        int b1 = code[pc];
        int b2 = code[pc + 1];
        int b3 = code[pc + 2];
        int b4 = code[pc + 3];
        pc += 4;
        return b1 << 24 | b2 << 16 | b3 << 8 | b4;
    }

    public int[] readInt32s(int length) {
        int[] ints = new int[length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = read32();
        }
        return ints;
    }

    public void skipPadding() {
        while (pc % 4 != 0) {
            read8();
        }
    }
}
