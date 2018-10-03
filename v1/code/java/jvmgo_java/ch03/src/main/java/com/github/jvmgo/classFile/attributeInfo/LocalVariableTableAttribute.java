package com.github.jvmgo.classFile.attributeInfo;

import com.github.jvmgo.classFile.ClassReader;


public class LocalVariableTableAttribute implements AttributeInfo {
    private LocalVariableTableEntry[] localVariableTable;

    @Override
    public AttributeInfo readInfo(ClassReader reader) {
        int length = reader.readUint16();
        localVariableTable = new LocalVariableTableEntry[length];
        for (int i=0;i<length;i++){
            localVariableTable[i]=new LocalVariableTableEntry(reader);
        }

        return this;
    }

    private class LocalVariableTableEntry {
        private final int startPc;
        private final int length;
        private final int nameIndex;
        private final int descriptorIndex;
        private final int index;

        public LocalVariableTableEntry(ClassReader reader) {
                    startPc         =reader.readUint16();
                    length          =reader.readUint16();
                    nameIndex       =reader.readUint16();
                    descriptorIndex =reader.readUint16();
                    index           =reader.readUint16();
        }
    }

}
