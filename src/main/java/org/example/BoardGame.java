package org.example;

import java.util.Random;
import java.lang.reflect.Array;
import java.util.*;

public class BoardGame implements BoardGameSpec {
    private Random rand;
    private Board board;

    @Override
    public Board init() {
        long seed = System.currentTimeMillis();
        rand = new Random(seed);
        board = new Board();
        board.init(0);
        allocateNewNum(board);
        allocateNewNum(board);
        return board;
    }

    // allocate 성공 = true
    private boolean allocateNewNum(Board board) {
        List<BoardPoint> points = board.getEmptyPoints();
        if (points.size() == 0) {
            return false;
        }
        int r = rand.nextInt(points.size());

        BoardPoint point = points.get(r);
        board.set(point.getY(), point.getX(), generateNewNum());
        return true;
    }

    private int generateNewNum() {
        int r = rand.nextInt(10);
        return r == 0 ? 4 : 2;
    }

    public int[] checkRow(Board board, int row) {
        int[] filledCols = new int[4];
        for (int col = 0; col < Board.WIDTH; col++) {
            if (board.get(row, col) == 0) {
                filledCols[col] = 0;
                continue;
            }
            filledCols[col] = 1;
        }
        return filledCols;
    }

    private void sumValues(Board board, Direction direction) {
        Board prevBoard = new Board();
        prevBoard = board;
        for (BoardPoint[] row : direction.range) {
            int prevValue = -1;
            BoardPoint prevPoint = null;
            for (BoardPoint point : row) {
                if (board.get(point) != 0) {
                    if (prevValue == board.get(point)) {
                        board.set(prevPoint, prevValue * 2);
                        board.set(point, 0);
                        prevValue = 0;
                    } else {
                        prevValue = board.get(point);
                        prevPoint = point;
                    }
                }
            }
        }
    }

    private void shift(Board board, Direction direction) {
        for (BoardPoint row[] : direction.range) {
            int cnt = 0;
            for (BoardPoint point : row) {
                if (cnt > 0 && board.get(point) != 0) {
                    board.set(point.shift(direction, cnt), board.get(point));
                    board.set(point, 0);
                    continue;
                }
                if (board.get(point) == 0) {
                    cnt += 1;
                }
            }
        }
    }

    public boolean isOver(Direction direction) {
        if (direction == Direction.UP || direction == Direction.DOWN) {
            Board virtualBoard = board.copy();
            sumValues(virtualBoard, Direction.LEFT);
            if (virtualBoard.equals(board)) {
                return true;
            }
            return false;
        }
        Board virtualBoard = board.copy();
        sumValues(virtualBoard, Direction.UP);
        if (virtualBoard.equals(board)) {
            return true;
        }
        return false;
    }

    @Override
    public Board keyLeft() {
        sumValues(board, Direction.LEFT);
        shift(board, Direction.LEFT);
        boolean boardEmpty = allocateNewNum(board);
        if (boardEmpty == false) {
            if (isOver(Direction.LEFT)) {
                throw new GameOverException();
            }
        }
        return board;
    }

    @Override
    public Board keyRight() {
        sumValues(board, Direction.RIGHT);
        shift(board, Direction.RIGHT);
        boolean boardEmpty = allocateNewNum(board);
        if (boardEmpty == false) {
            if (isOver(Direction.RIGHT)) {
                throw new GameOverException();
            }
        }
        return board;
    }

    @Override
    public Board keyUp() {
        sumValues(board, Direction.UP);
        shift(board, Direction.UP);
        boolean boardEmpty = allocateNewNum(board);
        if (boardEmpty == false) {
            if (isOver(Direction.UP)) {
                throw new GameOverException();
            }
        }
        return board;
    }

    @Override
    public Board keyDown() {
        sumValues(board, Direction.DOWN);
        shift(board, Direction.DOWN);
        boolean boardEmpty = allocateNewNum(board);
        if (boardEmpty == false) {
            if (isOver(Direction.DOWN)) {
                throw new GameOverException();
            }
        }
        return board;
    }
}
