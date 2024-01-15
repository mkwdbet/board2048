package org.example;

import java.util.*;

public class Board {
    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;
    private int[][] board = new int[HEIGHT][WIDTH];

    public Board copy() {
        Board newBoard = new Board();
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                newBoard.set(i, j, board[i][j]);
            }
        }
        return newBoard;
    }

    public boolean equals(Board board) {
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                if (this.board[i][j] != board.get(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

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

    public int get(BoardPoint p) {
        if (p.getY() < 0 || p.getY() >= HEIGHT || p.getX() < 0 || p.getX() >= WIDTH) {
            throw new IllegalArgumentException("잚못된 값에 접근했습니다.");
        }

        return board[p.getY()][p.getX()];
    }

    public void set(int i, int j, int value) {
        if (i < 0 || i >= HEIGHT || j < 0 || j >= WIDTH) {
            throw new IllegalArgumentException("잚못된 값에 접근했습니다. (" + i + "," + j + ")");
        }

        board[i][j] = value;
    }

    public void set(BoardPoint p, int value) {
        if (p.getY() < 0 || p.getY() >= HEIGHT || p.getX() < 0 || p.getX() >= WIDTH) {
            throw new IllegalArgumentException("잚못된 값에 접근했습니다. " + p.toString());
        }

        board[p.getY()][p.getX()] = value;
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
