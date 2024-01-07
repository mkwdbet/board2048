package org.example;

public class test {
    public static void main(String[] args){
        System.out.println("This is Left");

        for (BoardPoint row[] : Direction.LEFT.range){
            for (BoardPoint p : row){
                System.out.print(p + "\t");
            }
            System.out.println("");
        }
        
        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                System.out.print("(" + i + "," + j + ")\t");
            }
            System.out.println("");
        }

        System.out.println("This is Right");
        for (BoardPoint row[] : Direction.RIGHT.range){
            for (BoardPoint p : row){
                System.out.print(p + "\t");
            }
            System.out.println("");
        }

        for (int i = 0; i < Board.HEIGHT; i++) {
            for (int j = 0; j < Board.WIDTH; j++) {
                System.out.print("(" + i + "," + (Board.WIDTH - 1 - j) + ")\t");
            }
            System.out.println("");
        }


        System.out.println("This is Down");
        for (BoardPoint row[] : Direction.DOWN.range){
            for (BoardPoint p : row){
                System.out.print(p + "\t");
            }
            System.out.println("");
        }        

        for (int i = 0; i < Board.HEIGHT; i ++) {
            for (int j = 0; j < Board.WIDTH; j++){
                System.out.print("(" + j + "," + i + ")\t");
            }
            System.out.println("");
        }


        System.out.println("This is Up");
        for (BoardPoint row[] : Direction.UP.range){
            for (BoardPoint p : row){
                System.out.print(p + "\t");
            }
            System.out.println("");
        }


        for (int i = 0; i < Board.HEIGHT; i ++) {
            for (int j = 0; j < Board.WIDTH; j++){
                System.out.print("(" + (Board.HEIGHT- 1 - j)+ "," + i + ")\t");
            }
            System.out.println("");
        }
    }
}
