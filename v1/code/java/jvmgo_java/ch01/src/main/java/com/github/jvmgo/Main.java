package com.github.jvmgo;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Main {

    public static void main(String[] argv) {
        Args args = Args.parse(argv);

        Args args = new Args();
        JCommander cmd = JCommander.newBuilder()
                .addObject(args)
                .build();

        try {
            cmd.parse(argv);
        } catch (ParameterException e) {
            System.out.printf("Usage: <main class> [-options] class [args...]\n");
            return;
        }

        if (! args.ok) {

        }
        if (args.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }

        if (args.helpFlag) {
            cmd.usage();
            return;
        }
    }

}
