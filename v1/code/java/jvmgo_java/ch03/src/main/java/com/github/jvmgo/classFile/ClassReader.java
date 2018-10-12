package com.github.jvmgo.classfile;

import com.github.jvmgo.util.Util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

//刘欣那里复制的
public class ClassReader {

    private byte[] codes;
    private int pos;

    public ClassReader(byte[] aClassData) {
        this.codes = aClassData;
        this.pos = 0;
    }

    public int nextU1toInt() {
        return Util.byteToInt(new byte[]{codes[pos++]});
    }

    public int nextU2ToInt() {
        return Util.byteToInt(new byte[]{codes[pos++], codes[pos++]});
    }

    public int nextU4ToInt() {
        return Util.byteToInt(new byte[]{codes[pos++], codes[pos++], codes[pos++], codes[pos++]});
    }

    public float nextU4ToFloat() {
        byte[] bytes = nextBytes(4);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getFloat();
    }

    public String nextU4ToHexString() {
        return Util.byteToHexString((new byte[]{codes[pos++], codes[pos++], codes[pos++], codes[pos++]}));
    }


    public byte[] nextBytes(int len) {
        if (pos + len >= codes.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        byte[] data = Arrays.copyOfRange(codes, pos, pos + len);
        pos += len;
        return data;
    }


    public long next2U4ToLong() {
        byte[] bytes = nextBytes(8);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getLong();
    }

    public double next2U4Double() {
        byte[] bytes = nextBytes(8);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getDouble();
    }

    public int[] nextUint16s() {
        int count = nextU2ToInt();
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nextU2ToInt();
        }
        return result;
    }

    public void back(int n) {
        this.pos -= n;
    }

}
