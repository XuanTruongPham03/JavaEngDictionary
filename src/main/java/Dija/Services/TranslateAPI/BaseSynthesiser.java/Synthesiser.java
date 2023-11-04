package Dija.Services.TranslateAPI.BaseSynthesiser.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

public class Synthesiser extends BaseSynthesiser {
    private static final String GOOGLE_SYNTHESISER_URL = "http://translate.google.com/translate_tts";
    private String languageCode;
    public static final String LANG_AU_ENGLISH = "en-AU";
    public static final String LANG_US_ENGLISH = "en-US";
    public static final String LANG_UK_ENGLISH = "en-GB";
    public static final String LANG_ES_SPANISH = "es";
    public static final String LANG_FR_FRENCH = "fr";
    public static final String LANG_DE_GERMAN = "de";
    public static final String LANG_PT_PORTUGUESE = "pt-pt";
    public static final String LANG_PT_BRAZILIAN = "pt-br";

    public Synthesiser() {
        this.languageCode = "auto";
    }

    public Synthesiser(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguage() {
        return this.languageCode;
    }

    public void setLanguage(String languageCode) {
        this.languageCode = languageCode;
    }

    public InputStream getMP3Data(String synthText) throws IOException {
        String languageCode = this.languageCode;
        if (languageCode == null || languageCode.equals("") || languageCode.equalsIgnoreCase("auto")) {
            languageCode = this.detectLanguage(synthText);
            if (languageCode == null) {
                languageCode = "en-us";
            }
        }

        if (synthText.length() > 100) {
            List<String> fragments = this.parseString(synthText);
            String tmp = this.getLanguage();
            this.setLanguage(languageCode);
            InputStream out = this.getMP3Data(fragments);
            this.setLanguage(tmp);
            return out;
        } else {
            String encoded = URLEncoder.encode(synthText, "UTF-8");
            StringBuilder sb = new StringBuilder();
            sb.append("http://translate.google.com/translate_tts");
            sb.append("?tl=");
            sb.append(languageCode);
            sb.append("&q=");
            sb.append(encoded);
            sb.append("&ie=UTF-8&total=1&idx=0");
            sb.append("&textlen=");
            sb.append(synthText.length());
            sb.append("&client=tw-ob");
            URL url = new URL(sb.toString());
            URLConnection urlConn = url.openConnection();
            urlConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0");
            return urlConn.getInputStream();
        }
    }
}
