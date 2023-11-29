package Dija.Controller;

import Dija.Model.Dictionary;
import Dija.Model.Word;
import Dija.Services.Game.Game1;
import Dija.Services.MySQLConnection.MySqlConnectionBase;

import Dija.Services.MySQLConnection.ExportFile;
import Dija.Services.MySQLConnection.ImportFile;
import Dija.Services.Game.Game1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dija.Services.TranslateAPI.*;

import javafx.scene.control.ChoiceBox;
import javafx.scene.media.AudioClip;
public class DictionaryManagement {
    private Dictionary dictionary;
    private Scanner scanner;
    private int displayPageSize = 10;
    private int searchPageSize = 10;
    public String wordTarget;

    public DictionaryManagement() {
        dictionary = new Dictionary();
        scanner = new Scanner(System.in);
    }

    /**
     * Add a word to dictionary database.
     */
    public void addWord(String wordTarget,String wordExplain, String pronunciation, String wordType) {
//        System.out.println("Enter word target:");
//        String wordTarget = scanner.nextLine();
//
        if (dictionary.isWordExistInDatabase(wordTarget)) {
            System.out.println("Word target already exist in database");
            return;
        }
//
//        System.out.println("Enter word explain:");
//        String wordExplain = scanner.nextLine();
//
//        System.out.println("Enter word pronunciation:");
//        String pronunciation = scanner.nextLine();
//
//        System.out.println("Enter word type:");
//        String wordType = scanner.nextLine();

        Word word = new Word(wordTarget,wordExplain, pronunciation,wordType);
        dictionary.addWord(word);

        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "INSERT INTO dictionary(word_target, word_explain, pronunciation, word_type) VALUES (?, ?, ?, ?)";

        if (connectionBase != null) {
            try {
                PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, wordTarget);
                preparedStatement.setString(2, wordExplain);
                preparedStatement.setString(3, pronunciation);
                preparedStatement.setString(4, wordType);

                preparedStatement.executeUpdate();
                preparedStatement.close();

                System.out.println(wordTarget + " was successfully added!\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Remove a word from dictionary database
     */
    public void removeWord(String wordTarget) {
        //System.out.println("Enter word target:");
        //String wordTarget = scanner.nextLine();

        if (!dictionary.isWordExistInDatabase(wordTarget)) {
            System.out.println("Word target does not exist in database");
            return;
        }

        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "DELETE FROM dictionary WHERE word_target = ?";

        if (connectionBase != null) {
            try {
                PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, wordTarget);

                preparedStatement.executeUpdate();
                preparedStatement.close();

                System.out.println(wordTarget + " was removed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        dictionary.removeWord(new Word(wordTarget, ""));
    }

    /**
     * Update a word in dictionary database
     */
    public void updateWord(String wordTarget,String wordExplain, String pronunciation, String wordType) {
//        System.out.println("Enter word target:");
//        String wordTarget = scanner.nextLine();

        if (!dictionary.isWordExistInDatabase(wordTarget)) {
            System.out.println("Word target does not exist in database");
            return;
        }

//        System.out.println("Enter word explain:");
//        String wordExplain = scanner.nextLine();
//
//        System.out.println("Enter word pronunciation:");
//        String pronunciation = scanner.nextLine();
//
//        System.out.println("Enter word type:");
//        String wordType = scanner.nextLine();

        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "UPDATE dictionary SET word_explain = ?, pronunciation = ?, word_type = ? WHERE word_target = ?";

        if (connectionBase != null) {
            try {
                PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, wordExplain);
                preparedStatement.setString(2, pronunciation);
                preparedStatement.setString(3, wordType);
                preparedStatement.setString(4, wordTarget);

                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        dictionary.removeWord(new Word(wordTarget, ""));
        dictionary.addWord(new Word(wordTarget, pronunciation, wordType, wordExplain));
        System.out.println(wordTarget + " was updated:");
        System.out.printf("%s - %s - %s - %s%n", wordTarget, pronunciation, wordType, wordExplain);
    }

    /**
     * Display all words from the database with pagination
     */
    public  void displayWords() {
        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "SELECT * FROM dictionary";

        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            int wordCount = 0;

            while (resultSet.next()) {
                if (wordCount % displayPageSize == 0) {
                    System.out.println("Press Enter to continue or enter 'q' to quit:");
                    String input = scanner.nextLine();
                    if (input.equals("q")) {
                        break;
                    }
                }

                String wordTarget = resultSet.getString("word_target");
                String pronunciation = resultSet.getString("pronunciation");
                String wordType = resultSet.getString("word_type");
                String wordExplain = resultSet.getString("word_explain");

                // Hiển thị từ theo định dạng "word_target - pronunciation - word_type - word_explain"
                System.out.printf("%d. %s - %s - %s - %s%n", wordCount + 1, wordTarget, pronunciation, wordType, wordExplain);

                wordCount++;
            }

            if (wordCount == 0) {
                System.out.println("The dictionary is empty.");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionBase.closeConnection();
    }

    public List<String> getWordsAsStringList() {
        List<String> wordList = new ArrayList<>();
        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "SELECT * FROM dictionary";

        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String wordTarget = resultSet.getString("word_target");
                String pronunciation = resultSet.getString("pronunciation");
                String wordType = resultSet.getString("word_type");
                String wordExplain = resultSet.getString("word_explain");

                // Định dạng từ theo yêu cầu và thêm vào danh sách
                String formattedWord = String.format("%s - %s - %s - %s", wordTarget, pronunciation, wordType, wordExplain);
                wordList.add(formattedWord);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionBase.closeConnection();

        return wordList;
    }


    /**
     * Lookup a word in dictionary database
     */
    public void dictionaryLookup() {
        System.out.print("Enter a word to look up: ");
        String lookupWord = scanner.nextLine();

        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "SELECT * FROM dictionary WHERE word_target = ?";

        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, lookupWord);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String wordTarget = resultSet.getString("word_target");
                String pronunciation = resultSet.getString("pronunciation");
                String wordType = resultSet.getString("word_type");
                String wordExplain = resultSet.getString("word_explain");

                System.out.println("Word found:");
                System.out.printf("English: %s%n", wordTarget);
                System.out.printf("Pronunciation: %s%n", pronunciation);
                System.out.printf("Type: %s%n", wordType);
                System.out.printf("Vietnamese: %s%n", wordExplain);
            } else {
                System.out.println("Word not found in the dictionary.");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionBase.closeConnection();
    }

    /**
     * Search words in dictionary database
     */
    public List<String> dictionarySearcher(String keyword) {
        List<String> searchResults = new ArrayList<>();
        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "SELECT word_target, word_explain FROM dictionary WHERE word_target LIKE ?";

        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String wordTarget = resultSet.getString("word_target");
                String wordExplain = resultSet.getString("word_explain");
                searchResults.add(wordTarget + " - " + wordExplain); // định dạng kết quả
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionBase.closeConnection();
        }
        return searchResults;
    }

    /**
     * Dictionary game
     */
    public void dictionaryGame() {
        Game1 game = new Game1();
        game.Game();
    }

    /**
     * Import dictionary from file
     */
    public void importFromFile() {
        ImportFile importFile = new ImportFile();
        importFile.importFile();
    }   

    /**
     * Export dictionary to file
     */
    public void exportToFile() {
        System.out.print("Enter folder path: ");
        String folderPath = scanner.nextLine();

        System.out.print("Enter file name (without extension): ");
        String fileName = scanner.nextLine();

        String fileExt = "txt";

        String filePath = folderPath + "\\" + fileName + "." + fileExt;

        ExportFile exportFile = new ExportFile();
        exportFile.exportFile(filePath,"dictionary",fileExt);
    }

    private Speaker speaker;
    private Speaker.SpeakerData speakerData;

    /**
     * Translate word using Google Translate API.
     */
    public void translateAPI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the destination language (default: Vietnamese): ");
        String destLang = scanner.nextLine();

        System.out.print("Enter the source language (default: English): ");
        String srcLang = scanner.nextLine();

        destLang = destLang.isEmpty() ? "vi" : destLang;
        srcLang = srcLang.isEmpty() ? "en" : srcLang;

        System.out.print("Enter the word to translate: ");
        String word = scanner.nextLine();

        if (word.isEmpty()) {
            System.out.println("Please enter a word to translate.");
            return;
        }

        GGTranAPI ggTranAPI = new GGTranAPI();
        Translator.TranslatedData result = ggTranAPI.translate(
                            Translator.LanguageCode.valueOf(srcLang.toUpperCase()),
                            Translator.LanguageCode.valueOf(destLang.toUpperCase()),
                            word);

        System.out.println("Text: " + result.getText());
        System.out.println("Translation: " + result.getTranslated());
        System.out.println("Source Language: " + result.getSrc());
        System.out.println("Destination Language: " + result.getDest());

        System.out.println("Press 's' to swap, 'l' to listen");
        char choice = scanner.nextLine().charAt(0);

        switch (choice) {
            case 's':
                String temp = srcLang;
                srcLang = destLang;
                destLang = temp;
                result = ggTranAPI.translate(
                        Translator.LanguageCode.valueOf(srcLang.toUpperCase()),
                        Translator.LanguageCode.valueOf(destLang.toUpperCase()),
                        word);

                System.out.println("Text: " + result.getText());
                System.out.println("Translation: " + result.getTranslated());
                System.out.println("Source Language: " + result.getSrc());
                System.out.println("Destination Language: " + result.getDest());
                break;
            case 'l':
                read(word);
        }
    }
    public void read(String word){
        String data = new LabanSpeakerAPI().speak(word).getData();
        PlaySound playSound = new PlaySound(data);
        playSound.start();
    }


    private class PlaySound extends Thread {
        String url;

        public PlaySound(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            try {
                AudioClip audioClip = new AudioClip(url);
                audioClip.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
