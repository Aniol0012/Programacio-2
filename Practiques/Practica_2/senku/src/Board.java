import java.util.StringTokenizer;

// Only a rectangle of cells. Do not know game rules.

public class Board {

    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Board(int width, int height, String board) {
        this.width = width;
        this.height = height;
        cells = new Cell[height][width];
        StringTokenizer st = new StringTokenizer(board, "\n");
        for (int y = 0; y < height; y++) {
            String row = st.nextToken();
            for (int x = 0; x < width; x++) {
                cells[y][x] = Cell.fromChar(row.charAt(x));
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    // Checks if the given position is inside of the board
    public boolean isPositionValid(Position pos) {
        boolean isXValid = pos.getX() >= 0 && pos.getX() < width;
        boolean isYValid = pos.getY() >= 0 && pos.getY() < height;
        return isXValid && isYValid;
    }

    // Returns the Cell object at the given position on the board
    public Cell getCellAtPosition(Position pos) {
        return cells[pos.getY()][pos.getX()];
    }

    public boolean isForbidden(Position pos) {
        return !isPositionValid(pos) ||  getCellAtPosition(pos).isForbidden();
    }

    public boolean isFilled(Position pos) {
        return isPositionValid(pos) && getCellAtPosition(pos).isFilled();
    }

    public boolean isEmpty(Position pos) {
        return isPositionValid(pos) && getCellAtPosition(pos).isEmpty();
    }

    public void fillPosition(Position pos) {
        if (!isForbidden(pos)) {
            cells[pos.getY()][pos.getX()] = Cell.FILLED;
        }
    }

    public void emptyPosition(Position pos) {
        if (!isForbidden(pos)) {
            cells[pos.getY()][pos.getX()] = Cell.EMPTY;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(cells[y][x].toString());
            }
            if (y != height - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
