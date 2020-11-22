
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notification implements ActionListener{

    JFrame f;
    JLabel l1;
    JButton no;

    JLabel background;
    JButton b;

    Notification(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        f = new JFrame("Notification");
        f.setSize(350,350);
        Container c = f.getContentPane();
        c.setBackground(Color.pink);

        int x = (int) ((dimension.getWidth() -f.getWidth())/2);
        int y = (int) ((dimension.getHeight() - f.getHeight())/2);
        f. setLocation(x,y);

        ImageIcon img = new ImageIcon("background.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(25,25,25,25);

        b = new JButton("Click to start 5 minutes break!");
        b.setBorder(null);
        b.setBounds(60, 190,200,50);
        f.add(b);
        //Adding a button

        no = new JButton("Click to continue studying!");
        no.setBorder(null);
        no.setBounds(60, 250,200,50);
        f.add(no);

        l1=new JLabel("Great Job on working for 30 minutes!!!");
        l1.setBounds(50,50, 300,30);
        f.add(l1);
        //Label

        b.addActionListener(this);
        no.addActionListener(this);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b){
            Short_break snack = new Short_break();
        }

        if (e.getSource() == no){
            Warning Rethink = new Warning();
        }
    }
}
