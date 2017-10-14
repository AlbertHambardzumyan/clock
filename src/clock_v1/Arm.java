package clock_v1;

import java.awt.*;

class Arm {
    private int value, length, period;

    Arm(int length, int period) {
        value = 0;
        this.length = length;
        this.period = period;
    }

    boolean tick() {
        value = (value + 1) % period;
        return value == 0;
    }

    void draw(Graphics g, Point start) {
        g.drawLine(start.x, start.y,
                (int) (start.x + length * Math.sin(value * 2 * Math.PI / period)),
                (int) (start.y - length * Math.cos(value * 2 * Math.PI / period)));
    }

}
