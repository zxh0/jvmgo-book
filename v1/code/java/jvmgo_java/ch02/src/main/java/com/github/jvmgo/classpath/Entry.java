package com.github.jvmgo.classpath;

import java.io.File;

public interface Entry {

    // className: fully/qualified/ClassName.class
    byte[] readClass(String className) throws Exception;

    // factory method
    static Entry create(String path) {
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        } if (path.endsWith("*")) {
            return new WildcardEntry(path);
        } if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        } else {
            return new DirEntry(path);
        }
    }

}
