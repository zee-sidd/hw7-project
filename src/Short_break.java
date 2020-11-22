import javax.swing.*;
import java.awt.*;

public class Short_break {

    JFrame snack;
    JLabel grab_snack;
    JLabel g_snack;

    Short_break(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        snack = new JFrame();
        snack.setSize(700, 700);
        snack.setLayout(null);

        int x = (int) ((dimension.getWidth() - snack.getWidth())/2);
        int y = (int) ((dimension.getHeight() - snack.getHeight())/2);
        snack. setLocation(x,y);

        snack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snack.setVisible(true);

        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("1. Almonds");
        l1.addElement("2. Dark chocolate");
        l1.addElement("3. Fruit Salad");
        l1.addElement("4. Greek Salad");
        l1.addElement("5. Homemade trail mix");
        l1.addElement("6. Apples with peanut butter");
        l1.addElement("7. Blueberries");
        l1.addElement("8. Oatmeal");
        l1.addElement("9. Avocado");
        l1.addElement("10. Oranges");
        l1.addElement("11. String Cheese");
        l1.addElement("12 Hummus");

        JList<String> list = new JList<>(l1);
        list.setBounds(250,300, 150,225);
        snack.add(list);


        grab_snack=new JLabel("Go grab a cup of water or eat some snacks!!");
        grab_snack.setBounds(100,50, 600,30);
        grab_snack.setFont(new Font("Serif", Font.BOLD, 25));
        grab_snack.setForeground(Color.GREEN);
        snack.add(grab_snack);

        g_snack=new JLabel("Here's a list of some of the best brain food snacks for studying!!!");
        g_snack.setBounds(50,250, 600,30);
        g_snack.setFont(new Font("Serif", Font.BOLD, 20));
        g_snack.setForeground(Color.red);
        snack.add(g_snack);

    }

    public static void main(String args[]){
        Short_break snack = new Short_break();
    }
}

