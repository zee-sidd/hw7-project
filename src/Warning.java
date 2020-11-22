import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        nah.addActionListener(this);
        yay.addActionListener(this);


       String xx = "According to recent studies, it is recommended to take short breaks every 30 minutes! Are you sure you don't want to take a break?";

        JTextArea textArea = new JTextArea(2, 20);
        textArea.setText(xx);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        textArea.setBounds(20,10, 350,100);
        textArea.setFont(new Font("Serif", Font.BOLD, 15));
        textArea.setForeground(Color.GREEN);
        textArea.setEditable(false);
        Rethink.add(textArea);

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