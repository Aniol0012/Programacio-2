package src;

import acm.program.CommandLineProgram;

import java.util.Arrays;


public class Problem5 extends CommandLineProgram {
    public int[][] matrixMultiplication(int[][] left, int[][] right) {
        int numRowsLeft = left.length;
        int numRowsRight = right.length;
        int numColsLeft = left[0].length; // El mateix que numRowsRight
        int numColsRight = right[0].length;
        int[][] product = new int[numRowsLeft][numColsRight];

        if (numColsLeft == 0 || numColsRight == 0 || numColsLeft != numRowsRight) {
            return new int[][]{{}};
        }

        for (int i = 0; i < numRowsLeft; i++) {
            for (int j = 0; j < numColsRight; j++) {
                for (int k = 0; k < numColsLeft; k++) {
                    product[i][j] += left[i][k] * right[k][j];
                }
            }
        }
        return product;
    }

    public void printMatrix(int[][] result, int testNumber) {
        println("[" + testNumber + "] La matriu resultant és:");
        for (int i = 0; i < result.length; i++) {
            println("\t" + Arrays.toString(result[i]));
        }
    }

    public static void main(String[] args) {
        new Problem5().start(args);
    }
}

/*
Diseñad e implementad un método para multiplicar matrices de enteros.
El método recibirá como parámetros dos matrices y devolverá como resultado otra matriz. Es decir:

Simplificaciones y pistas:
    • Dentro de la función podéis suponer que las matrices son de las
      dimensiones que tienen que ser (el número de columnas de left
      ha de coincidir con el número de filas de right).

    • Haced un programa principal que cree un par de matrices
      constantes (aseguraros de que son de las dimensiones
      correctas).
    • Podéis usar el método print definido en el ejemplo de los
      apuntes (o programar uno por vosotros mismos).
 */