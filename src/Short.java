
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class  Short{
    Short(){
        JFrame f=new JFrame("Button Example");
        JButton b=new JButton("Play", new ImageIcon("play.png"));
        b.setBounds(100,100,140, 40);
        f.add(b);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Short();
    }
}