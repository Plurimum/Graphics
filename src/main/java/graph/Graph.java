package graph;

import drawing.DrawingApi;
import drawing.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.DoubleStream;

public abstract class Graph {
    /**
     * Bridge to drawing api
     */
    protected final DrawingApi drawingApi;
    protected List<List<Integer>> graph;
    protected final String graphStringResource;

    public Graph(DrawingApi drawingApi, String graphStringResource) {
        this.drawingApi = drawingApi;
        this.graphStringResource = graphStringResource;
    }

    public void drawGraph() {
        int size = graph.size();
        double step = 2 * Math.PI / size;

        List<Point> points = DoubleStream.iterate(0.0, v -> v + step)
                .limit(size)
                .mapToObj(v -> new Point(drawingApi.getAbsoluteX(Math.cos(v)), drawingApi.getAbsoluteY(Math.sin(v))))
                .peek(p -> drawingApi.drawCircle(p.x(), p.y(), 10.0))
                .toList();

        drawLines(points);

        drawingApi.draw();
    }

    protected abstract void drawLines(List<Point> points);

    public void readGraph() {
        try (
                BufferedReader reader = Files.newBufferedReader(
                        Path.of(
                                Objects.requireNonNull(ClassLoader.getSystemResource(graphStringResource)).toURI()
                        )
                )
        ) {
            graph = reader.lines()
                    .map(line -> line.split(" "))
                    .map(arr -> Arrays.stream(arr)
                            .map(Integer::parseInt)
                            .toList()
                    )
                    .toList();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}