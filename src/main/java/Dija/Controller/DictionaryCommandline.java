package Dija.Controller;

//import java.util.ArrayList;
//import java.util.Dictionary;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    /**
     * Menu options
     */
    private static final String[] MENU_OPTIONS = {
            "Exit",
            "Add",
            "Remove",
            "Update",
            "Display",
            "Lookup",
            "Search",
            "Game",
            "Import from file",
            "Export to file",
            "Translate Google"
    };

    private DictionaryManagement dictionaryManagement;
    private Scanner scanner;

    /**
     * Constructor
     */
    public DictionaryCommandline() {
        dictionaryManagement = new DictionaryManagement();
        scanner = new Scanner(System.in);
    }

    /**
     * Run the program
     */
    public void run() throws IOException {
        int option = 0;
        do {
            displayMenu();
            option = getOption();
            handleOption(option);
        } while (option != 0);
    }

    /**
     * Display menu
     */
    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < MENU_OPTIONS.length; i++) {
            System.out.println(i + ". " + MENU_OPTIONS[i]);
        }
    }

    /**
     * Get option from user
     * 
     * @return option
     */
    public int getOption() {
        int option = -1;
        boolean validInput = false;

        do {
            System.out.print("Enter option: ");
            String input = scanner.next();

            try {
                option = Integer.parseInt(input);
                if (option >= 0 && option < MENU_OPTIONS.length) {
                    validInput = true;
                } else {
                    System.out.println("Action not supported");
                }
            } catch (NumberFormatException e) {
                System.out.println("Action not supported");
            }
        } while (!validInput);

        return option;
    }

    /**
     * Handle option
     * 
     * @param option
     */
    public void handleOption(int option) throws IOException {
        switch (option) {
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
            case 1:
                dictionaryManagement.addWord();
                break;
            case 2:
                dictionaryManagement.removeWord();
                break;
            case 3:
                dictionaryManagement.updateWord();
                break;
            case 4:
                dictionaryManagement.displayWords();
                break;
            case 5:
                dictionaryManagement.dictionaryLookup();
                break;
            case 6:
                dictionaryManagement.dictionarySearcher();
                break;
            case 7:
                dictionaryManagement.dictionaryGame();
                break;
            case 8:
                dictionaryManagement.importFromFile();
                break;
            case 9:
                dictionaryManagement.exportToFile();
                break;
            case 10:
                dictionaryManagement.translateAPI();
                break;
            default:
                System.out.println("Action not supported");
                break;
        }
    }
}