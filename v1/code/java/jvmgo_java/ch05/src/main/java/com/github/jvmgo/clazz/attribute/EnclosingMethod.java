package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.constant.CONSTANT_Class_info;
import com.github.jvmgo.clazz.constant.CONSTANT_NameAndType_info;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnclosingMethod extends Attribute_info {

    private CONSTANT_Class_info clazz;

    private CONSTANT_NameAndType_info method;

    @Override
    public String getName() {
        return "EnclosingMethod";
    }

    @Override
    public EnclosingMethod parseAttribute(ClassFile classFile) {
        if (!getName().equals(this.getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        if (4 != this.getAttribute_length()) {
            throw new RuntimeException("parse source file exception");
        }
        int clazz_index = read(2);

        CONSTANT_Class_info constant_class_info = (CONSTANT_Class_info) classFile.getConstantPool()[clazz_index];
        setClazz(constant_class_info);
        int method_index = read(2);
        if (method_index == 0) {
            setMethod(null);
        } else {
            CONSTANT_NameAndType_info constant_nameAndType_info = (CONSTANT_NameAndType_info) classFile.getConstantPool()[method_index];
            setMethod(constant_nameAndType_info);
        }
        return this;
    }
}
