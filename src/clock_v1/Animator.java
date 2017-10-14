package clock_v1;

import javax.swing.*;
import java.awt.*;

class Animator extends JApplet implements Runnable {
    public boolean tick() {
        return true;
    }

    public void snapshot(Graphics g) {
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        snapshot(g);
        if (tick()) {
            repaint();
            run();
        }
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
