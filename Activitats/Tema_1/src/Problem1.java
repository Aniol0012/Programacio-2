 import acm.program.CommandLineProgram;
 import acm.program.ConsoleProgram;


 public class Problem1 extends CommandLineProgram {

     public void run() {
         int n = readInt("Introdueix un enter: ");
         if (n <= 1) {
             System.out.println("El nombre ha de ser major a 1");
         } else {
             if (isPerfect(n)) {
                 System.out.println(n + " és un número perfecte");
             } else {
                 System.out.println(n + " no és un número perfecte");
             }
         }
     }

     public boolean isPerfect(int num) {
         int sum = 0;
         for (int i = 1; i < num / 2; i++){
             if (num % i == 0) {
                 sum += i;
             }
         }
         return sum == num;
     }

     public static void main(String[] args) {
         new Problem1().start(args);
     }
 }

 /*
Diseñad e implementad un programa tal que pida al usuario un número entero. entero mayor que 1 y, como respuesta,
indique si el entero dado es perfecto o no. Si el número introducido no es mayor que 1, se mostrará un 5mensaje de error.
Un número es perfecto si es la suma de todos sus divisores (excepto de él mismo). Por ejemplo 6 es perfecto pues sus
divisores son 1, 2 y 3, que suman 6. Otros números perfectos son 496 y 8128.
Definid la función auxiliar siguiente para comprobar la propiedad:
 */