package com.github.jvmgo.classpath;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CompositeEntry implements Entry {

    private final List<Entry> entries = new ArrayList<>();

    CompositeEntry(String pathList) {
        for (String path : pathList.split(File.pathSeparator)) {
            entries.add(Entry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className) throws Exception {
        for (Entry entry : entries) {
            try {
                return entry.readClass(className);
            } catch (Exception ignored) {

            }
        }

        throw new Exception("class not found: " + className);
    }

}
