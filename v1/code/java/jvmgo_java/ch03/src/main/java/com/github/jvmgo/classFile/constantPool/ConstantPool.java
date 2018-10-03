package com.github.jvmgo.classFile.constantPool;

import com.github.jvmgo.classFile.ClassReader;
import lombok.Getter;

@Getter
public class ConstantPool {

	private final int constantPoolSize;
	private ConstantInfo[] constantInfos;
	
	public ConstantPool(ClassReader reader) {
		constantPoolSize = reader.readUint16();
		constantInfos = new  ConstantInfo[constantPoolSize];
		for(int i = 1; i < constantPoolSize ; i++) {
			int tag = reader.readUint8();
			ConstantInfo constInfo = ConstantInfo.createConstantInfo(tag, reader,this);
			constantInfos[i]=constInfo;

			if(tag == ConstantInfo.CONST_TAG_DOUBLE || tag == ConstantInfo.CONST_TAG_LONG) {
				i++;
			}
		}
	}
	
	

	
	
	public String getUTF8(int index) {
		ConstantInfo constInfo = this.constantInfos[index];
		return constInfo == null ? ""  :constInfo.toString();
	}
}
