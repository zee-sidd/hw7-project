
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Notification {

    JFrame f;
    JLabel l1;

    JLabel background;


    Notification(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        f = new JFrame("Notification");
        f.setSize(350,350);




        int x = (int) ((dimension.getWidth() -f.getWidth())/2);
        int y = (int) ((dimension.getHeight() - f.getHeight())/2);
        f. setLocation(x,y);

        ImageIcon img = new ImageIcon("testing.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0,0,250,250);
        f.add(background);


        JButton b = new JButton("Click to start 5 minutes break!");
        b.setBorder(null);
        b.setBounds(60, 200,200,50);
        f.add(b);
        //Adding a button


        l1=new JLabel("Great Job on working for 30 minutes!!!");
        l1.setBounds(50,50, 300,30);
        f.add(l1);
        //Label

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }



    public static void main(String args[]){
        Notification f = new Notification();
    }
}
