import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

// Import necessary java and javafx packages.
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainController implements Initializable {
    @FXML
    TextField nameTextField;

    @FXML
    TextField taskNameTextField;

    @FXML
    ComboBox<String> importanceLevelsBox;

    // Combo box with days for date of birth (from 1 to 31)
    @FXML
    ComboBox<String> dayBox;

    // Combo box with months (numbers; 1 to 12) for date of birth
    @FXML
    ComboBox<String> monthBox;

    // Combo box with years (numbers; 1 to 12) for date of birth
    @FXML
    ComboBox<String> yearBox;

    @FXML
    Button submitButton;

    // These data variables are used to populate the ComboBoxes for days, months, years, and importance level.
    final ObservableList<String> daysData = FXCollections.observableArrayList();
    final ObservableList<String> monthData = FXCollections.observableArrayList();
    final ObservableList<String> yearData = FXCollections.observableArrayList();
    final ObservableList<String> importanceData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createComboBoxData();
        // Set menu items in each box. Use data from Observable list.
        dayBox.setItems(daysData);
        monthBox.setItems(monthData);
        yearBox.setItems(yearData);
        importanceLevelsBox.setItems(importanceData);
    }

    @FXML
    public void schedule() throws Exception {
        Stage currentStage = (Stage) nameTextField.getScene().getWindow();
        currentStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("schedule.fxml"));
        Parent schedule = fxmlLoader.load();
        Scene scene = new Scene(schedule);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Schedule");
        stage.show();
    }


    public void createComboBoxData() {
        // Here we add data to the ObservableList which represents menu items in combo boxes.
        daysData.addAll(createNumberList(1, 31));
        monthData.addAll(createNumberList(1, 12));
        yearData.addAll(createNumberList(2020, 2022));
        importanceData.addAll("Not Very Important", "Somewhat Important", "Important", "Very Important", "Screwed");
    }

    //This function creates a list with number randing from parameters start to end.
    public ObservableList<String> createNumberList(int start, int end) {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (int i = start; i <= end; i++) {
            list.add(Integer.toString(i));
        }
        return list;
    }

}

