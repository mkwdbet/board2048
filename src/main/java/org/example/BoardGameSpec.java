package org.example;

public interface BoardGameSpec {
    Board init();
    Board keyLeft();
    Board keyRight();
    Board keyUp();
    Board keyDown();
}
