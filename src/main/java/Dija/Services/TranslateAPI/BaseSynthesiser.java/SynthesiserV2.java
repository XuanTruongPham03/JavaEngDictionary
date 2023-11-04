package Dija.Services.TranslateAPI.BaseSynthesiser.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

public class SynthesiserV2 extends BaseSynthesiser {
    private static final String GOOGLE_SYNTHESISER_URL = "https://www.google.com/speech-api/v2/synthesize?enc=mpeg&client=chromium";
    private final String API_KEY;
    private String languageCode;
    private double pitch = 1.0;
    private double speed = 1.0;

    public SynthesiserV2(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String getLanguage() {
        return this.languageCode;
    }

    public void setLanguage(String languageCode) {
        this.languageCode = languageCode;
    }

    public double getPitch() {
        return this.pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public InputStream getMP3Data(String synthText) throws IOException {
        String languageCode = this.languageCode;
        if (languageCode == null || languageCode.equals("") || languageCode.equalsIgnoreCase("auto")) {
            try {
                languageCode = this.detectLanguage(synthText);
                if (languageCode == null) {
                    languageCode = "en-us";
                }
            } catch (Exception var7) {
                var7.printStackTrace();
                languageCode = "en-us";
            }
        }

        if (synthText.length() > 100) {
            System.out.println("synthText: " + synthText.toString());
            List<String> fragments = this.parseString(synthText);
            System.out.println("fragments synthText: " + fragments.toString());
            String tmp = this.getLanguage();
            this.setLanguage(languageCode);
            InputStream out = this.getMP3Data(fragments);
            this.setLanguage(tmp);
            return out;
        } else {
            synthText = synthText.replace(' ', '+');
            System.out.println("synthText after convert to send: " + synthText);
            String encoded = URLEncoder.encode(synthText, "UTF-8");
            StringBuilder sb = new StringBuilder("https://www.google.com/speech-api/v2/synthesize?enc=mpeg&client=chromium");
            sb.append("&key=" + this.API_KEY);
            sb.append("&text=" + synthText);
            sb.append("&lang=" + languageCode);
            if (this.speed >= 0.0 && this.speed <= 2.0) {
                sb.append("&speed=" + this.speed / 2.0);
            }

            if (this.pitch >= 0.0 && this.pitch <= 2.0) {
                sb.append("&pitch=" + this.pitch / 2.0);
            }

            URL url = new URL(sb.toString());
            System.out.println("url" + url.toString());
            URLConnection urlConn = url.openConnection();
            urlConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0");
            return urlConn.getInputStream();
        }
    }

    public URLConnection getUrlConn(String synthText) throws IOException {
        String languageCode = this.languageCode;
        if (languageCode == null || languageCode.equals("") || languageCode.equalsIgnoreCase("auto")) {
            try {
                languageCode = this.detectLanguage(synthText);
                if (languageCode == null) {
                    languageCode = "en-us";
                }
            } catch (Exception var7) {
                var7.printStackTrace();
                languageCode = "en-us";
            }
        }

        synthText = synthText.replace(' ', '+');
        System.out.println("synthText after convert to send: " + synthText);
        String encoded = URLEncoder.encode(synthText, "UTF-8");
        StringBuilder sb = new StringBuilder("https://www.google.com/speech-api/v2/synthesize?enc=mpeg&client=chromium");
        sb.append("&key=" + this.API_KEY);
        sb.append("&text=" + synthText);
        sb.append("&lang=" + languageCode);
        if (this.speed >= 0.0 && this.speed <= 2.0) {
            sb.append("&speed=" + this.speed / 2.0);
        }

        if (this.pitch >= 0.0 && this.pitch <= 2.0) {
            sb.append("&pitch=" + this.pitch / 2.0);
        }

        URL url = new URL(sb.toString());
        System.out.println("url" + url.toString());
        URLConnection urlConn = url.openConnection();
        urlConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0");
        return urlConn;
    }
}
