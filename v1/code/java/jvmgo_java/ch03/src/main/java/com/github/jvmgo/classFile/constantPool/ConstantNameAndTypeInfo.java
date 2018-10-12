package com.github.jvmgo.classfile.constantpool;

import com.github.jvmgo.classfile.ClassReader;
import lombok.Getter;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 15:04
 * CONSTANT_NameAndType_info {
 * u1 tag;
 * u2 name_index;//字段或方法名
 * u2 descriptor_index;//描述符
 * }
 */
@Getter
public class ConstantNameAndTypeInfo implements ConstantInfo {

    private ConstantPool constPool;
    private int nameIndex;
    private int descriptorIndex;

    public ConstantNameAndTypeInfo(ConstantPool aConstPool, ClassReader reader) {
        this.nameIndex = reader.nextU2ToInt();
        this.descriptorIndex = reader.nextU2ToInt();
        this.constPool = aConstPool;
    }

    @Override
    public String getValue() {
        return "";
    }

    @Override
    public String toString() {
        return this.constPool.getUTF8(this.nameIndex) + "&"
                + this.constPool.getUTF8(this.descriptorIndex);
    }

}
