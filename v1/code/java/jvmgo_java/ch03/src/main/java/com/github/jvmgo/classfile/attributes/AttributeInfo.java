package com.github.jvmgo.classfile.attributes;

import com.github.jvmgo.classfile.ClassReader;
import com.github.jvmgo.classfile.constantpool.ConstantPool;

/*
attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 info[attribute_length];
}
*/
public interface AttributeInfo {

    void readInfo(ClassReader reader);

    static AttributeInfo[] readAttributes(ClassReader reader, ConstantPool cp) {
        int attributesCount = reader.nextU2ToInt();
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];

        for (int i = 0; i < attributesCount; i++) {
            attributes[i] = readAttribute(reader, cp);
        }

        return attributes;
    }

    static AttributeInfo readAttribute(ClassReader reader, ConstantPool cp) {
        int attrNameIndex = reader.nextU2ToInt();
        String attrName = cp.getUTF8(attrNameIndex);
        long attrLen = reader.nextU4ToInt();
        AttributeInfo attributeInfo = newAttributeInfo(attrName, attrLen, cp);
        attributeInfo.readInfo(reader);
        return attributeInfo;
    }

    //todo 工厂方法xml配置?
    static AttributeInfo newAttributeInfo(String attrName, long attrLen, ConstantPool cp) {
        switch (attrName) {
            //method属性
            case "Code"://方法体
                return new CodeAttribute(cp);
            //field属性
            case "ConstantValue"://常量表达式的值  存常量池索引
                return new ConstantValueAttribute();
            //method属性
            case "Exceptions"://变长属性，记录方法抛出的异常表
                return new ExceptionsAttribute();
            //以下3是调试信息 不一定要 使用javac编译器编译Java程序时，默认会在class文件中生成 这些信息
            //  method属性的Code属性的属性
            case "LineNumberTable"://方法行号
                return new LineNumberTableAttribute();
            //  method属性的Code属性的属性
            case "LocalVariableTable"://方法局部变量
                return new LocalVariableTableAttribute();
            //class属性
            case "SourceFile"://源文件名 如 XXX.java
                return new SourceFileAttribute(cp);
            //最简单的两种属性，仅起标记作用，不包含任何数据。
            //ClassFile、field_info和method_info都可以用
            case "Synthetic"://为了支持嵌套类和嵌套接口
                return new SyntheticAttribute();
            case "Deprecated"://废弃标记
                return new DeprecatedAttribute();
            //不支持
            default:
                return new UnparsedAttribute(attrName, (int) attrLen);
        }
    }

}
