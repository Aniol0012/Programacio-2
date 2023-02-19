package Tema_1.src;

import acm.program.CommandLineProgram;


 public class Problem3 extends CommandLineProgram {

     public void run() {
         char[] caracteres = new char[] {'a', 'b', 'c', 'd'};
         char[] charsWithoutExtrem = removeExtrems(caracteres);
         for(int i=0; i< charsWithoutExtrem.length; i++){
             println(charsWithoutExtrem[i]);
         }
     }

     public char[] removeExtrems(char[] chars) {
         if (chars.length <= 2) {
             return new char[0];
         }

         char[] newChars = new char[chars.length - 2];
         for (int i = 1; i < chars.length - 1; i++) {
             newChars[i - 1] = chars[i];
         }
         return newChars;
     }

     public static void main(String[] args) {
         new Problem3().start(args);
     }
 }

 /*
Diseñad e implementad un método tal que como parámetro de entrada
reciba un array de caracteres y como resultado el array consistente en
devolver los mismos elementos y en el mismo orden que el array
original excepto el primero y el último.

Por ejemplo, si el vector de entrada fuera {‘a’, ‘b’, ‘c’, ‘d’} el
resultado sería {‘b’, ‘c’}.
Si el array tiene una longitud menor o igual que dos, se devuelve el
array vacío.
Haced un programa que pruebe con arrays de diferentes longitudes y
escriba tanto el array de entrada como el resultado.
Para la función que escribe el array os podéis inspirar en el println
del ejemplo 4 de los apuntes.
 */