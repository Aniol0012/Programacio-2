public class Cell {

    private static final char C_FORBIDDEN = '#';
    private static final char C_FILLED = 'o';
    private static final char C_EMPTY = '·';

    public static final Cell FORBIDDEN = new Cell(C_FORBIDDEN);
    public static final Cell FILLED = new Cell(C_FILLED);
    public static final Cell EMPTY = new Cell(C_EMPTY);

    private final char status;

    private Cell(char status) {
        this.status = status;
    }

    public static Cell fromChar(char status) {
        if (status == C_FORBIDDEN) {
            return FORBIDDEN;
        } else if (status == C_FILLED) {
            return FILLED;
        } else if (status == C_EMPTY) {
            return EMPTY;
        } else {
            return null;
        }
    }

    public boolean isForbidden() {
        return this.status == C_FORBIDDEN;
    }

    public boolean isFilled() {
        return this.status == C_FILLED;
    }

    public boolean isEmpty() {
        return this.status == C_EMPTY;
    }

    @Override
    public String toString() {
        return String.valueOf(status);
    }
}
