package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.constant.CONSTANT;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantValue extends Attribute_info {

    private CONSTANT constant_value;

    @Override
    public String getName() {
        return "ConstantValue";
    }

    @Override
    public Attribute_info parseAttribute(ClassFile classFile) {
        setIndex(0);
        if (!getName().equals(getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        if (2 != getInfo().length || 2 != getAttribute_length()) {
            throw new RuntimeException("parse source file exception");
        }
        int pool_index = read(2);
        CONSTANT constant = classFile.getConstantPool()[pool_index];
        setConstant_value(constant);
        return this;
    }
}
