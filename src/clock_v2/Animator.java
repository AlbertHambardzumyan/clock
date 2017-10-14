package clock_v2;

import javax.swing.*;
import java.awt.*;

class Animator extends JApplet implements Runnable {
    public void snapshot(Graphics g) {
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        snapshot(g);
        run();
    }

    public void run() {
        try {
            Thread.sleep(1000);
            repaint();
        } catch (InterruptedException e) {
        }
    }
}
