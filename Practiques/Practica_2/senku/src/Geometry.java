import acm.graphics.GDimension;
import acm.graphics.GPoint;

public class Geometry {

    private final int windowWidth;
    private final int windowHeight;
    private final int numCols;
    private final int numRows;
    private final double boardPadding;
    private final double cellPadding;

    public Geometry(int windowWidth, int windowHeight, int numCols, int numRows, double boardPadding, double cellPadding) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.numCols = numCols;
        this.numRows = numRows;
        this.boardPadding = boardPadding;
        this.cellPadding = cellPadding;
    }

    public int getRows() {
        return numRows;
    }

    public int getColumns() {
        return numCols;
    }

    // Calculates and returns the factor for width and height using padding
    private double calculateFactor(double padding) {
        return 1 - padding * 2;
    }

    public GDimension boardDimension() {
        double boardW = windowWidth * calculateFactor(boardPadding);
        double boardH = windowHeight * calculateFactor(boardPadding);
        return new GDimension(boardW, boardH);
    }

    public GPoint boardTopLeft() {
        double x = windowWidth * boardPadding;
        double y = windowHeight * boardPadding;
        return new GPoint(x, y);
    }

    public GDimension cellDimension() {
        GDimension boardDim = boardDimension();
        double cellWidth = boardDim.getWidth() / numCols;
        double cellHeight = boardDim.getHeight() / numRows;
        return new GDimension(cellWidth, cellHeight);
    }

    public GPoint cellTopLeft(int x, int y) {
        GDimension cellDim = cellDimension();
        double topLeftX = boardTopLeft().getX() + cellDim.getWidth() * x;
        double topLeftY = boardTopLeft().getY() + cellDim.getHeight() * y;
        return new GPoint(topLeftX, topLeftY);
    }

    public GDimension tokenDimension() {
        GDimension cellDim = cellDimension();
        double tokenWidth = cellDim.getWidth() * calculateFactor(cellPadding);
        double tokenHeight = cellDim.getHeight() * calculateFactor(cellPadding);
        return new GDimension(tokenWidth, tokenHeight);
    }

    public GPoint tokenTopLeft(int x, int y) {
        GDimension cellDim = cellDimension();
        double topLeftX = cellTopLeft(x, y).getX() + cellPadding * cellDim.getWidth();
        double topLeftY = cellTopLeft(x, y).getY() + cellPadding * cellDim.getHeight();
        return new GPoint(topLeftX, topLeftY);
    }

    public Position xyToCell(double x, double y) {
        double cellX = (x - boardTopLeft().getX()) / cellDimension().getWidth();
        double cellY = (y - boardTopLeft().getY()) / cellDimension().getHeight();
        return new Position((int) cellX, (int) cellY);
    }

    public GPoint centerAt(int x, int y) {
        GDimension cellDim = cellDimension();
        double centerX = cellTopLeft(x, y).getX() + cellDim.getWidth() / 2;
        double centerY = cellTopLeft(x, y).getY() + cellDim.getHeight() / 2;
        return new GPoint(centerX, centerY);
    }
}
