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
  f.setSize(350,350);
  f.setLayout(null);
  f.setVisible(true);

  int x = (int) ((dimension.getWidth() -f.getWidth())/2);
  int y = (int) ((dimension.getHeight() - f.getHeight())/2);
  f. setLocation(x,y);



  b.setBackground(Color.green);
  b.setBorder(null);

  b.setBounds(100, 100,200,50);

  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String args[]){
        Notification f = new Notification();
    }
}
