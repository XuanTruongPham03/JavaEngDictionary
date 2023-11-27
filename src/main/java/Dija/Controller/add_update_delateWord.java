    package Dija.Controller;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.Button;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.AnchorPane;
    import javafx.scene.layout.VBox;

    import java.net.URL;
    import java.util.ResourceBundle;

    public class add_update_delateWord extends AnchorPane implements Initializable {

        private DictionaryManagement dictionaryManagement = new DictionaryManagement();
        @FXML
        private AnchorPane root;

        @FXML
        private TextField wordTargetField;

        @FXML
        private TextField wordExplainField;

        @FXML
        private ComboBox<String> wordTypeField;

        @FXML
        private TextField pronunciationField;

        @FXML
        private Button clearBtn;

        @FXML
        private Button addBtn;
        @FXML
        private Button delateBtn;
        @FXML
        private Button updateBtn;

        public add_update_delateWord() {
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            ObservableList<String> wordTypeOptions = FXCollections.observableArrayList("Danh từ", "Động từ", "Tính từ");
            wordTypeField.setItems(wordTypeOptions);

            clearBtn.setOnAction(e -> clearFields());
            addBtn.setOnAction(e -> addWordHandler());
            delateBtn.setOnAction(e -> delateWordHandler());
            updateBtn.setOnAction(e -> updateWordHandler());

            wordTypeField.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->  {
                    if (newValue != null) {
                        System.out.println("Loại từ được chọn: " + newValue);
                    }
            });
        }

        private void clearFields() {
            wordTargetField.clear();
            wordExplainField.clear();
            wordTypeField.getSelectionModel().clearSelection();
            pronunciationField.clear();
            System.out.println("Clearing fields");
        }
        private void addWordHandler() {
            String wordTarget = wordTargetField.getText();
            String wordExplain = wordExplainField.getText();
            String wordType = wordTypeField.getValue();
            String pronunciation = pronunciationField.getText();
            System.out.println(wordTarget + " " +  wordExplain + " " + pronunciation +" "+ wordType);
            if (wordTarget.isEmpty() || wordExplain.isEmpty() || wordType == null) {
                System.out.println("Vui lòng điền đầy đủ thông tin từ, nghĩa và kiểu từ.");
            } else {
                dictionaryManagement.addWord(wordTarget, wordExplain, pronunciation, wordType);
                System.out.println("Thêm từ thành công  vào cơ sở dữ liệu.");
                clearFields();
            }
        }

       public void Clear(ActionEvent actionEvent) {
            wordTargetField.setText("");
            wordExplainField.setText("");
            pronunciationField.setText("");
        }

        public void delateWordHandler() {
            String wordTarget = wordTargetField.getText();
            if (wordTarget.isEmpty()) {
                System.out.println("Không tìm thấy từ cần xóa.");
            } else {
                dictionaryManagement.removeWord(wordTarget);
                System.out.println("Xóa từ thành công");
                clearFields();
            }

        }

        public void updateWordHandler() {
            String wordTarget = wordTargetField.getText();
            String wordExplain = wordExplainField.getText();
            String wordType = wordTypeField.getValue();
            String pronunciation = pronunciationField.getText();
            System.out.println(wordTarget + " " +  wordExplain + " " + pronunciation +" "+ wordType);
            if (wordTarget.isEmpty() || wordExplain.isEmpty() || wordType == null) {
                System.out.println("Vui lòng điền đầy đủ thông tin từ, nghĩa và kiểu từ.");
            } else {
                dictionaryManagement.updateWord(wordTarget, wordExplain, pronunciation, wordType);
                System.out.println("Sửa từ thành công  vào cơ sở dữ liệu.");
                clearFields();
            }
        }




    }
