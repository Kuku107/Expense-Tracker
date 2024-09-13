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
                .execute("add", "--description=vcl that su", "--amount=1.3");
        System.exit(exitCode);
    }
}
