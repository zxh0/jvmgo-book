package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 12:41
 */
public class ConstantFloatInfo implements ConstantInfo{

    private float value;

    public ConstantFloatInfo(ConstantPool aConstPool, ClassReader reader) {
        //u4
        value = reader.readFloat();
    }

    @Override
    public String getValue() {
        return value+"";
    }

    @Override
    public String toString() {
        return "Float: "+value;
    }
}
