package com.github.jvmgo.constantPool;

import java.util.ArrayList;
import java.util.List;

import com.github.jvmgo.clazz.ClassReader;

public class ConstantPool {
	private List<ConstantInfo> constantInfo;
	
	public ConstantPool(ClassReader reader) {
		this.init(reader);
	}
	
	
	private void init(ClassReader reader) {
		this.constantInfo = new ArrayList<>();
		int constantPoolSize = reader.readUint16();
		for(int i = 1; i < constantPoolSize ; i++) {
			int tag = reader.readUint8();
			ConstantInfo constInfo = ConstantInfo.createConstantInfo(tag, reader,this);
			this.constantInfo.add(constInfo);
			
			if(tag == ConstantInfo.CONST_TAG_DOUBLE || tag == ConstantInfo.CONST_TAG_LONG) {
				i++;
			}
		}
	}
	
	
	public String getUTF8(int index) {
		ConstantInfo constInfo = this.constantInfo.get(index);
		return constInfo == null ? ""  :constInfo.toString();
	}
}
