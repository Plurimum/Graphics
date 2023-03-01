import drawing.DrawingApi;
import drawing.JavaAwtDrawing;
import drawing.JavaFXDrawing;
import graph.EdgesGraph;
import graph.Graph;
import graph.MatrixGraph;

public class Main {
    public static void main(String[] args) {
        DrawingApi drawingApi = new JavaFXDrawing();
        Graph graph = new EdgesGraph(drawingApi, "graphEdges");
        graph.readGraph();
        graph.drawGraph();
    }
}
