package command;

import picocli.CommandLine;
import translate.Translator;

import java.util.List;

@CommandLine.Command(name = "translator", subcommands = {Command.TranslateCommand.class, Command.ListCommand.class})
public class Command {

    @CommandLine.Command(name = "translate", description = "Translate text")
    static class TranslateCommand implements Runnable {

        @CommandLine.Option(names = {"-f", "--from"}, description = "From language", required = true)
        String fromLang;

        @CommandLine.Option(names = {"-t", "--to"}, description = "To language", required = true)
        String toLang;

        @CommandLine.Parameters(description = "Text to translate")
        String text;

        @Override
        public void run() {
            try {
                String translatedText = Translator.translate(fromLang, toLang, text);
                System.out.println(translatedText);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @CommandLine.Command(name = "list", description = "List of supported languages and their codes")
    static class ListCommand implements Runnable {

        @Override
        public void run() {
            try {
                List<String> languageList = Translator.getLanguageList();
                languageList.forEach(System.out::println);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
