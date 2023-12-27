package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    private static final int WIDTH_SIZE = 100;
    private static final int HEIGHT_SIZE = 100;
    private final JFrame f = new JFrame();
    private JButton[][] boardView;
    private BoardGameSpec game;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        game = new BoardGame();

        drawGUI();
        addListener(game);

        Board initializedBoard = game.init();
        drawBoard(initializedBoard);
    }

    private void drawGUI() {
        f.setSize(Board.WIDTH * WIDTH_SIZE, Board.HEIGHT * HEIGHT_SIZE);
        f.setResizable(false);
        f.setLocation(100, 100); //TODO
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new GridLayout(Board.HEIGHT, Board.WIDTH));

        boardView = new JButton[Board.HEIGHT][];
        for (int i = 0; i < Board.HEIGHT; i++) {
            boardView[i] = new JButton[Board.WIDTH];
            for (int j = 0; j < Board.WIDTH; j++) {
                JButton cell = new JButton("" + i + "," + j);
                cell.setSize(WIDTH_SIZE, HEIGHT_SIZE);
                cell.setFocusable(false);
                boardView[i][j] = cell;
                f.getContentPane().add(boardView[i][j]);
            }
        }

        f.setVisible(true);
    }

    private void drawBoard(Board board) {
        if (Objects.isNull(board)) {
            return;
        }

        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                if (board.get(i, j) == 0) {
                    boardView[i][j].setText("" + board.get(i, j));
                } else {
                    boardView[i][j].setText("");
                }
            }
        }
    }

    private void addListener(BoardGameSpec game) {
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    drawBoard(game.keyUp());
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    drawBoard(game.keyDown());
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    drawBoard(game.keyRight());
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    drawBoard(game.keyLeft());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}