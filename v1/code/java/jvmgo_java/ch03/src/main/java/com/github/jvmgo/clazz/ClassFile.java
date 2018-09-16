package com.github.jvmgo.clazz;

import java.math.BigInteger;

import com.github.jvmgo.Main;
import com.github.jvmgo.constantPool.ConstantPool;

public class ClassFile {
	private static Long CAFEBABE = new BigInteger("cafebabe",16).longValue();
	private static int ACC_PUBLIC =0x0021;
	
	private int minorVersion;
	private int majorVersion;
	private ConstantPool constantPool;
	private int accessFlag;
	private int classNameIndex;
	private int superClassNameIndex;
	private int[] inerfaceindexes;
	private MemberInfo[] fields;
	private MemberInfo[] methods;
	private ClassReader reader;
	
	public ClassFile(byte[] classData) {
		reader = new ClassReader(classData);
		this.init();
//for test start
for(byte b : classData) {
	System.out.print(String.format("%02x",b)+",");
}
System.out.println();
//for test end
		
	}
	
	
	private void init() {
		this.readAndCheckMagic();
		this.readAndCheckVersion();
		this.readConstantPool();
		this.readAcessFlag();
		this.readClassNameIndex();
		this.readSuperClassNameIndex();
		this.readInterfaceIndexes();
		this.readFields();
		this.readMethods();
		
	}
	
	private void readAndCheckMagic() {
		long magic = this.reader.readUint32();
		if(magic != ClassFile.CAFEBABE) {
			Main.panic("java.lang.ClassFormatError: magic!");
		}
	}
	
	private void readAndCheckVersion() {
		this.minorVersion = this.reader.readUint16();
		this.majorVersion = this.reader.readUint16();
		
		if(this.majorVersion >=46 && this.majorVersion <=52 && this.minorVersion ==0) {
			return;
		}
		Main.panic("java.lang.UnsupportedClassVersionError!");
	}
	
	
	private void readConstantPool() {
		this.constantPool = new ConstantPool(this.reader);
		
	}
	private void readAcessFlag() {
		//TBD
	}
	
	private void readClassNameIndex() {
		//TBD
	}
	
	private void readSuperClassNameIndex() {
		//TBD
	}
	
	private void readInterfaceIndexes() {
		//TBD
	}
	
	private void readFields() {
		//TBD
	}
	private void readMethods() {
		//TBD
	}
	
}
