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

    private void sumValues(Board board) {
        for (int i = 0; i < Board.HEIGHT; i++) {
            int[] checkedRow = checkRow(board, i);
            int prevValue = 0;
            int prevIndex = 0;

            for (int j = 0; j < checkedRow.length; j++) {
                // 이전 값과 같은지 비교, set
                if (checkedRow[j] == 1) {
                    if (prevValue == board.get(i, j)) {
                        board.set(i, prevIndex, prevValue*2);
                        board.set(i, j, 0);
                        prevValue = 0;
                    } 
                    else {
                        prevValue = board.get(i, j);
                        prevIndex = j;
                    }
                }
            }       
        }
    }

    private void shiftLeft(Board board) {
        for (int i = 0; i < Board.HEIGHT; i++) {
            int[] checkedRow = checkRow(board, i);
            int cnt = 0;
            
            for (int j = 0; j < checkedRow.length; j++) {
               
                // 값이 있을 때만 왼쪽으로 정렬
                if (cnt > 0 && checkedRow[j] == 1) {
                    board.set(i, j - cnt, board.get(i, j));
                    board.set(i, j, 0);
                }
                
                if (checkedRow[j] == 0) {
                    cnt += 1;
                }
            }
        }
    }

    @Override
    public Board keyLeft() {
        sumValues(board);
        shiftLeft(board);
        boolean boardEmpty = allocateNewNum(board);
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
