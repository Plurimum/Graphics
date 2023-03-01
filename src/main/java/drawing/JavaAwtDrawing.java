package drawing;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class JavaAwtDrawing extends AbstractDrawingApi {
    private final List<Ellipse2D> ellipses;
    private final List<Line2D> lines;
    private final AwtFrame awtFrame;

    public JavaAwtDrawing() {
        this.ellipses = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.awtFrame = new AwtFrame();
    }

    @Override
    public void drawCircle(double x, double y, double radius) {
        ellipses.add(new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2));
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        lines.add(new Line2D.Double(new Point2D.Double(x1, y1), new Point2D.Double(x2, y2)));
    }

    @Override
    public void draw() {
        awtFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        awtFrame.setSize((int) getDrawingAreaWidth(), (int) getDrawingAreaHeight());
        awtFrame.setVisible(true);
    }

    private class AwtFrame extends Frame {
        @Override
        public void paint(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;

            ellipses.forEach(graphics2D::fill);
            lines.forEach(graphics2D::draw);
        }
    }
}
