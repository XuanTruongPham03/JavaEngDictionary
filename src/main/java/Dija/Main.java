package Dija;

import Dija.Controller.DictionaryCommandline;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        Scanner scanner = new Scanner(System.in);

        dictionaryCommandline.run();

        scanner.close();
    }
}
