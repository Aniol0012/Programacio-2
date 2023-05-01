public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean colinear(Position other) {
        return other.x == this.x || other.y == this.y;
    }

    public int distance(Position other) {
        int positionX = Math.abs((other.x) - (this.x));
        int positionY = Math.abs((other.y) - (this.y));
        return positionX + positionY;
    }

    public Position middle(Position other) {
        int x = (other.x + this.x) / 2;
        int y = (other.y + this.y) / 2;
        return new Position(x, y);
    }

    // Needed for testing
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
