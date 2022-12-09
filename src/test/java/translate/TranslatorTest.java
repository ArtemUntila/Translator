package translate;

import org.junit.Assert;
import org.junit.Test;

public class TranslatorTest {

    @Test
    public void testTranslate() throws Exception {
        String enText = "Software Engineering 2022";
        String ruText = "Программная инженерия 2022";

        String fromEnToRu = Translator.translate("en", "ru", enText);
        Assert.assertEquals(ruText, fromEnToRu);

        String fromRuToEn = Translator.translate("ru", "en", ruText);
        Assert.assertEquals(enText, fromRuToEn);
    }

    @Test
    public void testTranslateException() {
        // Incorrect language code "rus"
        Assert.assertThrows(Exception.class, () -> Translator.translate("rus", "en", ""));
    }

    @Test
    public void testList() throws Exception {
        Assert.assertNotNull(Translator.getLanguageList());
        Assert.assertEquals(91, Translator.getLanguageList().size());
    }
}
