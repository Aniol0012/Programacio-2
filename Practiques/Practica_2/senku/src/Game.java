// It knows the game rules

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public boolean isValidFrom(Position from) {
        Direction[] directions = Direction.ALL;
        for (int i = 0; i < directions.length; i++) {
            Direction direction = directions[i];
            Position adjacent = direction.apply(from);
            Position to = direction.apply(adjacent);

            if (board.isFilled(from) && board.isFilled(adjacent) && board.isEmpty(to) && board.isPositionValid(adjacent) && board.isPositionValid(to)) {
                return true;
            }
        }
        return false;
    }

    // Assumes validFrom is a valid starting position
    public boolean isValidTo(Position validFrom, Position to) {
        if (!board.isPositionValid(validFrom) || !board.isPositionValid(to) || !board.isFilled(validFrom) || !board.isEmpty(to)) {
            return false;
        }
        Position adjacent = validFrom.middle(to);
        return board.isFilled(adjacent);
    }

    // Assumes both positions are valid
    public Position move(Position validFrom, Position validTo) {
        if (isValidFrom(validFrom) && isValidTo(validFrom, validTo)) {
            board.emptyPosition(validFrom.middle(validTo));
            board.emptyPosition(validFrom);
            board.fillPosition(validTo);
        }
        return validFrom.middle(validTo);
    }

    public boolean hasValidMovesFrom() {
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                Position from = new Position(x, y);
                if (isValidFrom(from)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countValidMovesFrom() {
        int counter = 0;
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                Position from = new Position(x, y);
                if (isValidFrom(from)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int countValidMovesTo(Position validFrom) {
        int counter = 0;
        for (Direction direction : Direction.ALL) {
            Position adjacent = direction.apply(validFrom);
            Position to = direction.apply(adjacent);
            if (board.isPositionValid(to) && board.isEmpty(to) && board.isFilled(adjacent)) {
                counter++;
            }
        }
        return counter;
    }
}
