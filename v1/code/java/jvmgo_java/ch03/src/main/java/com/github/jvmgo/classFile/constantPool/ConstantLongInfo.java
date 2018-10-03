package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 12:41
 */
public class ConstantLongInfo implements ConstantInfo{

    private long value;

    public ConstantLongInfo(ConstantPool aConstPool, ClassReader reader) {
        //u4
        value  = reader.readLong();
    }

    @Override
    public String getValue() {
        return value+"";
    }

    @Override
    public String toString() {
        return "Long: "+value;
    }
}
