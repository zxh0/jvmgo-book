package com.github.jvmgo.clazz.constant;

import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public abstract class CONSTANT {

  private int tag;

  public abstract int getTag();

  protected abstract CONSTANT parse(ClassReader classReader);

  private static HashMap<Integer, CONSTANT> map = new HashMap<>();

  public static CONSTANT parseConstant(int tag, ClassReader classReader) {
    CONSTANT constant = map.get(tag);
    return constant.parse(classReader);
  }

  static {
    CONSTANT_Class_info constant_class = new CONSTANT_Class_info();
    map.put(constant_class.getTag(), constant_class);
    CONSTANT_Double_info constant_double_info = new CONSTANT_Double_info();
    map.put(constant_double_info.getTag(), constant_double_info);
    CONSTANT_Fieldref constant_fieldref = new CONSTANT_Fieldref();
    map.put(constant_fieldref.getTag(), constant_fieldref);
    CONSTANT_Float_info constant_float_info = new CONSTANT_Float_info();
    map.put(constant_float_info.getTag(), constant_float_info);
    CONSTANT_Inter_info constant_inter_info = new CONSTANT_Inter_info();
    map.put(constant_inter_info.getTag(), constant_inter_info);
    CONSTANT_InterfaceMethodref_info constant_interfaceMethodref_info =
        new CONSTANT_InterfaceMethodref_info();
    map.put(constant_interfaceMethodref_info.getTag(), constant_interfaceMethodref_info);
    CONSTANT_InvokeDynamic_info constant_invokeDynamic_info = new CONSTANT_InvokeDynamic_info();
    map.put(constant_invokeDynamic_info.getTag(), constant_invokeDynamic_info);
    CONSTANT_Long_info constant_long_info = new CONSTANT_Long_info();
    map.put(constant_long_info.getTag(), constant_long_info);
    CONSTANT_MethodHandle_info constant_methodHandle_info = new CONSTANT_MethodHandle_info();
    map.put(constant_methodHandle_info.getTag(), constant_methodHandle_info);
    CONSTANT_Methodref_info constant_methodref_info = new CONSTANT_Methodref_info();
    map.put(constant_methodref_info.getTag(), constant_methodref_info);
    CONSTANT_MethodType_info constant_methodType_info = new CONSTANT_MethodType_info();
    map.put(constant_methodType_info.getTag(), constant_methodType_info);
    CONSTANT_NameAndType_info constant_nameAndType_info = new CONSTANT_NameAndType_info();
    map.put(constant_nameAndType_info.getTag(), constant_nameAndType_info);
    CONSTANT_String_info constant_string_info = new CONSTANT_String_info();
    map.put(constant_string_info.getTag(), constant_string_info);
    CONSTANT_Utf8_info constant_utf8_info = new CONSTANT_Utf8_info();
    map.put(constant_utf8_info.getTag(), constant_utf8_info);
  }
}
