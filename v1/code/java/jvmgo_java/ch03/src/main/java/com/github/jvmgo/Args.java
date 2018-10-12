package com.github.jvmgo;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.util.List;

public class Args {

    @Parameter(names = {"-?", "-help"}, description = "print help message", order = 3, help = true)
    boolean helpFlag = false;

    @Parameter(names = "-version", description = "print version and exit", order = 2)
    boolean versionFlag = false;

    @Parameter(names = { "-cp", "-classpath" }, description = "classpath", order = 1)
    String classpath;

    @Parameter(names = "-Xjre", description = "path to jre", order = 4)
    String jre;

    @Parameter(description = "main class and args")
    List<String> mainClassAndArgs;

    boolean ok;


    String getMainClass() {
        return mainClassAndArgs != null && !mainClassAndArgs.isEmpty()
                ? mainClassAndArgs.get(0)
                : null;
    }

    List<String> getAppArgs() {
        return mainClassAndArgs != null && mainClassAndArgs.size() >1
                ? mainClassAndArgs.subList(1, mainClassAndArgs.size())
                : null;
    }

    static Args parse(String[] argv) {
        Args args = new Args();
        JCommander cmd = JCommander.newBuilder()
                .addObject(args)
                .build();

        try {
            cmd.parse(argv);
            args.ok = true;
        } catch (ParameterException ignored) {

        }

        return args;
    }

}
