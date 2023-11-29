package Dija.Controller;
import Dija.Services.TranslateAPI.Translator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class Google_Translate extends AnchorPane implements Initializable{

    @FXML
    private ComboBox<String> wordTarget1;
    @FXML
    private ComboBox<String> wordTarget2;

    @FXML
    private Button translateBtn;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    public Google_Translate() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> wordTypeOptions = FXCollections.observableArrayList("Vietnamese", "English");
        wordTarget1.setItems(wordTypeOptions);
        wordTarget2.setItems(wordTypeOptions);
        translateBtn.setOnAction(e -> {
            try {
                translateHandler();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    public void translateHandler() throws IOException {
        String langFrom ;
        String langTo ;
        if(wordTarget1.getValue().equals("Vietnamese")) {
            langFrom = "vi";
        }
        else {
            langFrom = "en";
        }
        if(wordTarget2.getValue().equals("Vietnamese")) {
            langTo = "vi";
        }
        else {
            langTo = "en";
        }
        String textToTranslate = textArea1.getText();

        Translator translate1 = new Translator();
        Translator translator = new Translator();
        String translatedText = translator.translate(langFrom, langTo, textToTranslate);

        textArea2.setText(translatedText);

    }
}
