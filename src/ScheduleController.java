import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ScheduleController extends MainController implements Initializable {
    @FXML
    TableView scheduleTable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn<Map, String> timesColumn = new TableColumn<>("Amount of Time You Should Spend");
        timesColumn.setCellValueFactory(new MapValueFactory<>("Amount of Time You Should Spend"));

        TableColumn<Map, String> taskColumn = new TableColumn<>("Task");
        taskColumn.setCellValueFactory(new MapValueFactory<>("Task"));

        scheduleTable.getColumns().add(taskColumn);
        scheduleTable.getColumns().add(timesColumn);
        ObservableList<Map<String, Object>> rowEntries = FXCollections.<Map<String, Object>>observableArrayList();

        // Test
        for (Task task : tasks) {
            Map<String, Object> rowEntry = new HashMap<>();
            rowEntry.put("Amount of Time You Should Spend", task.getTime() + " minutes");
            rowEntry.put("Task", task.getTaskName());
            rowEntries.add(rowEntry);
        }
        scheduleTable.getItems().addAll(rowEntries);
    }
}
