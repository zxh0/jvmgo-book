package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_String_info extends CONSTANT {

    private int string_index;

    @Override
    public int getTag() {
        return 8;
    }

    @Override
    public CONSTANT parse(ClassReader classReader) {
        CONSTANT_String_info constant = new CONSTANT_String_info();
        constant.setTag(getTag());
        constant.setString_index(classReader.readU2());
        return constant;
    }
}
