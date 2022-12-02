package command;

import picocli.CommandLine;

public class CommandExecutor {

    public static int execute(String[] args) {
        Command command = new Command();
        CommandLine commandLine = new CommandLine(command);
        return commandLine.execute(args);
    }
}
