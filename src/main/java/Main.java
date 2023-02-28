import command.Command;
import command.CommandExecutor;

public class Main {

    public static void main(String[] args) {
        int status = CommandExecutor.execute(new Command(), args);
        System.exit(status);
    }
}
