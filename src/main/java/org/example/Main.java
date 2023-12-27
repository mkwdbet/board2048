package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class Main extends JFrame {
    private static final int WIDTH_SIZE = 100;
    private static final int HEIGHT_SIZE = 100;
    private static final int MARGIN_SIZE = 100;
    private JButton[][] boardView;
    private BoardGameSpec game;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        game = new BoardGame();

        drawWindow();
        addListener(game);

        Board initializedBoard = game.init();
        drawBoard(initializedBoard);
    }

    private void drawWindow() {
        setSize(Board.WIDTH * WIDTH_SIZE, Board.HEIGHT * HEIGHT_SIZE);
        setResizable(false);
        setLocation(100, 100); //TODO
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel p = new Panel();
        p.setLayout(new GridLayout(Board.HEIGHT, Board.WIDTH));

        boardView = new JButton[Board.HEIGHT][];
        for (int i = 0; i < Board.HEIGHT; i++) {
            boardView[i] = new JButton[Board.WIDTH];
            for (int j = 0; j < Board.WIDTH; j++) {
                JButton cell = new JButton("" + i + "," + j);
                cell.setSize(WIDTH_SIZE, HEIGHT_SIZE);
                boardView[i][j] = cell;
                p.add(boardView[i][j]);
            }
        }

        add(p, "Center");
        setVisible(true);
    }

    private void drawBoard(Board board) {
        System.out.println("draw!");
        if (Objects.isNull(board)) {
            return;
        }

        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                boardView[i][j].setText("" + board.get(i, j));
            }
        }
    }

    private void addListener(BoardGameSpec game) {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

//                if (e.getKeyCode() == KeyEvent.VK_W) {
//                    drawBoard(game.keyUp());
//                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                    drawBoard(game.keyDown());
//                } else if (e.getKeyCode() == KeyEvent.VK_D) {
//                    drawBoard(game.keyRight());
//                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                    drawBoard(game.keyLeft());
//                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(""+e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}