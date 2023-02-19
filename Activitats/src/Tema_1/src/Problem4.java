package Tema_1.src;

import acm.program.CommandLineProgram;

 import java.util.Arrays;


 public class Problem4 extends CommandLineProgram {

     public void run() {
         char[] caracteres = new char[] {' ', 'a', ' ', 'c', 'd', 'e'};
         var array = removeSpaces(caracteres);
         for(char c : array){
             System.out.println(c);
         }

     }

     public char[] removeSpaces(char[] chars) {
         char[] noSpaces = new char[chars.length];
         int j = 0;
         for (int i=0; i < chars.length; i++) {
             if (chars[i] == ' '){
                 continue;
             }
             noSpaces[j] = chars[i];
             j++;
         }
         return Arrays.copyOfRange(noSpaces, 0, j);
     }

     public static void main(String[] args) {
         new Problem4().start(args);
     }
 }

 /*
Diseñad e implementad una función que reciba un vector de caracteres
una cadena de caracteres str y como resultado devuelva el vector que
contenga los mismos caracteres originales pero sin los que son espacios en blanco.

Por ejemplo, si el vector de entrada fuera {‘ ‘, ‘a’, ‘ ‘, ‘c’, ‘d’, ‘e’},
el resultado sería {‘a’, ‘c’, ‘d’, ‘e’}.
Haced un programa que pruebe con arrays de diferentes longitudes y escriba
tanto el array de entrada como el resultado.
 */