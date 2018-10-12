package com.github.jvmgo.classpath;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Classpath {

    private Entry bootClasspath;
    private Entry extClasspath;
    private Entry userClasspath;

    public Classpath(String jreOption, String cpOption) {
        parseBootAndExtClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    private void parseBootAndExtClasspath(String jreOption) {
        String jreDir = getJreDir(jreOption);

        // jre/lib/*
        String jreLibPath = Paths.get(jreDir, "lib") + File.separator + "*";
        bootClasspath = new WildcardEntry(jreLibPath);

        // jre/lib/ext/*
        String jreExtPath = Paths.get(jreDir, "lib", "ext") + File.separator + "*";
        extClasspath = new WildcardEntry(jreExtPath);
    }

    private static String getJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }
        if (Files.exists(Paths.get("./jre"))) {
            return "./jre";
        }
        String jh = System.getenv("JAVA_HOME");
        if (jh != null) {
            return Paths.get(jh, "jre").toString();
        }
        throw new RuntimeException("Can not find JRE folder!");
    }

    private void parseUserClasspath(String cpOption) {
        if (cpOption == null) {
            cpOption = ".";
        }
        userClasspath = Entry.create(cpOption);
    }

    // className: fully/qualified/ClassName
    public byte[] readClass(String className) throws Exception {
        className = className + ".class";

        try {
            return bootClasspath.readClass(className);
        } catch (Exception ignored) {

        }

        try {
            return bootClasspath.readClass(className);
        } catch (Exception ignored) {

        }

        return userClasspath.readClass(className);
    }


    public static String join(String... paths) {
        return Arrays.stream(paths)
                .collect(Collectors.joining(File.pathSeparator));
    }

    public static String[] split(String pathList) {
        return pathList.split(File.pathSeparator);
    }

}
