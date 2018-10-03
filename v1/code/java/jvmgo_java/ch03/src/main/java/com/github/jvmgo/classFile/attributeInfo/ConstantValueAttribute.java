package com.github.jvmgo.classFile.attributeInfo;

import com.github.jvmgo.classFile.ClassReader;

/**
 ConstantValue_attribute {
 u2 attribute_name_index;
 u4 attribute_length;//2
 u2 constantvalue_index;//常量池索引
 }
 */
public class ConstantValueAttribute implements AttributeInfo {

    //具体指向哪种常量因字段类型而异。
   private int constantValueIndex;

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
        constantValueIndex = reader.readUint16();
        return this;
    }
}
