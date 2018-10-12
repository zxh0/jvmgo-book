package com.github.jvmgo.classfile.attributes;

import com.github.jvmgo.classfile.ClassReader;
import com.github.jvmgo.classfile.constantpool.ConstantPool;

/**
 * Code_attribute {
 * <p>
 * u2 attribute_name_index;
 * u4 attribute_length;
 * <p>
 * u2 max_stack;//操作数栈的最大深度
 * u2 max_locals;//局部变量表大小
 * <p>
 * //字节码
 * u4 code_length;
 * u1 code[code_length];
 * <p>
 * //异常处理表
 * u2 exception_table_length;
 * {
 * u2 start_pc;
 * u2 end_pc;
 * u2 handler_pc;
 * u2 catch_type;
 * }
 * exception_table[exception_table_length];
 * <p>
 * //属性表
 * u2 attributes_count;
 * attribute_info attributes[attributes_count];
 * }
 * ```
 */
public class CodeAttribute implements AttributeInfo {

    private int maxStack;//操作数栈的最大深度
    private int maxLocals;//局部变量表大小

    private byte[] code;//字节码

    private AttributeInfo[] attributes;//子属性

    private ConstantPool cp;
    private ExceptionTableEntry[] exceptionTable; //异常处理表

    public CodeAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    @Override
    public void readInfo(ClassReader reader) {
        maxStack = reader.nextU2ToInt();
        maxLocals = reader.nextU2ToInt();

        //字节码
        int codeLength = reader.nextU4ToInt();
        code = reader.nextBytes(codeLength);

        //异常处理表
        exceptionTable = ExceptionTableEntry.readExceptionTable(reader);

        attributes = AttributeInfo.readAttributes(reader, cp);
    }

    static class ExceptionTableEntry {

        private int startPc;
        private int endPc;
        private int handlerPc;
        private int catchType;

        private ExceptionTableEntry(ClassReader reader) {
            this.startPc = reader.nextU2ToInt();
            this.endPc = reader.nextU2ToInt();
            this.handlerPc = reader.nextU2ToInt();
            this.catchType = reader.nextU2ToInt();
        }

        static ExceptionTableEntry[] readExceptionTable(ClassReader reader) {
            int length = reader.nextU2ToInt();
            ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[length];

            for (int i = 0; i < length; i++) {
                exceptionTable[i] = new ExceptionTableEntry(reader);
            }
            return exceptionTable;
        }
    }

}
