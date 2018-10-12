package com.github.jvmgo.classpath;

import org.junit.Test;
import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EntryTest {

    @Test
    public void create() {
        assertEquals(DirEntry.class, Entry.create(".").getClass());
        assertEquals(CompositeEntry.class,
                Entry.create("foo.jar" + File.pathSeparator + "bar.jar").getClass());
        assertEquals(WildcardEntry.class, Entry.create("foo/bar/*").getClass());
    }

    @Test
    public void dirEntry() throws Exception {
        String className = EntryTest.class.getName().replace('.', '/') + ".class";
        String classesDir = EntryTest.class.getResource("EntryTest.class")
                .getPath().replace(className, "");

        Entry entry = Entry.create(classesDir);
        assertEquals(DirEntry.class, entry.getClass());

        byte[] data = entry.readClass(className);
        assertNotNull(data);
    }

    @Test
    public void zipEntry() throws Exception {
        String[] cp = System.getProperty("java.class.path").split(File.pathSeparator);
        String rtJarPath = Arrays.stream(cp)
                .filter(path -> path.endsWith("/junit-4.12.jar"))
                .findFirst()
                .get();

        Entry entry = Entry.create(rtJarPath);
        assertEquals(ZipEntry.class, entry.getClass());

        byte[] data = entry.readClass("org/junit/Test.class");
        assertNotNull(data);
    }

    @Test
    public void compositeEntry() throws Exception {
        String cp = System.getProperty("java.class.path");

        Entry entry = Entry.create(cp);
        assertEquals(CompositeEntry.class, entry.getClass());

        byte[] data = entry.readClass("org/junit/Test.class");
        assertNotNull(data);
    }

    @Test
    public void wildcardEntry() throws Exception {
        String[] cp = System.getProperty("java.class.path").split(File.pathSeparator);
        String rtJarPath = Arrays.stream(cp)
                .filter(path -> path.endsWith("/junit-4.12.jar"))
                .findFirst()
                .get()
                .replace("/junit-4.12.jar", "/*");

        Entry entry = Entry.create(rtJarPath);
        assertEquals(WildcardEntry.class, entry.getClass());

        byte[] data = entry.readClass("org/junit/Test.class");
        assertNotNull(data);
    }

}
