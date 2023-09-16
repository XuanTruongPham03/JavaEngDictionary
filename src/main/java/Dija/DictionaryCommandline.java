package Dija;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    public void showAllWords(Dictionary dictionary) {
        ArrayList<Word> words = dictionary.getAllWords();
        System.out.println("No | English | Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            System.out.println((i + 1) + " | " + word.getWordTarget() + " | " + word.getWordExplain());
        }
    }

    public void dictionaryBasic(DictionaryManagement dictionaryManagement) {
        Dictionary dictionary = new Dictionary();
        dictionaryManagement.insertFromCommandline(dictionary);
        showAllWords(dictionary);
    }

    public void runInteractiveSearch(DictionaryManagement dictionaryManagement) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a prefix to search for words (or type 'exit' to quit): ");
        while (true) {
            String prefix = scanner.nextLine().trim();
            if (prefix.equalsIgnoreCase("exit")) {
                break;
            }

            ArrayList<Word> result = dictionaryManagement.dictionaryLookup(prefix);
            if (result.isEmpty()) {
                System.out.println("No words found.");
            } else {
                int pageSize = 10;
                int currentPage = 0;
                while (true) {
                    int startIndex = currentPage * pageSize;
                    int endIndex = Math.min(startIndex + pageSize, result.size());

                    System.out.println("Words found (Page " + (currentPage + 1) + "):");
                    for (int i = startIndex; i < endIndex; i++) {
                        Word word = result.get(i);
                        System.out.println((i + 1) + ". " + word.getWordTarget() + " - " + word.getWordExplain());
                    }

                    if (endIndex < result.size()) {
                        System.out.println("Type 'next' to see more, or 'exit' to quit:");
                        String choice = scanner.nextLine().trim();
                        if (choice.equalsIgnoreCase("next")) {
                            currentPage++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}
