import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

// Import necessary java and javafx packages.

public class MainController implements Initializable {
    @FXML
    TextField nameTextField;

    @FXML
    TextField taskNameTextField;

    @FXML
    TextField sleepHoursTextField;

    @FXML
    TextField eatHoursTextField;

    @FXML
    TextField specifiedTimeTextField;

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

    @FXML
    Button addTaskButton;

    @FXML
    Label message;

    // These data variables are used to populate the ComboBoxes for days, months, years, and importance level.
    final ObservableList<String> daysData = FXCollections.observableArrayList();
    final ObservableList<String> monthData = FXCollections.observableArrayList();
    final ObservableList<String> yearData = FXCollections.observableArrayList();
    final ObservableList<String> importanceData = FXCollections.observableArrayList();

    public static ArrayList<Task> tasks = new ArrayList<>();

    //Global Variables
    public String date;
    public static double userSpecifiedTime;
    public static double sleepingHours;
    public static double eatingHours;
    public static String userName;

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
    public void addTask() throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now); //Sets the Date to what it is on the time of running the program

        String taskName = taskNameTextField.getText().trim();
        String importance = importanceLevelsBox.getValue();
        String dueDate = yearBox.getValue() + "/" + monthBox.getValue() + "/" + dayBox.getValue();

        try {
            if (!taskName.isEmpty() && !importance.isEmpty() && !yearBox.getValue().isEmpty() && !monthBox.getValue().isEmpty() && !dayBox.getValue().isEmpty()) {

                // Get date info and convert them to integers.
                int dueDateInteger = Integer.parseInt(yearBox.getValue() + monthBox.getValue() +  dayBox.getValue());
                DateTimeFormatter dtfForTest = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDateTime currentDate = LocalDateTime.now();
                int currentDateInteger = Integer.parseInt(dtfForTest.format(currentDate));

                if (dueDateInteger >= currentDateInteger) {
                    tasks.add(new Task(taskName, importance, dueDate, date));

                    message.setText("Successfully added a task with name: " + taskName);

                    taskNameTextField.setText("");
                    importanceLevelsBox.setValue("");
                    yearBox.setValue("");
                    monthBox.setValue("");
                    dayBox.setValue("");
                }
                else {
                    message.setText("Error: Please choose a date starting today and on.");
                }
            } else {
                message.setText("Error: Please ensure that all text fields are entered before you add a task!");
            }
        }
        catch (Exception e) {
            message.setText("Error: Please ensure that all text fields are entered before you add a task!");
        }
    }


    @FXML
    public void submit() throws Exception {

        try {
            userName = nameTextField.getText().trim();
            userSpecifiedTime = Double.parseDouble(specifiedTimeTextField.getText());
            eatingHours = Double.parseDouble(eatHoursTextField.getText());
            sleepingHours = Double.parseDouble(sleepHoursTextField.getText());

            if (!userName.isEmpty()) {

                if ((userSpecifiedTime + eatingHours + sleepingHours) <= 24) {
                    double totalImportance = 0;

                    //Determining Allotted Time
                    for (Task task : tasks) {
                        totalImportance += task.howImportant();
                    }
                    for (Task task : tasks) { //Assigns Relative Importance based on other tasks and assigns time(minutes)
                        task.setRelativeImportance(task.howImportant() / totalImportance);
                        task.setTime(task.getRelativeImportance() * (24*60 - eatingHours*60 - sleepingHours*60 - userSpecifiedTime*60)); //How many minutes to allocate 840 is the available time (24h - sleep - eat - user specified)
                    }

                    if (!tasks.isEmpty()) {
                        Stage currentStage = (Stage) nameTextField.getScene().getWindow();
                        currentStage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("schedule.fxml"));
                        Parent schedule = fxmlLoader.load();
                        Scene scene = new Scene(schedule);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Schedule");
                        stage.show();
                    } else {
                        message.setText("Error: Please add at least one task before submitting!");
                    }
                }
                else {
                    message.setText("Please ensure that presonal information times do not add up to 24 hours.");
                }
            } else {
                message.setText("Please enter your name.");
            }
        }
        catch (Exception e) {
            message.setText("Error: Please ensure that your name and personal information is all filled out.");
        }

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