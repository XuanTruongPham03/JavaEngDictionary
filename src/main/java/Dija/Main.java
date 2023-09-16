package Dija;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandline commandline = new DictionaryCommandline();
        DictionaryManagement management = new DictionaryManagement();
        commandline.dictionaryBasic(management);
        commandline.runInteractiveSearch(management);
    }
}
