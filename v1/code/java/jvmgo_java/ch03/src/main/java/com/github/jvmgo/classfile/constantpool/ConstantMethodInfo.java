package com.github.jvmgo.classfile.constantpool;

import com.github.jvmgo.classfile.ClassReader;

public class ConstantMethodInfo implements ConstantInfo {

    private ConstantPool constPool;
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMethodInfo(ConstantPool aConstPool, ClassReader reader) {
        this.classIndex = reader.nextU2ToInt();
        this.nameAndTypeIndex = reader.nextU2ToInt();
    }

    @Override
    public String getValue() {
        return "";
    }

}
