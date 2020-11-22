import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Relax implements ActionListener{

    JFrame Chill;
    JLabel Chilling;
    JButton silk;


    Relax(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        Chill = new JFrame();
        Chill.setSize(700, 700);
        Chill.setLayout(null);

        int x = (int) ((dimension.getWidth() -Chill.getWidth())/2);
        int y = (int) ((dimension.getHeight() - Chill.getHeight())/2);
        Chill. setLocation(x,y);

        Chill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Chill.setVisible(true);

        Container c = Chill.getContentPane();
        c.setBackground(Color.yellow);

        silk = new JButton("Silk"   );
        silk.setBorder(null);
        silk.setBounds(100, 190,200,50);
        Chill.add(silk);

        Chilling   =new JLabel("Try these websites to help you relax!!");
        Chilling.setBounds(50,50, 600,30);
        Chilling.setFont(new Font("Serif", Font.BOLD, 25));
        Chilling.setForeground(Color.GREEN);
        Chill.add(Chilling);

    }
    public static void main(String args[]){
        Relax snack = new Relax();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == silk){

        }

    }

}

