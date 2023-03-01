package drawing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class JavaFXDrawing extends AbstractDrawingApi {
    private static final List<Shape> shapes = new ArrayList<>();

    @Override
    public void drawCircle(double x, double y, double radius) {
        shapes.add(new Circle(x, y, radius));
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        shapes.add(new Line(x1, y1, x2, y2));
    }

    @Override
    public void draw() {
        Application.launch(JavaFXApplication.class);
    }

    public static class JavaFXApplication extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            Group root = new Group();
            shapes.forEach(shape -> root.getChildren().add(shape));

            primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
            primaryStage.show();
        }
    }
}
