import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Notification {

    JFrame f;
    JLabel text;

    Notification(){

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

  f = new JFrame("Notification");
  text = new JLabel("Good job working hard for 30 minutes!!");

  JButton b = new JButton("Click to start 5 minutes break!");
  f.add(b);
  f.add(text);
  f.setSize(400,400);
  f.setLayout(null);
  f.setVisible(true);

  int x = (int) ((dimension.getWidth() -f.getWidth())/2);
  int y = (int) ((dimension.getHeight() - f.getHeight())/2);
  f. setLocation(x,y);



  b.setBackground(Color.green);
  b.setBorder(null);

  b.setBounds(130,130,200,50);

    }
    public static void main(String args[]){
        Notification f = new Notification();
    }
}
