package Dija;

public class Word {
    private String wordTarget;
    private String wordExplain;
    private String pronunciation;
    private String wordType;

    /**
     * Constructor
     * 
     * @param wordTarget
     * @param pronunciation
     * @param wordType
     * @param wordExplain
     */
    public Word(String wordTarget, String pronunciation, String wordType, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
        this.pronunciation = pronunciation;
        this.wordType = wordType;
    }

    /**
     * Constructor but without pronunciation and wordType
     * 
     * @param wordTarget
     * @param wordExplain
     */
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }

    /**
     * Default constructor
     */
    public Word() {
        this.wordTarget = "";
        this.wordExplain = "";
        this.pronunciation = "";
        this.wordType = "";
    }

    public String getWordTarget() {
        return wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public String getPronunciation() {
        return pronunciation;
    }   

    public String getWordType() {
        return wordType;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public void setProunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }
}

