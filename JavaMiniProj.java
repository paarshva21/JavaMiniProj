import java.util.*;
import javax.swing.*;
import java.time.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ClockDisplay extends JFrame implements ActionListener {
    Container c;
    JTextField t1;
    JButton b1, b2, b3;
    JLabel l1;
    SimpleDateFormat timeFormat=new SimpleDateFormat();
    Calendar calendar=Calendar.getInstance();

    ClockDisplay() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        l1 = new JLabel("Clock Display");
        b1 = new JButton("Click Me");
        c.add(l1);
        c.add(b1);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        l1.setText(""+calendar.getTime());
    }
}

public class JavaMiniProj {

    public static void main(String[] args) {
        ClockDisplay cd = new ClockDisplay();
        cd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.setBounds(300, 300, 300, 300);
        cd.setVisible(true);
        cd.setTitle("Clock Application");
    }
}
