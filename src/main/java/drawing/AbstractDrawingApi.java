package drawing;

public abstract class AbstractDrawingApi implements DrawingApi {
    protected static final int WIDTH = 1280;
    protected static final int HEIGHT = 720;

    @Override
    public long getDrawingAreaWidth() {
        return WIDTH;
    }

    @Override
    public long getDrawingAreaHeight() {
        return HEIGHT;
    }

    @Override
    public double getAbsoluteX(double relativeX) {
        return relativeX * getDrawingAreaWidth() / 2 +
                ((double) getDrawingAreaWidth()) / 2 +
                (-1 * Math.signum(relativeX)) * (12.0);
    }

    @Override
    public double getAbsoluteY(double relativeY) {
        double availableHeight = getDrawingAreaHeight() - 50;
        return 50 +
                relativeY * availableHeight / 2 +
                availableHeight / 2 +
                (-1 * Math.signum(relativeY)) * (12.0);
    }
}
