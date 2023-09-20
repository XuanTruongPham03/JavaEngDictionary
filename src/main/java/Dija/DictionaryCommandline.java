package Dija;

import java.util.ArrayList;
import java.util.Dictionary;
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
        "Export to file"
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
    public void run() {
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
        do {
            System.out.print("Enter option: ");
            option = scanner.nextInt();
        } while (option < 0 || option >= MENU_OPTIONS.length);

        return option;
    }

    /**
     * Handle option
     * 
     * @param option
     */
    public void handleOption(int option) {
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
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

}