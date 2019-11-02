package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_InvokeDynamic_info extends CONSTANT {


    private int bootstrap_method_attr_index;

    private int name_and_type_index;


    @Override
    public int getTag() {
        return 18;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_InvokeDynamic_info constant = new CONSTANT_InvokeDynamic_info();
        constant.setTag(getTag());
        constant.setBootstrap_method_attr_index(classReader.readU2());
        constant.setName_and_type_index(classReader.readU2());
        return constant;
    }
}
