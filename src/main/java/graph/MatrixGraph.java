package graph;

import drawing.DrawingApi;
import drawing.Point;

import java.util.List;

public class MatrixGraph extends Graph {
    public MatrixGraph(DrawingApi drawingApi, String graphStringResource) {
        super(drawingApi, graphStringResource);
    }

    @Override
    protected void drawLines(List<Point> points) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (graph.get(i).get(j) != 0) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(j);

                    drawingApi.drawLine(p1.x(), p1.y(), p2.x(), p2.y());
                }
            }
        }
    }
}
