import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
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
        //TEST ------------------------------------------------------------------
    }

    // Creates and loads the stage and scene for the GUI application
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("inputPage.fxml"));
//        createComboBoxData();
        primaryStage.setTitle("Welcome to APP NAME!");
        primaryStage.setScene(new Scene(root, 600, 450));   // Creates and sets the size of the scene.
        primaryStage.show();
    }
}
