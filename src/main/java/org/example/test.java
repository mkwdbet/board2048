package org.example;

public class test {
    public static void main(String[] args){
        System.out.println("This is Left");
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                System.out.print("(" + i + "," + j + ")\t");
            }
            System.out.println("");
        }
        System.out.println("This is Right");
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                System.out.print("(" + i + "," + (Board.WIDTH - 1 - j) + ")\t");
            }
            System.out.println("");
        }

    }
}
