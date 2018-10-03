package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classFile.ClassReader;

public class ConstMethodInfo implements ConstantInfo{
	private ConstantPool constPool;
	private int classIndex;
	private int nameAndTypeIndex;
	
	public ConstMethodInfo(ConstantPool aConstPool,ClassReader reader) {
		this.classIndex = reader.readUint16();
		this.nameAndTypeIndex = reader.readUint16();
	}

	@Override
	public String getValue() {
		return "";
	}

}
