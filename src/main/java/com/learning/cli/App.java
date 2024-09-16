package com.learning.cli;

import com.learning.cli.commands.RootCommand;
import com.learning.cli.utils.CSVFile;
import picocli.CommandLine;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws URISyntaxException {
        int exitCode = new CommandLine(new RootCommand())
                .execute("update", "--id=2", "-a=90");
        Path path = Paths.get("src/main/java/com/learning/cli/expense.csv");
        CSVFile.writeToCSV(path);
        System.exit(exitCode);
    }
}
