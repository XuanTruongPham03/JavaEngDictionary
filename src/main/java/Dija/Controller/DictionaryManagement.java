package Dija.Controller;

import Dija.Model.Dictionary;
import Dija.Model.Word;
import Dija.Services.MySQLConnection.MySqlConnectionBase;

import com.mysql.jdbc.MySQLConnection;
import Dija.Services.MySQLConnection.ExportFile;
import Dija.Services.MySQLConnection.ImportFile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary;
    private Scanner scanner;
    private int displayPageSize = 50;
    private int searchPageSize = 10;

    public DictionaryManagement() {
        dictionary = new Dictionary();
        scanner = new Scanner(System.in);
    }

    /**
     * Add a word to dictionary database.
     */
    public void addWord() {
        System.out.println("Enter word target:");
        String wordTarget = scanner.nextLine();

        if (dictionary.isWordExistInDatabase(wordTarget)) {
            System.out.println("Word target already exist in database");
            return;
        }

        System.out.println("Enter word explain:");
        String wordExplain = scanner.nextLine();

        System.out.println("Enter word pronunciation:");
        String pronunciation = scanner.nextLine();

        System.out.println("Enter word type:");
        String wordType = scanner.nextLine();

        Word word = new Word(wordTarget, pronunciation, wordType, wordExplain);
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
    public void removeWord() {
        System.out.println("Enter word target:");
        String wordTarget = scanner.nextLine();

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
    public void updateWord() {
        System.out.println("Enter word target:");
        String wordTarget = scanner.nextLine();

        if (!dictionary.isWordExistInDatabase(wordTarget)) {
            System.out.println("Word target does not exist in database");
            return;
        }

        System.out.println("Enter word explain:");
        String wordExplain = scanner.nextLine();

        System.out.println("Enter word pronunciation:");
        String pronunciation = scanner.nextLine();

        System.out.println("Enter word type:");
        String wordType = scanner.nextLine();

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
    public void displayWords() {
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
    public void dictionarySearcher() {
        System.out.print("Enter a keyword to search: ");
        String keyword = scanner.nextLine();

        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "SELECT * FROM dictionary WHERE word_target LIKE ? LIMIT ?, ?";

        int pageNumber = 1;
        int pageSize = searchPageSize;
        int offset = 0;
        int resultNumber = 1;

        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");

            ResultSet resultSet;

            int resultCount = 0;

            do {
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, pageSize);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String wordTarget = resultSet.getString("word_target");
                    String pronunciation = resultSet.getString("pronunciation");
                    String wordType = resultSet.getString("word_type");
                    String wordExplain = resultSet.getString("word_explain");

                    // Hiển thị kết quả theo định dạng "1. word_target - pronunciation - word_type - word_explain"
                    System.out.printf("%d. %s - %s - %s - %s%n", resultNumber, wordTarget, pronunciation, wordType, wordExplain);
                    resultNumber++;

                    resultCount++;
                }

                if (resultCount == 0) {
                    System.out.println("No matching words found.");
                    break;
                }

                if (resultCount % searchPageSize == 0) {
                    System.out.println("Press Enter to continue or enter 'q' to quit:");
                    String input = scanner.nextLine();
                    if (input.equals("q")) {
                        break;
                    }
                    pageNumber++;
                    offset = (pageNumber - 1) * pageSize;
                } else {
                    break; // Không còn kết quả để hiển thị
                }
            } while (true);

            if (resultCount > 0) {
                System.out.printf("Found %d matching word(s).%n", resultCount);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionBase.closeConnection();
    }

    /**
     * Dictionary game
     */
    public void dictionaryGame() {
        MySqlConnectionBase connectionBase = new MySqlConnectionBase();
        String sql = "SELECT * FROM game ";

        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            int i = 1;
            int score = 0;

            resultSet.last();
            int count = resultSet.getRow();

            while(i < count + 1) {
                double randomDouble = Math.random();
                randomDouble = randomDouble * count + 1;
                int randomInt = (int) randomDouble;
                resultSet.absolute(randomInt);
                System.out.println("Question " + i + ": " + resultSet.getString(2) + "\n"
                        + "A. " + resultSet.getString(3) + "     "
                        + "B. " + resultSet.getString(4) + "     "
                        + "C. " + resultSet.getString(5) + "     "
                        + "D. " + resultSet.getString(6) + "     ");
                System.out.print("Enter your answer: ");
                String ans = scanner.nextLine();
                if (!ans.equals("a") && !ans.equals("b") && !ans.equals("c") && !ans.equals("d") ) {
                    System.out.println("Invalid Answer! \n\n");
                } else {
                    if (ans.equals(resultSet.getString(7))) {
                        System.out.print("Correct! \n\n");
                        score++;
                    } else {
                        System.out.print("Incorrect! \n\n");
                    }
                }
                i++;
            }
            System.out.println("Your score: " + score);
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connectionBase.closeConnection();
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




    /**
     * Translate word using Google Translate API.
     */
    public void translateAPI() {

    }
}
