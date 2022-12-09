package command;

import org.junit.Assert;
import org.junit.Test;
import translate.Translator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandTest {

    @Test
    public void testTranslateCommand() throws Exception {
        String text = "Software Engineering 2022";
        String fromLang = "en";
        String toLang = "ru";

        // Redirect System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        // Simulate command execution
        Command.TranslateCommand translateCommand = new Command.TranslateCommand();
        translateCommand.fromLang = fromLang;
        translateCommand.toLang = toLang;
        translateCommand.text = text;
        translateCommand.run();

        String translatorResult = Translator.translate(fromLang, toLang, text);
        String commandResult = out.toString().trim();

        Assert.assertEquals(translatorResult, commandResult);
        System.err.println(out);
    }

    @Test
    public void testListCommand() throws Exception {
        // Redirect System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        // Simulate command execution
        Command.ListCommand listCommand = new Command.ListCommand();
        listCommand.run();

        List<String> translatorResult = Translator.getLanguageList();
        List<String> commandResult = Arrays.asList(out.toString().split("\n"));

        // Trim elements
        translatorResult = translatorResult.stream().map(String::trim).collect(Collectors.toList());
        commandResult = commandResult.stream().map(String::trim).collect(Collectors.toList());

        Assert.assertEquals(translatorResult, commandResult);
        System.err.println(out);
    }
}
