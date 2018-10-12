package com.github.jvmgo.classfile.constantpool;

import com.github.jvmgo.classfile.ClassReader;

public class ConstantStringInfo implements ConstantInfo {

    private ConstantPool constPool;
    private int nameIndex;

    public ConstantStringInfo(ConstantPool aConstPool, ClassReader reader) {
        this.nameIndex = reader.nextU2ToInt();
        this.constPool = aConstPool;
    }

    @Override
    public String getValue() {
        return this.constPool.getUTF8(this.nameIndex);
    }

    @Override
    public String toString() {
        return "ConstStringInfo{" +
                "name=" + constPool.getUTF8(nameIndex) +
                '}';
    }

}
