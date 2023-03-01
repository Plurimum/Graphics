import drawing.DrawingApi;
import drawing.JavaAwtDrawing;
import drawing.JavaFXDrawing;
import graph.EdgesGraph;
import graph.Graph;
import graph.MatrixGraph;

import java.util.List;

public class Main {
    private static final List<String> drawingOptions = List.of("awt", "fx");
    private static final List<String> graphOptions = List.of("edges", "matrix");

    public static void main(String[] args) {
        if (args == null || args.length < 2 || !drawingOptions.contains(args[0]) || !graphOptions.contains(args[1])) {
            System.err.println("You should specify 2 args: {awt|fx} {edges|matrix}");
            System.exit(1);
        }

        DrawingApi drawingApi = switch (args[0]) {
            case "awt" -> new JavaAwtDrawing();
            case "fx" -> new JavaFXDrawing();
            default -> throw new IllegalStateException();
        };
        Graph graph = switch (args[1]) {
            case "edges" -> new EdgesGraph(drawingApi, "graphEdges");
            case "matrix" -> new MatrixGraph(drawingApi, "graphMatrix");
            default -> throw new IllegalStateException();
        };

        graph.readGraph();
        graph.drawGraph();
    }
}
