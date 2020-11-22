import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Warning implements ActionListener{

    JFrame Rethink;
    JLabel xx;
    JButton nah;
    JButton yay;



    Warning(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        Rethink = new JFrame();
        Rethink.setSize(400, 400);
        Rethink.setLayout(null);
        Container c = Rethink.getContentPane();
        c.setBackground(Color.GRAY);

        int x = (int) ((dimension.getWidth() -Rethink.getWidth())/2);
        int y = (int) ((dimension.getHeight() - Rethink.getHeight())/2);
        Rethink. setLocation(x,y);

        Rethink.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Rethink.setVisible(true);

        nah = new JButton("No");
        nah.setBorder(null);
        nah.setBounds(90, 240,200,50);
        Rethink.add(nah);

        yay = new JButton("Yes");
        yay.setBorder(null);
        yay.setBounds(90, 190,200,50);
        Rethink.add(yay);


        xx=new JLabel("According to recent studies, it is recommended to take short breaks every 30 minutes! Are you sure you don't want to take a break?");
        xx.setBounds(10,0, 350,100);
        xx.setFont(new Font("Serif", Font.BOLD, 15));
        xx.setForeground(Color.GREEN);
        Rethink.add(xx);

    }
    public static void main(String args[]){
        Warning Rethink = new Warning();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nah){
            Notification f = new Notification();
        }

        if (e.getSource() == yay){
            Short_break snack = new Short_break();
        }
    }

}