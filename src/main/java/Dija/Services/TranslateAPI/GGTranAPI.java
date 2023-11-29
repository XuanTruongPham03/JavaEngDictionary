//package Dija.Services.TranslateAPI;
//
//import com.google.cloud.translate.Translate;
//import com.google.cloud.translate.TranslateOptions;
//import com.google.cloud.translate.Translation;
//
//public class GGTranAPI implements Translator {
//    private final Translate translate;
//
//    public GGTranAPI() {
//        translate = TranslateOptions.newBuilder().setApiKey(Config.GOOGLE_API).build().getService();
//    }
//
//    @Override
//    public TranslatedData translate(LanguageCode src, LanguageCode dest, String text) {
//        Translation translation = translate.translate(text,
//                Translate.TranslateOption.sourceLanguage(src.toString()),
//                Translate.TranslateOption.targetLanguage(dest.toString()));
//        return new TranslatedData(text, translation.getTranslatedText(),
//                src, dest);
//    }
//}
