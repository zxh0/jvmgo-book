package com.github.jvmgo.classpath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class WildcardEntry extends CompositeEntry {

    public WildcardEntry(String path) {
        super(toPathList(path));
    }

    private static String toPathList(String wildcardPath) {
        String baseDir = wildcardPath.substring(wildcardPath.length() - 1); // remove *
        try {
            return Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .map(p -> p.toString())
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            //e.printStackTrace(System.err);
            return "";
        }
    }

}
