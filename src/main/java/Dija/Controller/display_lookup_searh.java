package Dija.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class display_lookup_searh extends AnchorPane implements Initializable {

    private DictionaryManagement dictionaryManagement = new DictionaryManagement();
    @FXML
    private AnchorPane root;
    @FXML
    private TextField taskSearh;
    @FXML
    private ListView<String> homeListView;;
    @FXML
    private Button displayBtn;
    @FXML
    private Button searhBtn;
    @FXML
    private Button VoiceBtn;

    @FXML
    private ObservableList<String> searchResultsList = FXCollections.observableArrayList();


    public display_lookup_searh(){

    };
    @Override
    public void initialize(URL location, ResourceBundle resources){
        displayBtn.setOnAction(e ->  displayHandler());
        searhBtn.setOnAction(e ->  SearhHandler());
        VoiceBtn.setOnAction(e -> VoiceHandler());

        taskSearh.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                // Nếu nội dung mới không rỗng, thực hiện tìm kiếm và cập nhật kết quả tìm kiếm
                List<String> searchResults = dictionaryManagement.dictionarySearcher(newValue.trim());
                homeListView.getItems().clear();
                homeListView.getItems().addAll(searchResults);
            }
        });

        taskSearh.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                SearhHandler();
                event.consume();
            }
        });

        homeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    taskSearh.setText(newValue.split(" - ")[0]); // Lấy phần tiếng Anh của từ
                    displayHandler();
                }
            }
        });

        homeListView.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String selectedItem = homeListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    taskSearh.setText(selectedItem.split(" - ")[0]); // Lấy phần tiếng Anh của từ
                    displayHandler();
                }
                event.consume();
            }
        });





    }
    public void displayHandler() {
        List<String> wordList = dictionaryManagement.getWordsAsStringList();
        homeListView.getItems().clear();
        homeListView.getItems().addAll(wordList);
    }

    public void SearhHandler() {
        String searchText = taskSearh.getText().trim();
        if (!searchText.isEmpty()) {
            List<String> searchResults = dictionaryManagement.dictionarySearcher(searchText);
            homeListView.getItems().clear();
            homeListView.getItems().addAll(searchResults);
        }
    }

    public void VoiceHandler() {
        // Lấy từ hiện tại trong TextField
        String currentWord = taskSearh.getText().trim();
        if (!currentWord.isEmpty()) {
            // Gọi phương thức read từ class DictionaryManagement để phát âm từ
            dictionaryManagement.read(currentWord);
        }
    }











}
