package com.github.jvmgo.classfile;

import com.github.jvmgo.Main;
import com.github.jvmgo.classfile.constantPool.ConstantPool;
import lombok.Getter;

@Getter
public class ClassFile {
	//private static Long CAFEBABE = new BigInteger("cafebabe",16).longValue();
	//private static int ACC_PUBLIC =0x0021;

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
		String magic = this.reader.nextU4ToHexString();
		if(!"cafebabe".equals(magic)) {
			Main.panic("java.lang.ClassFormatError: magic!");
		}
	}
	
	private void readAndCheckVersion() {
		this.minorVersion = this.reader.nextU2ToInt();
		this.majorVersion = this.reader.nextU2ToInt();
		
		if(this.majorVersion >=46 && this.majorVersion <=52 && this.minorVersion ==0) {
			return;
		}
		Main.panic("java.lang.UnsupportedClassVersionError!");
	}
	
	
	private void readConstantPool() {
		this.constantPool = new ConstantPool(this.reader);
		
	}
	private void readAcessFlag() {
		accessFlag=reader.nextU2ToInt();
	}
	
	private void readClassNameIndex() {
		classNameIndex = reader.nextU2ToInt();

	}
	
	private void readSuperClassNameIndex() {
		superClassNameIndex= reader.nextU2ToInt();
	}
	
	private void readInterfaceIndexes() {
		inerfaceindexes=reader.nextUint16s();
	}

	private void readFields() {
		fields=MemberInfo.readMembers(constantPool,reader);

	}
	private void readMethods() {
		methods=MemberInfo.readMembers(constantPool,reader);
	}


}
