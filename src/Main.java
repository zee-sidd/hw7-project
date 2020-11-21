import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Import necessary java and javafx packages.
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application implements Initializable {
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


    // Creates and loads the stage and scene for the GUI application
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("inputPage.fxml"));
        primaryStage.setTitle("Welcome to APP NAME!");
        primaryStage.setScene(new Scene(root, 650, 400));   // Creates and sets the size of the scene.
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launches the GUI application
        launch(args);
        System.out.println("Hello World");
    }

    @Override
    // initialize function creates anew Image instances for each flower image object.
    // The file paths are sent as arguments to load the images.
    public void initialize(URL url, ResourceBundle rb) { }


    public void createComboBoxData() {
        // Here we add data to the ObservableList which represents menu items in combo boxes.
        daysData.addAll(createNumberList(1, 31));
        monthData.addAll(createNumberList(1, 12));
        yearData.addAll(createNumberList(2020, 2030));
        importanceData.addAll("");
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
