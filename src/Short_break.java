import java.awt.*;
import javax.swing.*;

public class Short_break {

    JFrame snack;
    JLabel grab_snack;


    Short_break(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        snack = new JFrame();
        snack.setSize(700, 700);
        snack.setLayout(null);

        int x = (int) ((dimension.getWidth() -snack.getWidth())/2);
        int y = (int) ((dimension.getHeight() - snack.getHeight())/2);
        snack. setLocation(x,y);

        snack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snack.setVisible(true);


        grab_snack=new JLabel("Go grab a cup of water or eat some snacks!!");
        grab_snack.setBounds(50,50, 600,30);
        grab_snack.setFont(new Font("Serif", Font.BOLD, 25));
        grab_snack.setForeground(Color.GREEN);
        snack.add(grab_snack);

    }
    public static void main(String args[]){
        Short_break snack = new Short_break();
    }

}

