package graph;

import drawing.DrawingApi;
import drawing.Point;

import java.util.List;

public class EdgesGraph extends Graph {
    public EdgesGraph(DrawingApi drawingApi, String graphStringResource) {
        super(drawingApi, graphStringResource);
    }

    @Override
    protected void drawLines(List<Point> points) {
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(graph.get(i).get(j) - 1);

                drawingApi.drawLine(p1.x(), p1.y(), p2.x(), p2.y());
            }
        }
    }
}
