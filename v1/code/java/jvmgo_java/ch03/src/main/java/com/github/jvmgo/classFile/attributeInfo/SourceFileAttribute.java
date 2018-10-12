package com.github.jvmgo.classfile.attributeInfo;

import com.github.jvmgo.classfile.ClassReader;
import com.github.jvmgo.classfile.constantPool.ConstantPool;

/**
 ```
 SourceFile_attribute {
 u2 attribute_name_index;
 u4 attribute_length;//必须2
 u2 sourcefile_index;//常量池索引，指向CONSTANT_Utf8_info常量
 }
 ```
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool cp;
    private String sourceFile;
    public SourceFileAttribute(ConstantPool cp) {
        this.cp=cp;
    }

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
       int sourceFileIndex =reader.nextU2ToInt();
       sourceFile =cp.getUTF8(sourceFileIndex);
        return this;
    }
}
