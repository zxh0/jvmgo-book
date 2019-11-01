package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_MethodType_info extends CONSTANT {

    private int descriptor_index;

    @Override
    public int getTag() {
        return 16;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_MethodType_info constant = new CONSTANT_MethodType_info();
        constant.setTag(getTag());
        constant.setDescriptor_index(classReader.readU2());
        return constant;
    }
}
