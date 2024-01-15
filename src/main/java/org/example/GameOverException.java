package org.example;

public class GameOverException extends RuntimeException {
    public GameOverException(){
        super("Game Over");
    }
}
