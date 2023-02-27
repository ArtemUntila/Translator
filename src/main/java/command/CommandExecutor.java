package command;

import picocli.CommandLine;

public class CommandExecutor {
    
    public static int execute(Object command, String[] args) {
        CommandLine commandLine = new CommandLine(command);
        return commandLine.execute(args);
    }
}
