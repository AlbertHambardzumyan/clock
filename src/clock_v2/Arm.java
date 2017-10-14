package clock_v2;

import java.awt.*;

class Arm extends Thread {
    private int length, cycle, period;
    private double value;

    Arm(int length, int cycle, int period, int currentTime) {
        value = currentTime - 1;
        this.length = length;
        this.cycle = cycle;
        this.period = period;
        start();
    }

    public void run() {
        while (true) {
            value = (value + 0.5) % cycle;
            try {
                sleep(period);
            } catch (InterruptedException e) {

            }
        }
    }

    void draw(Graphics g, Point start) {
        g.drawLine(start.x, start.y,
                (int) (start.x + length * Math.sin(value * 2 * Math.PI / cycle)),
                (int) (start.y - length * Math.cos(value * 2 * Math.PI / cycle)));
    }
}
