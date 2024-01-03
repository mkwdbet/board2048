package org.example;

public enum Direction {
    LEFT(1, "left"),
    RIGHT(-1, "right"),
    UP(-1, "up"),
    DOWN(1, "down");

    public final int step;
    public final BoardPoint[][] range;

    private Direction(int step, String name) {
        this.step = step;
        if (name == "left") {
            range = new BoardPoint[Board.HEIGHT][Board.WIDTH];
            for (int i = 0; i < Board.HEIGHT; i++) {
                for (int j = 0; j < Board.WIDTH; j++) {
                    range[i][j] = new BoardPoint(i, j);
                }
            }
        }

        else if (name == "right") {
            range = new BoardPoint[Board.HEIGHT][Board.WIDTH];
            for (int i = 0; i < Board.HEIGHT; i++) {
                for (int j = 0; j < Board.WIDTH; j++) {
                    range[i][j] = new BoardPoint(i, Board.WIDTH - 1 - j);
                }
            }
        }

        else if (name == "down") {
            range = new BoardPoint[Board.HEIGHT][Board.WIDTH];
            for (int i = 0; i < Board.HEIGHT; i++) {
                for (int j = 0; j < Board.WIDTH; j++) {
                    range[i][j] = new BoardPoint(j, i);
                }
            }
        }

        else {
            range = new BoardPoint[Board.HEIGHT][Board.WIDTH];
            for (int i = 0; i < Board.HEIGHT; i++) {
                for (int j = 0; j < Board.WIDTH; j++) {
                    range[i][j] = new BoardPoint(Board.HEIGHT - 1 - i, j);
                }
            }
        }
            

    }

}
