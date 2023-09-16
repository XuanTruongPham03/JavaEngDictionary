package Dija;

public class Word {
    private String wordTarget; // English Vocabulary
    private String wordExplain; //Explain the Vietnamese Meaning
    private String prounciation;
    private String wordType;

    public Word(String wordTarget, String prounciation, String wordType, String wordExplain) {
        this.wordTarget = wordTarget;
        this.prounciation = prounciation;
        this.wordType = wordType;
        this.wordExplain = wordExplain;
    }

    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        prounciation = "";
        wordType = "";
        this.wordExplain = wordExplain;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public void setProunciation(String prounciation) {
        this.prounciation = prounciation;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }
    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public String getProunciation() {
        return prounciation;
    }

    public String getWordType() {
        return wordType;
    }
}


