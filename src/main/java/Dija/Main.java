package Dija;

import Dija.Controller.DictionaryCommandline;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        Scanner scanner = new Scanner(System.in);

        dictionaryCommandline.run();

        scanner.close();
    }
}

