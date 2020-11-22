import javax.swing.*;
import java.awt.*;

class Demo extends JFrame{

    Demo(){
        JLabel background;
        setSize(1200, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("testing.jpg");

        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0,0,1200,700);
        add(background);

        setVisible(true);
    }
}