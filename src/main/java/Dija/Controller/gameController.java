package Dija.Controller;

import Dija.Services.MySQLConnection.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    @FXML
    private Label alert;
    @FXML
    private Label textScore;
    @FXML
    private AnchorPane endGame;
    @FXML
    private Button yes;
    @FXML
    private Button no;

    private String answer;
    private String chooseAns;
    private int score;
    private int count;
    private boolean isAnswered;
    private final int scoreEach = 10;
    private final int maxQues = 10;
    private AnimationTimer game;
    private List<Question> listQuestions = new ArrayList<Question>();

    private Random random = new Random();


    MySqlConnectionBase connectionBase = new MySqlConnectionBase();
    String sql = "SELECT * FROM game ";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
        game = new AnimationTimer() {
            @Override
            public void handle(long l) {
                run();
            }
        };

        topLeft.setOnMouseClicked(e -> {
            chooseAns = "a";
        });
        botLeft.setOnMouseClicked(e -> {
            chooseAns = "c";
        });
        topRight.setOnMouseClicked(e -> {
            chooseAns = "b";
        });
        botRight.setOnMouseClicked(e -> {
            chooseAns = "d";
        });

        yes.setOnMouseClicked(e -> {
            load();
            setQuestion();
            game.start();
        });
        no.setOnMouseClicked(e -> {
            yes.setVisible(false);
            no.setVisible(false);
        });

        takeAllQues();
        setQuestion();
        game.start();
    }

    private void load() {
        chooseAns = "";
        score = 0;
        isAnswered = false;
        count = 0;
        textScore.setText(String.valueOf(score));
        endGame.setVisible(false);
    }

    private void run() {
        if (isAnswered) {
            showAlert();
        }

        if (!chooseAns.isEmpty()) {
            if (checkAns()) {
                score += scoreEach;
                alert.setText("Correct!");
            } else {
                alert.setText("Incorrect!");
            }
            textScore.setText(String.valueOf(score));
            chooseAns = "";
            isAnswered = true;
            count ++;
        }

        if (count == maxQues) {
            game.stop();
            endGame.setVisible(true);
        }
    }

    private void showAlert() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alert.setText("");
        setQuestion();
        isAnswered = false;
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

    private boolean checkAns() {
        if (chooseAns.equals(answer)) {
            return true;
        }
        return false;
    }

    private void setQuestion() {
        int index = random.nextInt(100000) % listQuestions.size();
        question.setText(listQuestions.get(index).getQues());
        topLeft.setText("A: " + listQuestions.get(index).getAnsA());
        botLeft.setText("B: " + listQuestions.get(index).getAnsC());
        topRight.setText("C: " + listQuestions.get(index).getAnsB());
        botRight.setText("D: " + listQuestions.get(index).getAnsD());
        answer = listQuestions.get(index).getAnswer();
    }
}
