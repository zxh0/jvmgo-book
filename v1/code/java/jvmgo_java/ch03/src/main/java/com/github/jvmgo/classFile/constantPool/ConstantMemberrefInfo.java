package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classFile.ClassReader;

/**
 * @Author: panda
 * @Date: 2018/10/3 0003 15:19
 *
 * CONSTANT_XXXXref_info {
 *   u1 tag;
 *   u2 class_index;//指向CONSTANT_Class_info
 *   u2 name_and_type_index;//指向CONSTANT_NameAndType_info
 * }
 *
 */
public class ConstantMemberrefInfo implements ConstantInfo{

    private ConstantPool constPool;

    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberrefInfo(ConstantPool aConstPool, ClassReader reader) {
        this.classIndex = reader.readUint16();
        this.nameAndTypeIndex = reader.readUint16();
        this.constPool = aConstPool;
    }

    @Override
    public String getValue() {

        return constPool.getUTF8(classIndex)+" "+constPool.getUTF8(nameAndTypeIndex);
    }



    @Override
    public String toString() {
        ConstantInfo[] constantInfos = constPool.getConstantInfos();
        ConstClassInfo constClassInfo= (ConstClassInfo) constantInfos[classIndex];
        ConstantNameAndTypeInfo nameAndTypeInfo= (ConstantNameAndTypeInfo) constantInfos[nameAndTypeIndex];
        return "ConstantMemberrefInfo{" +
                 constClassInfo +"  "+
                  nameAndTypeInfo +
                '}';
    }
}
