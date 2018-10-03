package com.github.jvmgo.classFile.attributeInfo;

import com.github.jvmgo.classFile.ClassReader;
import com.github.jvmgo.classFile.constantPool.ConstantPool;

/**
 Code_attribute {

 u2 attribute_name_index;
 u4 attribute_length;

 u2 max_stack;//操作数栈的最大深度
 u2 max_locals;//出局部变量表大小

 //字节码
 u4 code_length;
 u1 code[code_length];

 //异常处理表
 u2 exception_table_length;
 {
 u2 start_pc;
 u2 end_pc;
 u2 handler_pc;
 u2 catch_type;
 }
 exception_table[exception_table_length];

 //属性表
 u2 attributes_count;
 attribute_info attributes[attributes_count];
 }
 ```
 */
public class CodeAttribute implements AttributeInfo {
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private AttributeInfo[] attributes;
    private ConstantPool cp;
    private ExceptionTableEntry[] exceptionTable;

    public CodeAttribute(ConstantPool cp) {
        this.cp=cp;
    }

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
        maxStack = reader.readUint16();
        maxLocals = reader.readUint16();

        //字节码
        int codeLength = (int) reader.readUint32();
        code = reader.readByte(codeLength);

        //异常处理表
        exceptionTable = ExceptionTableEntry.readExceptionTable(reader);

        attributes = AttributeInfo.readAttributes(reader, cp);
        return this;
    }

  static   class ExceptionTableEntry  {


      private int  startPc   ;
      private int  endPc     ;
      private int  handlerPc ;
      private int  catchType ;

      private ExceptionTableEntry(ClassReader reader) {
          this.startPc =  reader.readUint16();
          this.endPc =  reader.readUint16();
          this.handlerPc =  reader.readUint16();
          this.catchType =  reader.readUint16();
      }

      static   ExceptionTableEntry[]  readExceptionTable(ClassReader reader){
          int length = reader.readUint16();
          ExceptionTableEntry[]  exceptionTable = new ExceptionTableEntry[length];

       for (int i=0;i<length;i++){
           exceptionTable[i]=new ExceptionTableEntry(reader);
       }
       return exceptionTable;
      }
    }


}
