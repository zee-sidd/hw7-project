import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main extends Application {
    @FXML
    TextField nameTextField;

    @FXML
    TextField taskNameTextField;

    @FXML
    TextField completionDateTextField;

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

    // These data variables are used to populate the ComboBoxs for days, months, years, and importance level.
    final ObservableList<String> daysData = FXCollections.observableArrayList();
    final ObservableList<String> monthData = FXCollections.observableArrayList();
    final ObservableList<String> yearData = FXCollections.observableArrayList();
    final ObservableList<String> importanceData = FXCollections.observableArrayList();

    //Global Variables
    public static String date;

    public static void main(String[] args) {
        // Launches the GUI application
        launch(args);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now); //Sets the Date to what it is on the time of running the program

    }

    // Creates and loads the stage and scene for the GUI application
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("inputPage.fxml"));
//        createComboBoxData();
        primaryStage.setTitle("Welcome to APP NAME!");
        primaryStage.setScene(new Scene(root, 600, 479));   // Creates and sets the size of the scene.
        primaryStage.show();
    }

}
