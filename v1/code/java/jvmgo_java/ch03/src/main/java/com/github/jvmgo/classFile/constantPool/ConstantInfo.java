package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.Main;
import com.github.jvmgo.classFile.ClassReader;

public interface ConstantInfo {
	public static final int CONST_TAG_CLASS = 7;
	public static final int CONST_TAG_FIELD_REF = 9;
	public static final int CONST_TAG_METHOD_REF = 10;
	public static final int CONST_TAG_INTERFACE_MTTHOD_REF = 11;
	public static final int CONST_TAG_STRING = 8;
	public static final int CONST_TAG_INTEGER = 3;
	public static final int CONST_TAG_FLOAT = 4;
	public static final int CONST_TAG_LONG = 5;
	public static final int CONST_TAG_DOUBLE = 6;
	public static final int CONST_TAG_NAME_AND_TYPE = 12;
	public static final int CONST_TAG_UTF8 = 1;
	public static final int CONST_TAG_METHOD_HANDLE = 15;
	public static final int CONST_TAG_METHOD_TYPE = 16;
	public static final int CONST_TAG_INVOKE_DYNAMIC = 18;
	
	
	
	public String getValue();
	
	
	//Factory method
	public static ConstantInfo createConstantInfo(int tag, ClassReader reader,ConstantPool constPool) {

		ConstantInfo constantInfo = null;

		switch(tag) {

		    //数字
            case CONST_TAG_INTEGER: constantInfo = new ConstantIntegerInfo( constPool,reader);
                break;
            case CONST_TAG_FLOAT: constantInfo = new ConstantFloatInfo( constPool,reader);
                break;
            case CONST_TAG_LONG: constantInfo = new ConstantLongInfo( constPool,reader);
                break;
            case CONST_TAG_DOUBLE: constantInfo = new ConstantDoubleInfo( constPool,reader);
            break;

            case CONST_TAG_UTF8: constantInfo = new ConstUft8Info(constPool,reader);
                break;

            //以下3个引用UTF8
            case CONST_TAG_STRING: constantInfo = new ConstStringInfo(constPool,reader);
                break;
            case CONST_TAG_CLASS: constantInfo = new ConstClassInfo(constPool,reader);
                break;
            case CONST_TAG_NAME_AND_TYPE: constantInfo = new ConstantNameAndTypeInfo(constPool,reader);
                break;

            //以下3个引用CLASS+NAME_AND_TYPE
            case CONST_TAG_FIELD_REF: constantInfo = new ConstantMemberrefInfo(constPool,reader);
            break;
            case CONST_TAG_METHOD_REF: constantInfo = new ConstantMemberrefInfo(constPool,reader);
            break;
            case CONST_TAG_INTERFACE_MTTHOD_REF: constantInfo = new ConstantMemberrefInfo(constPool,reader);
            break;

            //是Java SE 7才添加到class文件中的，目的是支持新增的invokedynamic指令
            case CONST_TAG_METHOD_HANDLE: constantInfo = null;
            break;
            case CONST_TAG_METHOD_TYPE: constantInfo = null;
            break;
            case CONST_TAG_INVOKE_DYNAMIC: constantInfo = null;
            break;

            default:
                Main.panic("java.lang.ClassFormatError: constant poll tag!");
            break;
		}
		
		return constantInfo;
	}


}
