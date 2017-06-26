package chapter1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author tsasaki
 */
public class Q5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q5::start);
    }

    public static void start(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("test");
        button.addActionListener(e->button.setText("Clicked"));
        frame.add(button);
        frame.setSize(400, 300);
        frame.setVisible(true);

    }
}
