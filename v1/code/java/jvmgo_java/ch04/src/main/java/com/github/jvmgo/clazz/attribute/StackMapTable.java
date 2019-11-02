package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StackMapTable extends Attribute_info {

    private int number;

    private Stack_map_frame[] entries;

    @Override
    public String getName() {
        return "StackMapTable";
    }

    @Override
    public Attribute_info parseAttribute(ClassFile classFile) {
        setIndex(0);
        setNumber(read(2));
        Stack_map_frame[] stack_map_frames = new Stack_map_frame[getNumber()];
        for (int i = 0; i < getNumber(); i++) {

        }
        setEntries(stack_map_frames);
        return this;
    }

    class Stack_map_frame {

    }
}
