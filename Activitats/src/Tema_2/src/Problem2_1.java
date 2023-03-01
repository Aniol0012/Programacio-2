package src;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


public class Problem2_1 extends GraphicsProgram {
    public double TIMEOUT = 5.0;

    public void run() {
        double rectWidth = 50.0;
        double rectHeight = 50.0;
        double inicialX = (getWidth() / 2.0) - (rectWidth / 2.0); // Both in the middle of the screen
        double inicialY = (getHeight() / 2.0) - (rectHeight / 2.0);

        GRect rectangle = new GRect(inicialX, inicialY, rectWidth, rectHeight);
        add(rectangle);
        rectangle.setFilled(true);
        rectangle.setFillColor(Color.RED);
        double position = rectangle.getX(); // Actual position;
        boolean shiftLeft = true;
        while (true) {
            if (position >= 0 && shiftLeft) { // Shifting to the left
                if (position == 0) {
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

/*
Haced un programa usando las bibliotecas gráficas del paquete acm
que haga lo siguiente:
    • Escriba un rectángulo pintado de rojo en el centro de la pantalla
    • Mueva dicho rectángulo de izquierda a derecha de manera que
      cuando llegue a uno de los extremos de la pantalla, “rebote” y
      empiece a moverse en el sentido contrario

Podéis hacer varias versiones:
    • Cambiando la posición del rectángulo con el método
      setLocation
    • Cambiando la posición del rectángulo con el método move

Usad constantes para los valores del tamaño del cuadrado, la duración
de la pausa que hacéis para que el movimiento sea suave, el número de
píxeles que os movéis a cada paso, etc.
 */
