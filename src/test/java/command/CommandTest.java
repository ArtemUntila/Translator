package command;

import org.junit.Assert;
import org.junit.Test;
import translate.Translator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CommandTest {

    @Test
    public void testTranslateCommand() {
        String text = "Software Engineering 2022";
        String fromLang = "en";
        String toLang = "ru";

        // Redirect System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        // Simulate command execution
        Command.TranslateCommand translateCommand = new Command.TranslateCommand();
        translateCommand.setFromLang(fromLang);
        translateCommand.setToLang(toLang);
        translateCommand.setText(text);

        translateCommand.run();

        String translatorResult = Translator.translate(fromLang, toLang, text);
        String commandResult = out.toString().trim();

        Assert.assertEquals(translatorResult, commandResult);
        System.err.println(out);
    }

    @Test
    public void testListCommand() {
        // Redirect System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        // Simulate command execution
        Command.ListCommand listCommand = new Command.ListCommand();
        listCommand.run();

        String translatorResult = Translator.getLanguageCodes();
        String commandResult = out.toString();
        // Remove empty line in the end of String
        commandResult = commandResult.substring(0, commandResult.length() - 2);

        Assert.assertEquals(translatorResult, commandResult);
    }
}
