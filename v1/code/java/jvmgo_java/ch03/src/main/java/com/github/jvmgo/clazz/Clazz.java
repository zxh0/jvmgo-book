package com.github.jvmgo.clazz;

import java.math.BigInteger;

import com.github.jvmgo.constantPool.ConstantPool;

public class Clazz {
	private static String CAFEBABE = new BigInteger("cafebabe",16).toString();
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
	
	public Clazz(byte[] classData) {
		reader = new ClassReader(classData);
		this.init();
	}
	
	
	private void init() {
		this.readAndCheckMinorVersion();
		this.readAndCheckMajorVersion();
		this.readConstantPool();
		this.readAcessFlag();
		this.readClassNameIndex();
		this.readSuperClassNameIndex();
		this.readInterfaceIndexes();
		this.readFields();
		this.readMethods();
		
	}
	
	private void readAndCheckMinorVersion() {
		//TBD
	}
	
	private void readAndCheckMajorVersion() {
		//TBD
	}
	
	private void readConstantPool() {
		//TBD
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
