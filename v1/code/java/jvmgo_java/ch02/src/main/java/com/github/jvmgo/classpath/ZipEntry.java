package com.github.jvmgo.classpath;

import java.nio.file.*;

public class ZipEntry implements Entry {

    private Path absPath;

    public ZipEntry(String path) {
        absPath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        try (FileSystem zipFs = FileSystems.newFileSystem(absPath, null)) {
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

}
