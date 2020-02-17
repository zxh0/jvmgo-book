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
            byte[] bytes = null;
            try {
                bytes = entry.readClass(className);
            } catch (Exception e) {
                continue;
                //忽略异常，继续执行
            }
            if (bytes != null && bytes.length > 0) {
                return bytes;
            }
        }

        throw new Exception("class not found: " + className);
    }

}
