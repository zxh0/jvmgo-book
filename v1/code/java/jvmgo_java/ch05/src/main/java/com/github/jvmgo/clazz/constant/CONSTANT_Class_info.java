package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Class_info extends CONSTANT {

    private int name_index;

    @Override
    public int getTag() {
        return 7;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_Class_info constant_class = new CONSTANT_Class_info();
        constant_class.setTag(getTag());
        constant_class.setName_index(classReader.readU2());
        return constant_class;
    }
}
