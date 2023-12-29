package org.example;

import java.util.Random;
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

    @Override
    public Board keyLeft() {
        allocateNewNum(board);
        return board;

    }

    @Override
    public Board keyRight() {
        Board b = new Board();
        b.init(0);
        b.set(2, 2, 9);
        return b;
    }

    @Override
    public Board keyUp() {
        return null;
    }

    @Override
    public Board keyDown() {
        return null;
    }
}
