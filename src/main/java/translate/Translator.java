package translate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Translator {
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String TRANSLATE = "https://api.whatsmate.net/v1/translation/translate";

    public static String translate(String fromLang, String toLang, String text) throws Exception {

        String jsonPayload = String.format("{\"fromLang\":\"%s\",\"toLang\":\"%s\",\"text\":\"%s\"}", fromLang, toLang, text);

        URL url = new URL(TRANSLATE);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        conn.setRequestProperty("Content-Type", "application/json");

        OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(jsonPayload);
        bw.close();


        int statusCode = conn.getResponseCode();
        if (statusCode != 200) throw new Exception();

        InputStreamReader isr = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }
        br.close();

        conn.disconnect();

        return sb.toString();
    }
}
