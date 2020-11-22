import java.awt.*;

//Object to handle user inputted task
public class Task {

    private String taskName;
    private String importance;
    private Color colorObject;
    private String dueDate;
    private String date; //Current Date
    private double time; //Amount of time to spend on the task
    private double relativeImportance; //A number based on the product of importance and due date

    //Constructor
    public Task (String taskName, String importance, String dueDate, String date){
        this.taskName = taskName;
        this.importance = importance;
        this.dueDate = dueDate;
        this.date = date;
    }

    //Getter and Setters
    public String getTaskName() {return this.taskName;}
    public double getTime() {return this.time;}
    public double getRelativeImportance() {return this.relativeImportance;}

    public void setColorObject (Color color) {this.colorObject = color;}
    public void setTime (double value) {this.time = value;}
    public void setRelativeImportance (double val) {this.relativeImportance = val;}

    //Evaluating Numerical Importance
    public double howImportant () {

        int amountOfDaysDue = Integer.parseInt(dueDate.replace("/","")) - Integer.parseInt(date.replace("/","")); //How many days it is due in
        double importanceDate; //Multiplier for relative importance based on due date
        double importanceUser; //Multiplier for relative importance based on how worried the user feels about the task

        //Determining importance based on due date
        if (amountOfDaysDue < 2) {importanceDate = 5;}
        else if (amountOfDaysDue == 3) {importanceDate = 3;}
        else if (amountOfDaysDue == 4) {importanceDate = 2;}
        else if (amountOfDaysDue == 5) {importanceDate = 1;}
        else if (amountOfDaysDue == 6) {importanceDate = 0.5;}
        else {importanceDate = 0.1;}

        //Determining importance based on user input
        switch (this.importance) {

            case "Not Very Important":
                importanceUser = 0.5;
                break;
            case "Somewhat Important":
                importanceUser = 1;
                break;
            case "Important":
                importanceUser = 2;
                break;
            case "Very Important":
                importanceUser = 3;
                break;
            default:
                importanceUser = 5;
        }

        //Calculating importance
        return importanceUser * importanceDate;
    }
}
