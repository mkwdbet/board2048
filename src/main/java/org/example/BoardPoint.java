package org.example;

public class BoardPoint {
    private int y;
    private int x;

    public BoardPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;

    }

    public int getX() {
        return this.x;

    }

    public BoardPoint shift(Direction direction, int step) {
        if (direction == Direction.LEFT || direction == Direction.RIGHT) {
            return new BoardPoint(this.y, this.x + step * direction.sign);
        }
        return new BoardPoint(this.y + step * direction.sign, this.x);
    }

    public String toString() {
        return "(" + this.y + "," + this.x + ")";
    }

}
