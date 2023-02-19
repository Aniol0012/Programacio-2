package Tema_1.src;

import acm.program.CommandLineProgram;


 public class Problem2 extends CommandLineProgram {

     public void run() {
         int[] nums = new int[] {-2, 3, 10, 200};
         if (nums.length == 0) {
             println("El array es buit");
         }
         int max = max(nums);
         println("El resultat es " + max);
     }

     public int max(int[] numbers) {
         int max = numbers[0];
         for (int i = 1; i < numbers.length; i++) {
             if (numbers[i] > max) {
                 max = numbers[i];
             }
         }
         return max;
     }

     public static void main(String[] args) { new Problem2().start(args); }
 }

 /*
Inspirándoos en el ejemplo 3 de los apuntes, definid una función que devuelva el elemento máximo de un array
de enteros que, como mínimo, tiene un elemento.

int[] nums = new int[] {4, 12, -5, 3};
int max = max(nums);
println(“El resultado es “ + max);

Que debería escribir “El resultado es 12” en la pantalla.
Probad con diferentes vectores y, por ejemplo, uno de tamaño mínimo.
 */