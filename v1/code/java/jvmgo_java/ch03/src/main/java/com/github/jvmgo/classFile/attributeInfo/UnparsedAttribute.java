package com.github.jvmgo.classFile.attributeInfo;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 19:18
 */
public class UnparsedAttribute implements AttributeInfo {
  private String name;
  private int length;
  private   byte[] info;

    public UnparsedAttribute(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
        info =reader.nextBytes(length);
        return this;
    }
}
