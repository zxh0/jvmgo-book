package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Synthetic extends Attribute_info {

    @Override
    public String getName() {
        return "Synthetic";
    }

    @Override
    public Attribute_info parseAttribute(ClassFile classFile) {
        setIndex(0);
        if (!getName().equals(getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        if (0 != getInfo().length || 0 != getAttribute_length()) {
            throw new RuntimeException("parse source file exception");
        }
        return this;
    }
}
