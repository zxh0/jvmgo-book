package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CONSTANT_Utf8_info extends CONSTANT {

  private int length;

  private byte[] bytes;

  @Override
  public int getTag() {
    return 1;
  }

  @Override
  public CONSTANT parse(ClassReader classReader) {
    CONSTANT_Utf8_info constant = new CONSTANT_Utf8_info();
    constant.setTag(getTag());
    constant.setLength(classReader.readU2());
      byte[] bs = new byte[constant.getLength()];
    for (int i = 0; i < constant.getLength(); i++) {
      bs[i] = classReader.readU1Byte();
    }
    constant.setBytes(bs);
    return constant;
  }

  public String parseString() {
    return new String(bytes);
  }
}
