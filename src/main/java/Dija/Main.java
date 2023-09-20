package Dija;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();

        dictionaryCommandline.run();

        scanner.close();
    }
}
