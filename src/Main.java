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
import java.util.ArrayList;


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
    public static float userSpecifiedTime;

    //Global Constant Variables
    public final int sleepingHours = 8;
    public final int eatingHours = 2;

    public static void main(String[] args) {
        // Launches the GUI application
        launch(args);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now); //Sets the Date to what it is on the time of running the program
        //TEST ------------------------------------------------------------------

        //Creating a tasks
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Test Task 1", "Very Important", "2020/11/22", date));
        tasks.add(new Task("Test Task 2", "Not Very Important", "2020/11/29", date));
        tasks.add(new Task("Test Task 3", "Somewhat Important", "2020/11/21", date));

        //Finding Total amount of importance
        double totalImportance = 0;
        for (Task task : tasks) {
            totalImportance += task.howImportant();
            System.out.println(task.howImportant());
        }
        System.out.println(totalImportance);
        //Setting relative importance for each task
        for (Task task : tasks) {
            task.setRelativeImportance(task.howImportant()/totalImportance);
            System.out.println (task.getRelativeImportance());
        }
        //TEST ------------------------------------------------------------------
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
