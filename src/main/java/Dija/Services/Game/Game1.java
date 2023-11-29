package Dija.Services.Game;

import Dija.Services.MySQLConnection.MySqlConnectionBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Game1 {
    MySqlConnectionBase connectionBase = new MySqlConnectionBase();
    String sql = "SELECT * FROM game";
    public Game1(){

    }
    public void Game() {
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
                Scanner scanner = new Scanner(System.in);
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
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
