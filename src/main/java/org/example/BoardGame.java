package org.example;
import java.util.Random;

public class BoardGame implements BoardGameSpec {
    private Random rand;
    
    
    
    @Override
    public Board init() {
        long seed = System.currentTimeMillis();
        rand = new Random(seed);
        
        
        


                
        

        // (조건) ? (참) : (거짓)

        return null;

    }
    private int generateNewNum() {
        int r = rand.nextInt(10); 
        return r == 0 ? 4 : 2; 
    }


    @Override
    public Board keyLeft() {
        return null;
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
