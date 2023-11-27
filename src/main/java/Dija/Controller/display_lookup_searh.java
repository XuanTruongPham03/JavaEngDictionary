package Dija.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private Button lookupBtn;
    @FXML
    private Button searhBtn;

    public display_lookup_searh(){

    };
    @Override
    public void initialize(URL location, ResourceBundle resources){
//        homeListView.setItems(FXCollections.observableArrayList());
        displayBtn.setOnAction(e ->  displayHandler());

//        ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
//        homeListView.setItems(items);
    }
    public void displayHandler() {
        List<String> wordList = dictionaryManagement.getWordsAsStringList();
        homeListView.getItems().clear();
        homeListView.getItems().addAll(wordList);

    }




}
