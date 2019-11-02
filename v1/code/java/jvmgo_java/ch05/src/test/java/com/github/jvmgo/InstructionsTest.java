package com.github.jvmgo;

import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.ClassReader;
import com.github.jvmgo.clazz.method.Method_info;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class InstructionsTest {

    /**
     * 先执行MainTest 获取class文件
     *
     * @throws Exception
     */
    @Test
    public void t1() throws Exception {
        String path = "D:\\github\\jvmgo-book\\v1\\code\\java\\jvmgo_java\\ch05\\build\\classes\\java\\test\\com\\github\\jvmgo\\MainTest.class";
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        ClassReader classReader = new ClassReader(bytes);
        ClassFile classFile = classReader.parseClassFile();
        Method_info mainMethod = classFile.getMainMethod();
        Interpreter.execute(mainMethod.getCodeAttribute());
    }
}
