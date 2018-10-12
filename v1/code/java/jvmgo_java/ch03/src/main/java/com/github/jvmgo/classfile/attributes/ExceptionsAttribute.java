package com.github.jvmgo.classfile.attributes;

import com.github.jvmgo.classfile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 21:37
 */
public class ExceptionsAttribute implements AttributeInfo {

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader reader) {
        exceptionIndexTable = reader.nextUint16s();
    }

}
