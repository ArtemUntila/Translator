package translate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Translator {

    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String TRANSLATE = "https://api.whatsmate.net/v1/translation/translate";
    private static final String SUPPORTED_CODES = "https://api.whatsmate.net/v1/translation/supported-codes";

    private static final RestTemplate restTemplate = new RestTemplate();

    public static String translate(String fromLang, String toLang, String text) {
        // Actually, there is almost no difference between HttpHeaders and MultiValueMap<String, String>
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-WM-CLIENT-ID", CLIENT_ID);
        headers.add("X-WM-CLIENT-SECRET", CLIENT_SECRET);

        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("fromLang", fromLang);
        jsonData.put("toLang", toLang);
        jsonData.put("text", text);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);

        return restTemplate.postForObject(TRANSLATE, request, String.class);
    }

    public static String getLanguageCodes() {
        String languageCodes = restTemplate.getForObject(SUPPORTED_CODES, String.class);
        Objects.requireNonNull(languageCodes);

        // Remove json brackets and empty lines
        return languageCodes.replaceAll("(\\{\n)|(\n})", "");
    }
}
