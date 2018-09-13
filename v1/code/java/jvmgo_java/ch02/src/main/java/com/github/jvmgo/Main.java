package com.github.jvmgo;

import com.github.jvmgo.classpath.Classpath;

import java.util.Arrays;

public class Main {

    public static void main(String[] argv) {
        Args args = Args.parse(argv);
        if (!args.ok || args.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
        } else if (args.versionFlag) {
            System.out.println("java version \"1.8.0\"");
        } else {
            startJVM(args);
        }
    }

    private static void startJVM(Args args) {
        Classpath cp = new Classpath(args.jre, args.classpath);
        System.out.printf("classpath:%s class:%s args:%s\n",
                cp, args.getMainClass(), args.getAppArgs());

        String className = args.getMainClass().replace(".", "/");
        try {
            byte[] classData = cp.readClass(className);
            System.out.println("class data: " + Arrays.toString(classData));
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + args.getMainClass());
        }
    }

}
