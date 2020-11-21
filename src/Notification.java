import java.awt.*;

public class Notification {
    Notification(){
        Frame f = new Frame();
        Button b = new Button("Click to start 5:00 min break!");
        b.setBounds(30,50,80,30);
        f.add(b);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);

    }
    public static void main(String args[]){
        Notification f = new Notification();
    }
}
