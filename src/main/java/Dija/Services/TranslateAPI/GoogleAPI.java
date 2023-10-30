//package Dija.Services.TranslateAPI;
//
//
//import com.darkprograms.speech.synthesiser.SynthesiserV2;
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//public class GoogleAPI {
//
//    //Create a Synthesizer instance
//    private SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
//    private String lang = "en-US";
//    public InputStream is = null;
//
//    public GoogleAPI() {
//        synthesizer.setLanguage(lang);
//    }
//
//    public GoogleAPI(String language) {
//        lang = language;
//        synthesizer.setLanguage(lang);
//    }
//
//    public InputStream getIs() {
//        return is;
//    }
//
//}