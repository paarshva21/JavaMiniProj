import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.time.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ClockDisplay extends JFrame implements ActionListener {
    Container c;
    JTextField t1;
    JButton b1, b2;
    JLabel l1, l2;

    ClockDisplay() {
        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        l1 = new JLabel("Clock Display");
        l2 = new JLabel("Timer Display");
        b1 = new JButton("Clock");
        b2 = new JButton("Timer");
        t1 = new JTextField("Enter no. of seconds");
        c.add(l1);
        c.add(b1);
        c.add(l2);
        c.add(t1);
        c.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                l1.setText(formatter.format(date));
            }
        });
        timer.start();
    }

    public void startTimer(int time) {
        Timer timer = new Timer(1000, new ActionListener() {
            int s = time;

            public void actionPerformed(ActionEvent ae) {
                s--;
                l2.setText(Integer.toString(s));
                if (s <= 0) {
                    l2.setText("Timer completed");
                }

            }
        });

        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1)
            startClock();
        if (ae.getSource() == b2) {
            int time = Integer.parseInt(t1.getText());
            startTimer(time);
        }

    }
}

public class JavaMiniProj {

    public static void main(String[] args) {
        ClockDisplay cd = new ClockDisplay();
        cd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.setBounds(200, 200, 150, 150);
        cd.setVisible(true);
        cd.setTitle("Clock Application");
    }
}
