package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.constant.CONSTANT_Class_info;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Exceptions extends Attribute_info {

    private int number;

    private CONSTANT_Class_info[] exceptions;

    @Override
    public String getName() {
        return "Exceptions";
    }

    @Override
    public Attribute_info parseAttribute(ClassFile classFile) {
        if (!getName().equals(getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        setIndex(0);
        setNumber(read(2));
        CONSTANT_Class_info[] constant_class_infos = new CONSTANT_Class_info[getNumber()];
        for (int i = 0; i < constant_class_infos.length; i++) {
            CONSTANT_Class_info constant_class_info = (CONSTANT_Class_info) classFile.getConstantPool()[read(2)];
            exceptions[i] = constant_class_info;
        }
        setExceptions(constant_class_infos);
        return this;
    }
}
