package com.github.jvmgo.classFile.attributeInfo;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 21:37
 */
public class ExceptionsAttribute implements AttributeInfo {
    private int[] eceptionIndexTable;

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
       eceptionIndexTable = reader.readUint16s();
       return this;
    }
}
