package com.github.jvmgo.clazz.attribute;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.ClassReader;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
public abstract class Attribute_info {

    private String attribute_name;

    private int attribute_length;

    private byte[] info;

    public abstract String getName();

    public abstract Attribute_info parseAttribute(ClassFile classFile);

    private static HashMap<String, Attribute_info> map = new HashMap<>();

    static {
        Code code = new Code();
        ConstantValue constantValue = new ConstantValue();
        Deprecated deprecated = new Deprecated();
        EnclosingMethod enclosingMethod = new EnclosingMethod();
        Exceptions exceptions = new Exceptions();
        InnerClasses innerClasses = new InnerClasses();
        LineNumberTable lineNumberTable = new LineNumberTable();
        LocalVariableTable localVariableTable = new LocalVariableTable();
        LocalVariableTypeTable localVariableTypeTable = new LocalVariableTypeTable();
        MethodParameters methodParameters = new MethodParameters();
        RuntimeVisibleAnnotations runtimeVisibleAnnotations = new RuntimeVisibleAnnotations();
        Signature signature = new Signature();
        SourceFile sourceFile = new SourceFile();
        SourceFileDebugExtension sourceFileDebugExtension = new SourceFileDebugExtension();
        StackMapTable stackMapTable = new StackMapTable();
        Synthetic synthetic = new Synthetic();

        map.put(code.getName(), code);
        map.put(constantValue.getName(), constantValue);
        map.put(deprecated.getName(), deprecated);
        map.put(enclosingMethod.getName(), enclosingMethod);
        map.put(exceptions.getName(), exceptions);
        map.put(innerClasses.getName(), innerClasses);
        map.put(lineNumberTable.getName(), lineNumberTable);
        map.put(localVariableTable.getName(), localVariableTable);
        map.put(localVariableTypeTable.getName(), localVariableTypeTable);
        map.put(methodParameters.getName(), methodParameters);
        map.put(runtimeVisibleAnnotations.getName(), runtimeVisibleAnnotations);
        map.put(signature.getName(), signature);
        map.put(sourceFile.getName(), sourceFile);
        map.put(sourceFileDebugExtension.getName(), sourceFileDebugExtension);
        map.put(stackMapTable.getName(), stackMapTable);
        map.put(synthetic.getName(), synthetic);

    }

    public static Attribute_info getInstance(String attribute_name) {
        return map.get(attribute_name);
    }


    private int index = 0;

    protected int read(int i) {
        int k = ClassReader.bytesToInt(Arrays.copyOfRange(getInfo(), index, index + i));
        index += i;
        return k;
    }

    protected byte[] readBytes(int length) {
        byte[] bytes = Arrays.copyOfRange(this.getInfo(), index, index + length);
        index += length;
        return bytes;
    }
}
