package src;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;


public class Problem2_2 extends GraphicsProgram {
    public double TIMEOUT = 5.0;
    public int NUM_TURTLES = 10;

    public void run() {
        GOval[] references = new GOval[NUM_TURTLES];
        int radius = getHeight() / NUM_TURTLES;
        for (int i = 0; i < NUM_TURTLES; i++) {
            GOval turtle = new GOval(0, i * radius, radius, radius);
            add(turtle);
            turtle.setFilled(true);
            turtle.setFillColor(Color.GREEN);
            references[i] = turtle;
        }

        while (true) {
            for (int i = 0; i < NUM_TURTLES; i++) {
                references[i].move(rollDie(), 0);
                pause(TIMEOUT);
                if (references[i].getX() >= getWidth()) {
                    references[i].setFillColor(Color.RED);
                    break;
                }
            }
        }
    }

    public int rollDie() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1, 6);
    }

    public static void main(String[] args) {
        new Problem2_2().start(args);
    }
}