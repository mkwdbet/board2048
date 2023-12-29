package org.example;

import java.util.*;

public class Board {
    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;
    private int[][] board = new int[HEIGHT][WIDTH];

    public void init(int initValue) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = initValue;
            }
        }
    }

    public int get(int i, int j) {
        if (i < 0 || i >= HEIGHT || j < 0 || j >= WIDTH) {
            throw new IllegalArgumentException("잚못된 값에 접근했습니다.");
        }

        return board[i][j];
    }

    public void set(int i, int j, int value) {
        if (i < 0 || i >= HEIGHT || j < 0 || j >= WIDTH) {
            throw new IllegalArgumentException("잚못된 값에 접근했습니다.");
        }

        board[i][j] = value;
    }

    public List<BoardPoint> getEmptyPoints() {
        List<BoardPoint> pointList = new ArrayList<BoardPoint>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == 0) {
                    pointList.add(new BoardPoint(i, j));
                }
            }
        }
        return pointList;
    }
}
