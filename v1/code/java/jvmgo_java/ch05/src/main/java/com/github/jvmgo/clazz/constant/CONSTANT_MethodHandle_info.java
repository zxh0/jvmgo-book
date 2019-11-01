package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_MethodHandle_info extends CONSTANT {

    private int reference_kind;

    private int reference_index;

    @Override
    public int getTag() {
        return 15;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_MethodHandle_info constant = new CONSTANT_MethodHandle_info();
        constant.setTag(getTag());
        constant.setReference_kind(classReader.readU1());
        constant.setReference_index(classReader.readU2());
        return constant;
    }
}
