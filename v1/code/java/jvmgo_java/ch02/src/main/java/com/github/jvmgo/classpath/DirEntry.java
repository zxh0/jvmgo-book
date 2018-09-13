package com.github.jvmgo.classpath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DirEntry implements Entry {

    private Path absPath;

    DirEntry(String path) {
        absPath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absPath.resolve(className));
    }

}
