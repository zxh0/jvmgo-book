package com.github.jvmgo.classpath;

import org.junit.Test;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class EntryTest {

    @Test
    public void create() {
        assertEquals(DirEntry.class, Entry.create(".").getClass());
        assertEquals(CompositeEntry.class,
                Entry.create("foo.jar" + File.pathSeparator + "bar.jar").getClass());
        assertEquals(WildcardEntry.class, Entry.create("foo/bar/*").getClass());
    }

}
