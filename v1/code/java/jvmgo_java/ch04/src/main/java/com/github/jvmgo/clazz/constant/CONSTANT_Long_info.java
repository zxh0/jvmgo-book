package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Long_info extends CONSTANT {

    private int high_bytes;

    private int low_bytes;

    @Override
    public int getTag() {
        return 5;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_Long_info constant = new CONSTANT_Long_info();
        constant.setTag(getTag());
        constant.setHigh_bytes(classReader.readU4Int());
        constant.setLow_bytes(classReader.readU4Int());
        return constant;
    }

    public long toLong() {
        return ((long) high_bytes << 32) + low_bytes;
    }
}
