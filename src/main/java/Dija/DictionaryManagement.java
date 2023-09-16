package Dija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline(Dictionary dictionary) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of words: ");
        int numWords = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numWords; i++) {
            System.out.println("Word " + (i + 1) + " th:");
            System.out.print("English: ");
            String target = scanner.nextLine();
            System.out.print("Pronunciation: ");
            String pronunciation = scanner.nextLine();
            System.out.print("Word type: ");
            String type = scanner.nextLine();
            System.out.print("Vietnamese: ");
            String explain = scanner.nextLine();

            Word word = new Word(target, pronunciation, type, explain);
            dictionary.addWord(word);
        }
    }

    private Connection connection;

    public DictionaryManagement() {
        // Database Connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/javaengdictionary", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Word> dictionaryLookup(String prefix) {
        ArrayList<Word> result = new ArrayList<>();

        if (connection != null) {
            try {
                // Truy vấn SQL
                String sql = "SELECT * FROM dictionary WHERE word_target LIKE ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, prefix + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                // Xử lý kết quả truy vấn
                while (resultSet.next()) {
                    String wordTarget = resultSet.getString("word_target");
                    String pronunciation = resultSet.getString("pronunciation");
                    String wordType = resultSet.getString("word_type");
                    String wordExplain = resultSet.getString("word_explain");

                    Word word = new Word(wordTarget, pronunciation, wordType, wordExplain);
                    result.add(word);
                }

                // Đóng các tài nguyên
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
