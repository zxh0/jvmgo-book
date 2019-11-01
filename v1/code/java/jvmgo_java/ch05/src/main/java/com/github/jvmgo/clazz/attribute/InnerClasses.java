package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.ClassReader;
import com.github.jvmgo.clazz.constant.CONSTANT_Class_info;
import com.github.jvmgo.clazz.constant.CONSTANT_Utf8_info;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InnerClasses extends Attribute_info {

    private int number;

    private Clazz[] classes;

    @Override
    public String getName() {
        return "InnerClasses";
    }

    @Override
    public Attribute_info parseAttribute(ClassFile classFile) {
        if (!getName().equals(getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        setIndex(0);
        setNumber(read(2));
        Clazz[] clazzes = new Clazz[getNumber()];
        for (int i = 0; i < clazzes.length; i++) {
            Clazz clazz = new Clazz();
            CONSTANT_Class_info inner = (CONSTANT_Class_info) classFile.getConstantPool()[read(2)];
            clazz.setInner_class_info(inner);
            CONSTANT_Class_info outer = (CONSTANT_Class_info) classFile.getConstantPool()[read(2)];
            clazz.setOuter_class_info(outer);
            int read = read(2);
            if (read == 0)
                clazz.setInner_name(null);
            else {
                CONSTANT_Utf8_info inner_name = (CONSTANT_Utf8_info) classFile.getConstantPool()[read];
                clazz.setInner_name(inner_name);
            }
            byte[] bytes = readBytes(2);
            String s = ClassReader.toHexString(bytes);
            if (s.length() < 4) {
                for (; 0 < 4 - s.length(); ) {
                    s = "0" + s;
                }
            }
            clazz.setInner_class_access_flag(parseAccessFlag(s));
            clazzes[i] = clazz;
        }
        setClasses(clazzes);
        return this;
    }


    private String parseAccessFlag(String s) {
        StringBuilder builder = new StringBuilder();
        switch (s.charAt(3)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_PUBLIC ");
                break;
            case '2':
                builder.append("ACC_PRIVATE  ");
                break;
            case '4':
                builder.append("ACC_PROTECTED  ");
                break;
            case '8':
                builder.append("ACC_STATIC  ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(2)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_FINAL ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(1)) {
            case '0':
                break;
            case '2':
                builder.append("ACC_INTERFACE  ");
                break;
            case '4':
                builder.append("ACC_ABSTRACT  ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(0)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_SYNTHETIC ");
                break;
            case '2':
                builder.append("ACC_ANNOTATION  ");
                break;
            case '4':
                builder.append("ACC_ENUM  ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        return builder.toString();
    }

    @Getter
    @Setter
    class Clazz {

        private CONSTANT_Class_info inner_class_info;

        private CONSTANT_Class_info outer_class_info;

        private CONSTANT_Utf8_info inner_name;

        private String inner_class_access_flag;

    }
}
