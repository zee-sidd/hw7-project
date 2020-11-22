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
        TableColumn<Map, String> timesColumn = new TableColumn<>("Time");
        timesColumn.setCellValueFactory(new MapValueFactory<>("Time"));

        TableColumn<Map, String> taskColumn = new TableColumn<>("Task");
        timesColumn.setCellValueFactory(new MapValueFactory<>("Task"));

        scheduleTable.getColumns().addAll(timesColumn, taskColumn);
        ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();

        // Test
        for (Task task : tasks) {
            Map<String, Object> item1 = new HashMap<>();
            item1.put("Time", task.getTime() + " minutes");
            item1.put("Task", task.getTaskName());
            items.add(item1);
        }
        System.out.println(tasks.size());
    }
}