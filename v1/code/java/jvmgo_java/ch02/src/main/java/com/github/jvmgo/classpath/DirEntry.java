package com.github.jvmgo.classpath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirEntry implements Entry {

    private Path absPath;

    public DirEntry(String path) {
        absPath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absPath.resolve(className));
    }

}
