package Tema_2.src;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class Problem2_2 extends GraphicsProgram {
    public double TIMEOUT = 20.0;
    public double PADDING = 5.0;
    public int NUM_TURTLES = 10;

    public void run() {
        GOval[] turtles = new GOval[NUM_TURTLES];
        double radius = (double) getHeight() / NUM_TURTLES;
        for (int i = 0; i < NUM_TURTLES; i++) {
            GOval turtle = new GOval(0, i * radius, radius - PADDING, radius - PADDING);
            add(turtle);
            turtle.setFilled(true);
            turtle.setFillColor(Color.GREEN);
            turtle.setColor(Color.ORANGE);
            turtles[i] = turtle;
        }
        GLabel msg = new GLabel("Click to start the race", ((getWidth() - 50.0) / 2.0), ((getHeight() - 50.0) / 2.0));
        add(msg);
        waitForClick();
        remove(msg);
        boolean running = true;
        while (running) {
            for (int i = 0; i < NUM_TURTLES; i++) {
                turtles[i].move(rollDie(), 0);
                if (turtles[i].getX() >= getWidth() - radius) {
                    turtles[i].setFillColor(Color.RED);
                    running = false;
                    break;
                }
            }
            pause(TIMEOUT);
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