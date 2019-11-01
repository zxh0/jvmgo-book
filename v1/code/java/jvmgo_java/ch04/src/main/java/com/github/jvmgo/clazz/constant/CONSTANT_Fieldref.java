package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Fieldref extends CONSTANT {

    private int class_index;

    private int name_and_type_index;

    @Override
    public int getTag() {
        return 9;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_Fieldref constant = new CONSTANT_Fieldref();
        constant.setTag(getTag());
        constant.setClass_index(classReader.readU2());
        constant.setName_and_type_index(classReader.readU2());
        return constant;
    }
}
