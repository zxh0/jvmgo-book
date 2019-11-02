package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Float_info extends CONSTANT {


    private int value;

    @Override
    public int getTag() {
        return 4;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_Float_info constant = new CONSTANT_Float_info();
        constant.setTag(getTag());
        constant.setValue(classReader.readU4Int());
        return constant;
    }
}
