package clock_v1;

import java.awt.*;

public class Clock extends Animator {
    private Point center;
    private Arm h, m, s;

    public void init() {
        center = new Point(100, 100);
        s = new Arm(center.x - 10, 60);
        h = new Arm(center.x - 40, 12);
        m = new Arm(center.x - 20, 60);
        setSize(2 * (center.x + 2), 2 * (center.y + 2));
    }

    public boolean tick() {
        if (s.tick()) {
            m.tick();
            if (m.tick())
                h.tick();
        }
        return true;
    }

    public void snapshot(Graphics g) {
        g.drawOval(2, 2, 2 * center.x, 2 * center.y);
        s.draw(g, center);
        h.draw(g, center);
        m.draw(g, center);
    }
}
