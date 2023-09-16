package Dija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> wordArrayList = new ArrayList<Word>();
    private Connection connection;

    public Dictionary() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/javaengdictionary", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addWord(Word word) {
        wordArrayList.add(word);
    }

    public ArrayList<Word> getAllWords() {
        return wordArrayList;
    }
}
