// It knows the game rules

public class Game {

    private final Board board;

    public Game(Board board) {
        throw new UnsupportedOperationException("Step 5");
    }

    public boolean isValidFrom(Position from) {
        throw new UnsupportedOperationException("Step 5");
    }

    // Assumes validFrom is a valid starting position
    public boolean isValidTo(Position validFrom, Position to) {
        throw new UnsupportedOperationException("Step 5");
    }

    // Assumes both positions are valid
    public Position move(Position validFrom, Position validTo) {
        throw new UnsupportedOperationException("Step 5");
    }

    public boolean hasValidMovesFrom() {
        throw new UnsupportedOperationException("Step 5");
    }

    public int countValidMovesFrom() {
        throw new UnsupportedOperationException("Step 5");
    }

    public int countValidMovesTo(Position validFrom) {
        throw new UnsupportedOperationException("Step 5");
    }
}
