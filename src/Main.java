import clock_v1.Clock;

import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        Clock applet = new Clock();

        JFrame frame = new JFrame("Clock");
        frame.getContentPane().add(applet);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(205,228);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        applet.init();
    }
}
