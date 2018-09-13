package com.github.jvmgo.classpath;

import java.nio.file.*;

class ZipEntry implements Entry {

    private Path absPath;

    ZipEntry(String path) {
        absPath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        try (FileSystem zipFs = FileSystems.newFileSystem(absPath, null)) {
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

}
