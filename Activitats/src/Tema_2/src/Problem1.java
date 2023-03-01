package src;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;

public class Problem1 {
    public void run() {
        GLabel label = new GLabel("hello world",100.0,75.0);
        label.move(-50.0, 50.0);

    }
    public static void main(String[] args) {
        new Tema_1.src.Problem1().start(args);
    }
}
