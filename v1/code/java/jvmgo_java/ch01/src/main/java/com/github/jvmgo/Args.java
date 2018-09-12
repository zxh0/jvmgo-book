package com.github.jvmgo;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Args {

    @Parameter(names = {"-?", "-help"}, description = "print help message", help = true)
    boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version and exit")
    boolean versionFlag = false;

    @Parameter(names = { "-cp", "-classpath" }, description = "classpath")
    String classpath;

    JCommander cmd;
    boolean ok;

    static Args parse(String[] argv) {
        Args args = new Args();
        args.cmd = JCommander.newBuilder()
                .addObject(args)
                .build();

        try {
            args.cmd.parse(argv);
            args.ok = true;
        } catch (ParameterException e) {
            System.out.printf("Usage: <main class> [-options] class [args...]\n");
        }
    }

}
