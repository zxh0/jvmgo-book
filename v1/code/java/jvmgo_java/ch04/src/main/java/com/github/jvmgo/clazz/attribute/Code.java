package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.constant.CONSTANT_Utf8_info;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Code extends Attribute_info {
    //U2
    private int max_stack;
    //U2
    private int max_locals;
    //U4
    private int code_length;
    //U1[]
    private byte[] code;
    //U2
    private int exception_table_length;

    private Exception_table[] exception_table;
    //U2
    private int attributes_count;

    private Attribute_info[] attributes;

    @Override
    public String getName() {
        return "Code";
    }

    @Override
    public Code parseAttribute(ClassFile classFile) {
        setIndex(0);
        if (!getName().equals(this.getAttribute_name())) {
            throw new RuntimeException("parse source file exception");
        }
        max_stack = read(2);
        max_locals = read(2);
        code_length = read(4);
        code = readBytes(code_length);
        exception_table_length = read(2);

        Exception_table[] exception_tables = new Exception_table[exception_table_length];
        for (int i = 0; i < exception_table_length; i++) {
            Exception_table exception_table = new Exception_table();
            exception_table.setStart_pc(read(2));
            exception_table.setEnd_pc(read(2));
            exception_table.setHandler_pc(read(2));
            exception_table.setCatch_type(read(2));
            exception_tables[i] = exception_table;
        }
        this.setException_table(exception_tables);
        attributes_count = read(2);
        Attribute_info[] attribute_infos = new Attribute_info[attributes_count];
        for (int i = 0; i < attributes_count; i++) {
            int pool_index = read(2);
            CONSTANT_Utf8_info attributeName = (CONSTANT_Utf8_info) classFile.getConstantPool()[pool_index];
            Attribute_info attribute_info = Attribute_info.getInstance(attributeName.parseString());
            attribute_info.setAttribute_name(attributeName.parseString());
            int u4 = read(4);
            attribute_info.setAttribute_length(u4);
            attribute_info.setInfo(readBytes(u4));
            attribute_infos[i] = attribute_info.parseAttribute(classFile);
        }
        setAttributes(attribute_infos);
        return this;
    }

    @Getter
    @Setter
    class Exception_table {
        private int start_pc;

        private int end_pc;

        private int handler_pc;

        private int catch_type;
    }
}
