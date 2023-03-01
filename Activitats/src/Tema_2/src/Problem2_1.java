package src;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


public class Problem2_1 extends GraphicsProgram {
    public double TIMEOUT = 1000.0; // 1 sec

    public void run() {
        GRect rectangle = new GRect(100, 75.0, 30.0, 50.0);
        rectangle.setFillColor(Color.RED);
        add(rectangle);


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
