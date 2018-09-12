package com.github.jvmgo.classpath;

public interface Entry {

    // className: fully/qualified/ClassName.class
    byte[] readClass(String className) throws Exception;

}
