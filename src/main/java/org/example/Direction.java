package org.example;

public enum Direction {
    LEFT(1), RIGHT(-1), UP(-1), DOWN(1);
    public final int step;
    private Direction(int step) { 
        this.step = step;
    }
}
