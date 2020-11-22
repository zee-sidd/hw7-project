import java.awt.*;
import javax.swing.*;

public class Short_break {

    JFrame snack;



    Short_break(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        snack = new JFrame();
        snack.setSize(350, 350);
        snack.setLayout(null);

        int x = (int) ((dimension.getWidth() -snack.getWidth())/2);
        int y = (int) ((dimension.getHeight() - snack.getHeight())/2);
        snack. setLocation(x,y);

        snack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snack.setVisible(true);


    }
    public static void main(String args[]){
        Short_break snack = new Short_break();
    }

}
