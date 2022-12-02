package command;

import picocli.CommandLine;
import translate.Translator;

@CommandLine.Command(name = "translator", subcommands = {Command.TranslateCommand.class})
public class Command {

    @CommandLine.Command(name = "translate", description = "Translate text")
    static class TranslateCommand implements Runnable {

        @CommandLine.Parameters(description = "Text to translate")
        String text;

        @Override
        public void run() {
            try {
                String translatedText = Translator.translate("en", "ru", text);
                System.out.println(translatedText);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
