package com.github.jvmgo.classfile.constantpool;

import com.github.jvmgo.classfile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 12:41
 */
public class ConstantDoubleInfo implements ConstantInfo {

    private Double value;

    public ConstantDoubleInfo(ClassReader reader) {
        value = reader.next2U4Double(); //u4
    }

    @Override
    public String getValue() {
        return value + "";
    }

    @Override
    public String toString() {
        return "Double:" + value;
    }

}
