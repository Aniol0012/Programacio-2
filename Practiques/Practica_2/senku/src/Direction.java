public class Direction {
    // L'eix de coordenades està situat a la cantonada superior esquerra
    public static final Direction UP = new Direction(0, -1);
    public static final Direction RIGHT = new Direction(1, 0);
    public static final Direction DOWN = new Direction(0, 1);
    public static final Direction LEFT = new Direction(-1, 0);

    public static final Direction[] ALL = new Direction[]{UP, RIGHT, DOWN, LEFT};

    private final int dx;
    private final int dy;

    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Position apply(Position from) {
        int updatedX = dx + from.getX();
        int updatedY = dy + from.getY();
        return new Position(updatedX, updatedY);
    }
}
