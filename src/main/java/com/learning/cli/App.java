package com.learning.cli;

import com.learning.cli.commands.RootCommand;
import picocli.CommandLine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int exitCode = new CommandLine(new RootCommand())
                .execute("update", "--id=2", "-a=90");
        System.exit(exitCode);
    }
}
