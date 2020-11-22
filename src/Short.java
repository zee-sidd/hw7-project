import javax.swing.*;
public class Short extends JFrame{
    public Short() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 5, 1);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JPanel panel=new JPanel();
        panel.add(slider);
        add(panel);
    }
    public static void main(String s[]) {
        Short frame=new Short();
        frame.pack();
        frame.setVisible(true);
    }
}