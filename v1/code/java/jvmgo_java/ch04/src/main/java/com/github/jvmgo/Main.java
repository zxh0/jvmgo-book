package com.github.jvmgo;

import com.github.jvmgo.classpath.Classpath;
import com.github.jvmgo.clazz.ClassFile;
import com.github.jvmgo.clazz.ClassReader;

import java.util.Arrays;

/**
 * @author liang
 * main方法 有问题, 运行时数据区域 测试可用
 *
 */
public class Main {

    public static void main(String[] args) {
        Args argv = Args.parse(args);
        if (argv.isHelpFlag()) {
            System.out.println("Usage: <main class> [-options] class [args...]");
        } else if (argv.isVersionFlag()) {
            System.out.println("java version \"1.8.0\"");
        } else {
            startJVM(argv);
        }
    }

    private static void startJVM(Args args) {
        Classpath cp = new Classpath(args.getJre(), args.getClasspath());
        System.out.printf("classpath:%s class:%s args:%s\n",
                cp, args.getMainClass(), args.getAppArgs());
        String className = args.getMainClass().replace(".", "/");
        try {
            byte[] classData = cp.readClass(className);
            ClassReader reader = new ClassReader(classData);
            ClassFile classFile = reader.parseClassFile();
            System.out.println("class data:" + Arrays.toString(classData));
        } catch (Exception e) {
            System.out.println("could not find or load main class" + args.getMainClass());
        }
    }
}
