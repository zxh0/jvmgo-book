package com.github.jvmgo;

import com.beust.jcommander.Parameter;

public class Args {

    @Parameter(names = {"-?", "-help"}, description = "print help message", help = true)
    boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version and exit")
    boolean versionFlag = false;

    @Parameter(names = { "-cp", "-classpath" }, description = "classpath")
    String classpath;

}
