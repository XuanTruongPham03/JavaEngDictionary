package Dija.Services.TranslateAPI;

import Dija.Services.TranslateAPI.BaseSynthesiser.java.SynthesiserV2;
import java.io.InputStream;

public class GoogleAPI {

    //Create a Synthesizer instance
    private SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
    private String lang = "en-US";
    public InputStream is = null;

    public GoogleAPI() {
        synthesizer.setLanguage(lang);
    }

    public GoogleAPI(String language) {
        lang = language;
        synthesizer.setLanguage(lang);
    }

    public InputStream getIs() {
        return is;
    }

}