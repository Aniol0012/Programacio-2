package src;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Problem2_1 extends GraphicsProgram {
    public double TIMEOUT = 5.0;

    public void run() {
        double rectWidth = 50.0;
        double rectHeight = 50.0;
        double inicialX = ((getWidth() - rectHeight) / 2.0); // Both in the middle of the screen
        double inicialY = ((getHeight() - rectHeight) / 2.0);

        GRect rectangle = new GRect(inicialX, inicialY, rectWidth, rectHeight);
        add(rectangle);
        rectangle.setFilled(true);
        rectangle.setFillColor(Color.RED);
        double position = rectangle.getX(); // Actual position;
        boolean shiftLeft = true;

        while (true) {
            if (position >= 0.0 && shiftLeft) { // Shifting to the left
                if (position <= 0.0) {
                    shiftLeft = false;
                    continue;
                }
                rectangle.move(-1, 0);
                pause(TIMEOUT);
            } else if (position <= getWidth() - rectWidth) { // Otherwise shifting to the right
                if (position == getWidth() - rectWidth) {
                    shiftLeft = true;
                    continue;
                }
                rectangle.move(1, 0);
                pause(TIMEOUT);
            }
            position = rectangle.getX(); // Gets the actual position
        }
    }

    public static void main(String[] args) {
        new Problem2_1().start(args);
    }
}