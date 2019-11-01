package com.github.jvmgo.clazz.method;

import com.github.jvmgo.clazz.attribute.Attribute_info;
import com.github.jvmgo.clazz.attribute.Code;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Method_info {

    private String access_flag;

    private String name;

    private String descriptor;

    private int attributes_count;

    private Attribute_info[] attributes;

    public String accessFlagsToString(String s) {
        StringBuilder builder = new StringBuilder();
        switch (s.charAt(3)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_PUBLIC").append("    ");
                break;
            case '2':
                builder.append("ACC_PRIVATE").append("    ");
                break;
            case '4':
                builder.append("ACC_PROTECTED").append("    ");
                break;
            case '8':
                builder.append("ACC_STATIC").append("    ");
                break;
            case '9':
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
                builder.append("ACC_SYNCHRONIZED").append("    ");
                break;
            case '4':
                builder.append("ACC_BRIDGE").append("    ");
                break;
            case '8':
                builder.append("ACC_VARARGS").append("    ");
                break;
            default:
                throw new RuntimeException("can not parse access flag");
        }
        switch (s.charAt(1)) {
            case '0':
                break;
            case '1':
                builder.append("ACC_NATIVE");
                break;
            case '4':
                builder.append("ACC_ABSTRACT");
                break;
            case '8':
                builder.append("ACC_STRICT");
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
            default:
                throw new RuntimeException("can not parse access flag");
        }
        return builder.toString();
    }

    public Code getCodeAttribute() {
        for (Attribute_info attribute_info : attributes) {
            if (attribute_info instanceof Code) {
                return (Code) attribute_info;
            }
        }
        return null;
    }

}
