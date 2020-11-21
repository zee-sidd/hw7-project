import java.awt.*;
import java.util.Date;

//Object to handle user inputted task
public class Task {

    private String taskName;
    private String importance;
    private Color colorObject;
    private String completionDate;
    private String date;
    private double time;

    //Constructor
    public Task (String taskName, String importance, String completionDate, String date){
        taskName = taskName;
        importance = importance;
        completionDate = completionDate;
        date = date;
    }

    //Getter and Setters
    public String getTaskName() {return this.taskName;}
    public double getTime() {return this.time;}

    //Helper Methods


}
