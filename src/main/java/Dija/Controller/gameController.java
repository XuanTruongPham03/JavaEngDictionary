package Dija.Controller;

import Dija.Services.MySQLConnection.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class gameController implements Initializable {
    @FXML
    private Button topLeft;
    @FXML
    private Button botLeft;
    @FXML
    private Button topRight;
    @FXML
    private Button botRight;
    @FXML
    private TextArea question;

    private String answer;
    private String chooseAns;
    private List<Question> listQuestions = new ArrayList<Question>();


    MySqlConnectionBase connectionBase = new MySqlConnectionBase();
    String sql = "SELECT * FROM game ";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topLeft.setOnMouseClicked(e -> {
            chooseAns = "a";
            System.out.println("a");
        });
        botLeft.setOnMouseClicked(e -> {
            chooseAns = "c";
            System.out.println("c");
        });
        topRight.setOnMouseClicked(e -> {
            chooseAns = "b";
            System.out.println("b");
        });
        botRight.setOnMouseClicked(e -> {
            chooseAns = "d";
            System.out.println("d");
        });

        takeAllQues();
        setQuestion();
    }

    private void takeAllQues(){
        try {
            Connection conn = connectionBase.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                listQuestions.add(new Question(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    private void setQuestion() {
        Random random = new Random();
        int index = random.nextInt(100000) % listQuestions.size();
        question.setText(listQuestions.get(index).getQues());
        topLeft.setText(listQuestions.get(index).getAnsA());
        botLeft.setText(listQuestions.get(index).getAnsC());
        topRight.setText(listQuestions.get(index).getAnsB());
        botRight.setText(listQuestions.get(index).getAnsD());
        answer = listQuestions.get(index).getAnswer();
    }
}
