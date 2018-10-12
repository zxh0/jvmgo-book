package com.github.jvmgo.classfile.attributes;

import com.github.jvmgo.classfile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 19:18
 */
public class UnparsedAttribute implements AttributeInfo {

    private String name;
    private int length;
    private byte[] info;

    public UnparsedAttribute(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public void readInfo(ClassReader reader) {
        info = reader.nextBytes(length);
    }

}
