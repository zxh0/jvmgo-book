package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Double_info extends CONSTANT {

    private int high_bytes;

    private int low_bytes;

    @Override
    public int getTag() {
        return 6;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_Double_info constant = new CONSTANT_Double_info();
        constant.setTag(getTag());
        constant.setHigh_bytes(classReader.readU4Int());
        constant.setLow_bytes(classReader.readU4Int());
        return constant;
    }
}
