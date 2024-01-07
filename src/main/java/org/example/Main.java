package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

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
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new GridLayout(Board.HEIGHT, Board.WIDTH));

        boardView = new JButton[Board.HEIGHT][];
        for (int i = 0; i < Board.HEIGHT; i++) {
            boardView[i] = new JButton[Board.WIDTH];
            for (int j = 0; j < Board.WIDTH; j++) {
                JButton cell = new JButton("" + i + "," + j);
                cell.setSize(WIDTH_SIZE, HEIGHT_SIZE);
                cell.setFocusable(false);
                cell.setFont(new Font("Arial", Font.PLAIN, 40));

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
                if (board.get(i, j) != 0) {
                    boardView[i][j].setForeground(ColorGenerator.generateColor(board.get(i, j)));
                    boardView[i][j].setText("" + board.get(i, j));
                } else {
                    boardView[i][j].setText("");
                }
            }
        }

    }

    private void showGameOverDialog() {
        int result = 0;
        result = JOptionPane.showConfirmDialog(null, "GameOver!! 다시 시작하시겠습니까?");
        if (result == 0) {
            Board initializedBoard = game.init();
            drawBoard(initializedBoard);
        } else {
            System.exit(0);
        }
    }

    private void addListener(BoardGameSpec game) {
        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        drawBoard(game.keyUp());
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        drawBoard(game.keyDown());
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        drawBoard(game.keyRight());
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        drawBoard(game.keyLeft());
                    }
                } catch (GameOverException gameOver) {
                    showGameOverDialog();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    class ColorGenerator {  
        private static Map<Integer, Color> colorMap = new HashMap<>();
        private static Random rand = new Random();

        public static Color generateColor(int number) {
            if (colorMap.containsKey(number)) {
                return colorMap.get(number);
            }
            Color newColor = generateRandomColor();
            colorMap.put(number, newColor);
            return newColor;
        }

        private static Color generateRandomColor() {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            return new Color(r, g, b);
        }
    }
}