package com.github.jvmgo.classFile;

import com.github.jvmgo.Main;
import com.github.jvmgo.classFile.constantPool.ConstantPool;
import lombok.Getter;

import java.math.BigInteger;

@Getter
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
	



	//0xCAFEBABE
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
		accessFlag=reader.readUint16();
	}
	
	private void readClassNameIndex() {
		classNameIndex = reader.readUint16();

	}
	
	private void readSuperClassNameIndex() {
		superClassNameIndex= reader.readUint16();
	}
	
	private void readInterfaceIndexes() {
		inerfaceindexes=reader.readUint16s();
	}

	private void readFields() {
		fields=MemberInfo.readMembers(constantPool,reader);

	}
	private void readMethods() {
		methods=MemberInfo.readMembers(constantPool,reader);
	}


}
