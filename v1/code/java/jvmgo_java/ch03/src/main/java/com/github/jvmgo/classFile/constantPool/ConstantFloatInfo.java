package com.github.jvmgo.classfile.constantpool;

import com.github.jvmgo.classfile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 12:41
 */
public class ConstantFloatInfo implements ConstantInfo {

    private float value;

    public ConstantFloatInfo(ClassReader reader) {
        value = reader.nextU4ToFloat();//u4
    }

    @Override
    public String getValue() {
        return value + "";
    }

    @Override
    public String toString() {
        return "Float: " + value;
    }

}
