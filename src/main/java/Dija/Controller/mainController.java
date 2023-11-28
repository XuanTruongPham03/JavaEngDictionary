package Dija.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    private Button closeBtn, add_update_delateWord,display_lookup_searh, gameBtn;
    @FXML
    private AnchorPane container;
    @FXML
    private Tooltip tooltip1, tooltip2, tooltip3, tooltip4, tooltip5, tooltip6, tooltip7, tooltip8, tooltip9, tooltip10;

    private void setNode(Node node) {
        container.getChildren().clear();
        container.getChildren().add(node);
    }

    private void showComponent(String path) throws IOException {
        AnchorPane component = FXMLLoader.load(getClass().getResource(path));
        setNode(component);
    }

    @Override
    public void initialize( URL url, ResourceBundle resourceBundle) {
        tooltip1.setShowDelay(Duration.seconds(0.3));
        tooltip2.setShowDelay(Duration.seconds(0.3));
        tooltip3.setShowDelay(Duration.seconds(0.3));
        tooltip4.setShowDelay(Duration.seconds(0.3));
        tooltip5.setShowDelay(Duration.seconds(0.3));
        tooltip6.setShowDelay(Duration.seconds(0.3));
        tooltip7.setShowDelay(Duration.seconds(0.3));
        tooltip8.setShowDelay(Duration.seconds(0.3));
        tooltip9.setShowDelay(Duration.seconds(0.3));
        tooltip10.setShowDelay(Duration.seconds(0.3));
        try {
            showComponent("/view/dictionary.fxml");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        ;
        closeBtn.setOnMouseClicked(e -> {
            System.exit(0);
        });
//        searchBtn.setOnMouseClicked(e -> {
//            try {
//                showComponent("/view/dictionary.fxml");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
        add_update_delateWord.setOnMouseClicked(e -> {
            try {
                showComponent("/FXML/add_update_delateWord.fxml");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        display_lookup_searh.setOnMouseClicked(e -> {
            try {
                showComponent("/FXML/display_lookup_searh.fxml");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        gameBtn.setOnMouseClicked(e -> {
            try {
                showComponent("/view/game.fxml");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void add_update_delateWord(MouseEvent mouseEvent) {

    }

    public void display_lookup_searh(MouseEvent mouseEvent){

    }


}
