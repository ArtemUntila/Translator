import command.CommandExecutor;

public class Main {

    public static void main(String[] args) {
        int status = CommandExecutor.execute(args);
        System.exit(status);
    }
}
