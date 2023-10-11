package Dija.Model;

import Dija.Model.Word;
import Dija.Services.MySQLConnection.MySqlConnectionBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class Dictionary {
    private ArrayList<Word> words;

    public Dictionary() {
        words = new ArrayList<Word>();
    }

    public void addWord(Word word) {
        words.add(word);
    }

    public void removeWord(Word word) {
        words.remove(word);
    }

    public ArrayList<Word> getAllWords() {
        return words;
    }

    public int size() {
        return words.size();
    }

    public boolean isEmpty() {
        return words.isEmpty();
    }

    public boolean isWordExistInDatabase(String wordTarget) {
    MySqlConnectionBase connectionBase = new MySqlConnectionBase();
    String sql = "SELECT COUNT(*) FROM dictionary WHERE word_target = ?";
    boolean isExist = false;

    if (connectionBase != null) {
        try {
            PreparedStatement preparedStatement = connectionBase.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, wordTarget);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            isExist = count > 0;

            preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        connectionBase.closeConnection();
        return isExist;
    }
}