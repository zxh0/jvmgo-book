package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.ClassReader;
import com.github.jvmgo.clazz.constant.CONSTANT_Utf8_info;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceFile extends Attribute_info {

  private String source_file;

  @Override
  public String getName() {
    return "SourceFile";
  }

  @Override
  public SourceFile parseAttribute(ClassFile classFile) {
    if (!getName().equals(this.getAttribute_name())) {
      throw new RuntimeException("parse source file exception");
    }
    if (2 != this.getAttribute_length()) {
      throw new RuntimeException("parse source file exception");
    }
    if (2 != this.getInfo().length) {
      throw new RuntimeException("parse source file exception");
    }
    int index = ClassReader.bytesToInt(this.getInfo());
    CONSTANT_Utf8_info constant_utf8_info = (CONSTANT_Utf8_info) classFile.getConstantPool()[index];
    this.setSource_file(constant_utf8_info.parseString());
    return this;
  }
}
