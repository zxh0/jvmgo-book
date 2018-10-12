package com.github.jvmgo.classfile.constantPool;

import com.github.jvmgo.classfile.ClassReader;
import lombok.Getter;

/**
 * {
 * u1 tag;
 * u2 name_index;
 * }
 */
@Getter
public class ConstClassInfo implements ConstantInfo{
	private ConstantPool constPool;
	private int nameIndex;
	
	public ConstClassInfo(ConstantPool aConstPool,ClassReader reader) {
		this.nameIndex = reader.nextU2ToInt();
		this.constPool = aConstPool;
	}

	@Override
	public String getValue() {
		return this.constPool.getUTF8(this.nameIndex);
	}


	@Override
	public String toString() {
		return  constPool.getUTF8(nameIndex);
	}
}
