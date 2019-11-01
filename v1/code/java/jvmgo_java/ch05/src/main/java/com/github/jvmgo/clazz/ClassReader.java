package com.github.jvmgo.clazz;

import com.github.jvmgo.clazz.attribute.Attribute_info;
import com.github.jvmgo.clazz.constant.CONSTANT;
import com.github.jvmgo.clazz.constant.CONSTANT_Class_info;
import com.github.jvmgo.clazz.constant.CONSTANT_Utf8_info;
import com.github.jvmgo.clazz.field.Field_info;
import com.github.jvmgo.clazz.method.Method_info;

import java.util.Arrays;

public class ClassReader {

    private int pos;

    private byte[] bytes;

    public ClassReader(byte[] bytes) {
        this.bytes = bytes;
        pos = 0;
    }

    public ClassFile parseClassFile() {
        ClassFile classFile = new ClassFile();
        parseMagic(classFile);
        parseMinOrVersion(classFile);
        parseMajorVersion(classFile);
        parseConstantPoolCount(classFile);
        parseConstantPool(classFile);
        parseAccessFlags(classFile);
        parseThisClass(classFile);
        parseSuperClass(classFile);
        parseInterfacesCount(classFile);
        parseInterfaces(classFile);
        parseFieldsCount(classFile);
        parseFields(classFile);
        parseMethodCount(classFile);
        parseMethods(classFile);
        parseAttributesCount(classFile);
        parseAttributes(classFile);
        return classFile;
    }

    private void parseAttributes(ClassFile classFile) {
        Attribute_info[] attribute_infos = new Attribute_info[classFile.getAttributesCount()];
        for (int i = 0; i < attribute_infos.length; i++) {
            CONSTANT_Utf8_info attributeName = (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
            Attribute_info attribute_info = Attribute_info.getInstance(attributeName.parseString());
            attribute_info.setAttribute_name(attributeName.parseString());
            int u4 = readU4Int();
            attribute_info.setAttribute_length(u4);
            attribute_info.setInfo(readBytes(u4));
            attribute_infos[i] = attribute_info.parseAttribute(classFile);
        }
        classFile.setAttributes(attribute_infos);
    }

    private void parseAttributesCount(ClassFile classFile) {
        classFile.setAttributesCount(readU2());
    }

    private void parseMethods(ClassFile classFile) {
        Method_info[] method_infos = new Method_info[classFile.getMethodsCount()];
        for (int i = 0; i < method_infos.length; i++) {
            Method_info method_info = new Method_info();
            String s = toHexString(readU2Byte());
            if (s.length() < 4) {
                for (; 0 < 4 - s.length(); ) {
                    s = "0" + s;
                }
            }
            method_info.setAccess_flag(method_info.accessFlagsToString(s));
            CONSTANT_Utf8_info constant_utf8_info =
                    (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
            method_info.setName(constant_utf8_info.parseString());
            CONSTANT_Utf8_info constant_utf8_info2 =
                    (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
            method_info.setDescriptor(constant_utf8_info2.parseString());
            int attribute_count = readU2();
            method_info.setAttributes_count(attribute_count);

            Attribute_info[] attribute_infos = new Attribute_info[attribute_count];
            for (int j = 0; j < attribute_count; j++) {
                CONSTANT_Utf8_info attributeName = (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
                Attribute_info attribute_info = Attribute_info.getInstance(attributeName.parseString());
                attribute_info.setAttribute_name(attributeName.parseString());
                int u4 = readU4Int();
                attribute_info.setAttribute_length(u4);
                attribute_info.setInfo(readBytes(u4));
                attribute_infos[j] = attribute_info.parseAttribute(classFile);
            }
            method_info.setAttributes(attribute_infos);
            method_infos[i] = method_info;
        }
        classFile.setMethods(method_infos);
    }

    private void parseMethodCount(ClassFile classFile) {
        classFile.setMethodsCount(readU2());
    }

    private void parseFields(ClassFile classFile) {
        Field_info[] field_infos = new Field_info[classFile.getFieldsCount()];
        for (int i = 0; i < field_infos.length; i++) {
            Field_info field_info = new Field_info();
            String s = toHexString(readU2Byte());
            if (s.length() < 4) {
                for (; 0 < 4 - s.length(); ) {
                    s = "0" + s;
                }
            }
            field_info.setAccess_flag(field_info.accessFlagsToString(s));
            CONSTANT_Utf8_info constant_utf8_info =
                    (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
            field_info.setName(constant_utf8_info.parseString());
            CONSTANT_Utf8_info constant_utf8_info2 =
                    (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
            field_info.setDescriptor(constant_utf8_info2.parseString());
            int attribute_count = readU2();
            field_info.setAttributes_count(attribute_count);

            Attribute_info[] attribute_infos = new Attribute_info[attribute_count];
            for (int j = 0; j < attribute_count; j++) {
                CONSTANT_Utf8_info attributeName = (CONSTANT_Utf8_info) classFile.getConstantPool()[readU2()];
                Attribute_info attribute_info = Attribute_info.getInstance(attributeName.parseString());
                attribute_info.setAttribute_name(attributeName.parseString());
                int u4 = readU4Int();
                attribute_info.setAttribute_length(u4);
                attribute_info.setInfo(readBytes(u4));
                attribute_infos[j] = attribute_info.parseAttribute(classFile);
            }
            field_info.setAttributes(attribute_infos);
            field_infos[i] = field_info;
        }
        classFile.setFields(field_infos);
    }

    private void parseFieldsCount(ClassFile classFile) {
        classFile.setFieldsCount(readU2());
    }

    private void parseInterfaces(ClassFile classFile) {
        CONSTANT_Utf8_info[] infos = new CONSTANT_Utf8_info[classFile.getInterfacesCount()];
        for (int i = 0; i < classFile.getInterfacesCount(); i++) {
            CONSTANT_Class_info constant_class_info =
                    (CONSTANT_Class_info) classFile.getConstantPool()[readU2()];
            CONSTANT_Utf8_info constant_utf8_info =
                    (CONSTANT_Utf8_info) classFile.getConstantPool()[constant_class_info.getName_index()];
            infos[i] = constant_utf8_info;
        }
        classFile.setInterfaces(infos);
    }

    private void parseInterfacesCount(ClassFile classFile) {
        classFile.setInterfacesCount(readU2());
    }

    private void parseThisClass(ClassFile classFile) {
        CONSTANT_Class_info constant_class_info =
                (CONSTANT_Class_info) classFile.getConstantPool()[readU2()];
        CONSTANT_Utf8_info constant_utf8_info =
                (CONSTANT_Utf8_info) classFile.getConstantPool()[constant_class_info.getName_index()];
        classFile.setThisClass(constant_utf8_info.parseString());
    }

    private void parseSuperClass(ClassFile classFile) {
        int index = readU2();
        if (index == 0) {
            classFile.setSuperClass("Object");
            return;
        }
        CONSTANT_Class_info constant_class_info =
                (CONSTANT_Class_info) classFile.getConstantPool()[index];
        CONSTANT_Utf8_info constant_utf8_info =
                (CONSTANT_Utf8_info) classFile.getConstantPool()[constant_class_info.getName_index()];
        classFile.setSuperClass(constant_utf8_info.parseString());
    }

    private void parseAccessFlags(ClassFile classFile) {
        String s = toHexString(readU2Byte());
        if (s.length() < 4) {
            for (; 0 < 4 - s.length(); ) {
                s = "0" + s;
            }
        }
        classFile.setAccessFlags(accessFlagsToString(s));
    }

    private String accessFlagsToString(String s) {
        StringBuilder builder = new StringBuilder();
        switch (s.charAt(3)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_PUBLIC").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(2)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_FINAL").append("    ");
                break;
            case '2':
                builder.append("ACC_SUPER").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(1)) {
            case '0':
                break;
            case '2':
                builder.append("ACC_INTERFACE").append("    ");
                break;
            case '4':
                builder.append("ACC_ABSTRACT").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(0)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_SYNTHETIC");
                break;
            case '2':
                builder.append("ACC_ANNOTATION");
                break;
            case '4':
                builder.append("ACC_ENUM");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        return builder.toString();
    }

    private void parseConstantPool(ClassFile classFile) {
        int count = classFile.getConstantPoolCount();
        CONSTANT[] cpInfos = new CONSTANT[count];
        cpInfos[0] = null;
        for (int i = 1; i < count; i++) {
            int tag = readU1();
            cpInfos[i] = CONSTANT.parseConstant(tag, this);
        }
        classFile.setConstantPool(cpInfos);
    }

    private void parseConstantPoolCount(ClassFile classFile) {
        classFile.setConstantPoolCount(readU2());
    }

    private void parseMajorVersion(ClassFile classFile) {
        classFile.setMajorVersion(readU2());
    }

    private void parseMinOrVersion(ClassFile classFile) {
        classFile.setMinorVersion(readU2());
    }

    private void parseMagic(ClassFile classFile) {
        classFile.setMagic(readU4());
    }

    public int readU1() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 1);
        pos += 1;
        return bytesToInt(bytes);
    }

    public byte[] readBytes(int length) {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + length);
        pos += length;
        return bytes;
    }

    public byte readU1Byte() {
        byte b = this.bytes[pos];
        pos += 1;
        return b;
    }

    public int readU2() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 2);
        pos += 2;
        return bytesToInt(bytes);
    }

    public byte[] readU2Byte() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 2);
        pos += 2;
        return bytes;
    }

    public String readU4() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 4);
        pos += 4;
        return bytesToString(bytes);
    }

    public int readU4Int() {
        byte[] bytes = Arrays.copyOfRange(this.bytes, pos, pos + 4);
        pos += 4;
        return bytesToInt(bytes);
    }

    public static String bytesToString(byte[] bytes) {
        return toHexString(bytes);
    }

    public static int bytesToInt(byte[] bytes) {
        return Integer.valueOf(toHexString(bytes), 16);
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(Integer.toHexString(b & 0xFF));
        }
        return builder.toString();
    }
}
