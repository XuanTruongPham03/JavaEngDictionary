package Dija.Services.TranslateAPI;
//import com.fasterxml.jackson.annotation.JsonGetter;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonSetter;
//
//
//public interface Translator {
//    /**
//     * Translate method
//     * @param src source language
//     * @param dest  destination language
//     * @param text word to translate
//     * @return TranslatedData
//     */
//    TranslatedData translate(Translator.LanguageCode src,
//                             Translator.LanguageCode dest,
//                             String text);
//    enum LanguageCode {
//        @JsonProperty("en")
//        EN("en"),
//        @JsonProperty("vi")
//        VI("vi"),
//        @JsonProperty("af")
//        AF("af"),
//        @JsonProperty("sq")
//        SQ("sq"),
//        @JsonProperty("am")
//        AM("am"),
//        @JsonProperty("ar")
//        AR("ar"),
//        @JsonProperty("hy")
//        HY("hy"),
//        @JsonProperty("az")
//        AZ("az"),
//        @JsonProperty("eu")
//        EU("eu"),
//        @JsonProperty("be")
//        BE("be"),
//        @JsonProperty("bn")
//        BN("bn"),
//        @JsonProperty("bs")
//        BS("bs"),
//        @JsonProperty("bg")
//        BG("bg"),
//        @JsonProperty("ca")
//        CA("ca"),
//        @JsonProperty("ceb")
//        CEB("ceb"),
//        @JsonProperty("zh")
//        ZH("zh"),
//        @JsonProperty("co")
//        CO("co"),
//        @JsonProperty("hr")
//        HR("hr"),
//        @JsonProperty("cs")
//        CS("cs"),
//        @JsonProperty("da")
//        DA("da"),
//        @JsonProperty("nl")
//        NL("nl"),
//        @JsonProperty("eo")
//        EO("eo"),
//        @JsonProperty("et")
//        ET("et"),
//        @JsonProperty("fi")
//        FI("fi"),
//        @JsonProperty("fr")
//        FR("fr"),
//        @JsonProperty("fy")
//        FY("fy"),
//        @JsonProperty("gl")
//        GL("gl"),
//        @JsonProperty("ka")
//        KA("ka"),
//        @JsonProperty("de")
//        DE("de"),
//        @JsonProperty("el")
//        EL("el"),
//        @JsonProperty("gu")
//        GU("gu"),
//        @JsonProperty("ht")
//        HT("ht"),
//        @JsonProperty("ha")
//        HA("ha"),
//        @JsonProperty("hi")
//        HI("hi"),
//        @JsonProperty("hu")
//        HU("hu"),
//        @JsonProperty("is")
//        IS("is"),
//        @JsonProperty("ig")
//        IG("ig"),
//        @JsonProperty("id")
//        ID("id"),
//        @JsonProperty("ga")
//        GA("ga"),
//        @JsonProperty("it")
//        IT("it"),
//        @JsonProperty("ja")
//        JA("ja"),
//        @JsonProperty("jv")
//        JV("jv"),
//        @JsonProperty("kn")
//        KN("kn"),
//        @JsonProperty("kk")
//        KK("kk"),
//        @JsonProperty("km")
//        KM("km"),
//        @JsonProperty("rw")
//        RW("rw"),
//        @JsonProperty("ko")
//        KO("ko"),
//        @JsonProperty("ku")
//        KU("ku"),
//        @JsonProperty("ky")
//        KY("ky"),
//        @JsonProperty("lo")
//        LO("lo"),
//        @JsonProperty("la")
//        LA("la"),
//        @JsonProperty("lv")
//        LV("lv"),
//        @JsonProperty("lt")
//        LT("lt"),
//        @JsonProperty("lb")
//        LB("lb"),
//        @JsonProperty("mk")
//        MK("mk"),
//        @JsonProperty("mg")
//        MG("mg"),
//        @JsonProperty("ms")
//        MS("ms"),
//        @JsonProperty("ml")
//        ML("ml"),
//        @JsonProperty("mt")
//        MT("mt"),
//        @JsonProperty("mi")
//        MI("mi"),
//        @JsonProperty("mr")
//        MR("mr"),
//        @JsonProperty("mn")
//        MN("mn"),
//        @JsonProperty("my")
//        MY("my"),
//        @JsonProperty("ne")
//        NE("ne"),
//        @JsonProperty("no")
//        NO("no"),
//        @JsonProperty("ny")
//        NY("ny"),
//        @JsonProperty("or")
//        OR("or"),
//        @JsonProperty("ps")
//        PS("ps"),
//        @JsonProperty("fa")
//        FA("fa"),
//        @JsonProperty("pl")
//        PL("pl"),
//        @JsonProperty("pt")
//        PT("pt"),
//        @JsonProperty("pa")
//        PA("pa"),
//        @JsonProperty("ro")
//        RO("ro"),
//        @JsonProperty("ru")
//        RU("ru"),
//        @JsonProperty("sm")
//        SM("sm"),
//        @JsonProperty("gd")
//        GD("gd"),
//        @JsonProperty("sr")
//        SR("sr"),
//        @JsonProperty("st")
//        ST("st"),
//        @JsonProperty("sn")
//        SN("sn"),
//        @JsonProperty("sd")
//        SD("sd"),
//        @JsonProperty("si")
//        SI("si"),
//        @JsonProperty("sk")
//        SK("sk"),
//        @JsonProperty("sl")
//        SL("sl"),
//        @JsonProperty("so")
//        SO("so"),
//        @JsonProperty("es")
//        ES("es"),
//        @JsonProperty("su")
//        SU("su"),
//        @JsonProperty("sw")
//        SW("sw"),
//        @JsonProperty("sv")
//        SV("sv"),
//        @JsonProperty("tl")
//        TL("tl"),
//        @JsonProperty("tg")
//        TG("tg"),
//        @JsonProperty("ta")
//        TA("ta"),
//        @JsonProperty("tt")
//        TT("tt"),
//        @JsonProperty("te")
//        TE("te"),
//        @JsonProperty("th")
//        TH("th"),
//        @JsonProperty("tr")
//        TR("tr"),
//        @JsonProperty("tk")
//        TK("tk"),
//        @JsonProperty("uk")
//        UK("uk"),
//        @JsonProperty("ur")
//        UR("ur"),
//        @JsonProperty("ug")
//        UG("ug"),
//        @JsonProperty("uz")
//        UZ("uz"),
//        @JsonProperty("cy")
//        CY("cy"),
//        @JsonProperty("xh")
//        XH("xh"),
//        @JsonProperty("yi")
//        YI("yi"),
//        @JsonProperty("yo")
//        YO("yo"),
//        @JsonProperty("zu")
//        ZU("zu");
//
//
//        final String code;
//
//        LanguageCode(String code) {
//            this.code = code;
//        }
//        @Override
//        public String toString() {
//            return code;
//        }
//    }
//    class TranslatedData {
//        public static TranslatedData EMPTY;
//
//        static {
//            EMPTY = new TranslatedData();
//        }
//
//        @JsonProperty("text")
//        private String text;
//
//        @JsonProperty("translated")
//        private String translated;
//
//        @JsonProperty("src")
//        private LanguageCode src;
//
//        @JsonProperty("dest")
//        private LanguageCode dest;
//
//        private TranslatedData() {
//
//        }
//
//        public TranslatedData(String text, String translate, LanguageCode src, LanguageCode dest) {
//            this.text = text;
//            this.translated = translate;
//            this.src = src;
//            this.dest = dest;
//        }
//
//        @JsonGetter
//        public String getText() {
//            return text;
//        }
//
//        @JsonSetter
//        public void setText(String text) {
//            this.text = text;
//        }
//
//        @JsonGetter
//        public String getTranslated() {
//            return translated;
//        }
//
//        @JsonGetter
//        public void setTranslated(String translated) {
//            this.translated = translated;
//        }
//
//        @JsonGetter
//        public LanguageCode getSrc() {
//            return src;
//        }
//
//        @JsonSetter
//        public void setSrc(LanguageCode src) {
//            this.src = src;
//        }
//
//        @JsonGetter
//        public LanguageCode getDest() {
//            return dest;
//        }
//
//        @JsonSetter
//        public void setDest(LanguageCode dest) {
//            this.dest = dest;
//        }
//    }
//}
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {

    public static void main(String[] args) throws IOException {
        String text = "Hello world!";
        //Translated text: Hallo Welt!
        System.out.println("Translated text: " + translate("en", "vi", text));
    }

    public static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbzdMpjj-S7ZHZ4FrVBPfNvHtWf3O_auDrD-f3vUkcFO1KV9all9QHzGodYdgRrBjj4dUQ/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}