package com.learning.cli.commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "root",
    description = "This is the root command",
    mixinStandardHelpOptions = true,
    subcommands = {
        AddCommand.class,
        DeleteCommand.class,
        ListCommand.class,
        SummaryCommand.class
    }
)
public class RootCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
