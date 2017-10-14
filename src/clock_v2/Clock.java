package clock_v2;

import java.awt.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Clock extends Animator {
    private Point center;
    private Arm h, m, s;

    public void init() {
        Date time = new Date(System.currentTimeMillis());
        String temp = time.toString();

        int h_time = Integer.parseInt("" + temp.charAt(11) + temp.charAt(12));
        int m_time = Integer.parseInt("" + temp.charAt(14) + temp.charAt(15));
        int s_time = Integer.parseInt("" + temp.charAt(17) + temp.charAt(18));

        center = new Point(100, 100);
        s = new Arm(center.x - 10, 60, 1000, s_time);
        h = new Arm(center.x - 40, 12, 3600000, h_time);
        m = new Arm(center.x - 20, 60, 60000, m_time);
        setSize(2 * (center.x + 2), 2 * (center.y + 2));

        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        threadExecutor.execute(s); // start seconds arm
        threadExecutor.execute(m); // start minutes arm
        threadExecutor.execute(h); // start hours arm
        threadExecutor.shutdown();
    }

    public void snapshot(Graphics g) {
        g.drawString("Rado", 87, 70);
        g.drawOval(0, 0, 2 * center.x, 2 * center.y);

        int cycle = 24;
        int length = center.x - 85;
        for (double value = -1; value < 23; value++) {
            value = (value + 1);
            g.drawLine((int) (center.x + 6 * length * Math.sin(value * 2 * Math.PI / cycle)),
                    (int) (center.y - 6 * length * Math.cos(value * 2 * Math.PI / cycle)),
                    (int) (center.x + 6.5 * length * Math.sin(value * 2 * Math.PI / cycle)),
                    (int) (center.y - 6.5 * length * Math.cos(value * 2 * Math.PI / cycle)));
        }
        cycle = 120;
        length = center.x - 5;
        for (double value = -1; value < 119; value++) {
            value = (value + 1);
            g.drawLine((int) (center.x + length * Math.sin(value * 2 * Math.PI / cycle)),
                    (int) (center.y - length * Math.cos(value * 2 * Math.PI / cycle)),
                    (int) (center.x + length * Math.sin(value * 2 * Math.PI / cycle)),
                    (int) (center.y - length * Math.cos(value * 2 * Math.PI / cycle)));
        }

        s.draw(g, center);
        m.draw(g, center);
        h.draw(g, center);
    }
}
