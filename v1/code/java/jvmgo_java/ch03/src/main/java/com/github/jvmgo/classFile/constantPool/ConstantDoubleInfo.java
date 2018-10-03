package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 12:41
 */
public class ConstantDoubleInfo implements ConstantInfo{

    private Double value;

    public ConstantDoubleInfo(ConstantPool aConstPool, ClassReader reader) {
        //u4
        value  = reader.readDouble();
    }

    @Override
    public String getValue() {
        return value+"";
    }

    @Override
    public String toString() {
        return "Double:"+value;
    }
}
