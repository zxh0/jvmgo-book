package com.github.jvmgo.constantPool;

import com.github.jvmgo.clazz.ClassReader;

public class ConstClassInfo implements ConstantInfo{
	private ConstantPool constPool;
	private int nameIndex;
	
	public ConstClassInfo(ConstantPool aConstPool,ClassReader reader) {
		this.nameIndex = reader.readUint16();
		this.constPool = aConstPool;
	}

	@Override
	public String getValue() {
		return this.constPool.getUTF8(this.nameIndex);
	}
	

	
}
