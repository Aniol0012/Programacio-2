import acm.program.CommandLineProgram;

import java.util.Arrays;


 public class Problem7 extends CommandLineProgram {

     public void run() {
         String caracteres = "hola que tal";
         var array = removeSpaces(caracteres);
         System.out.println(array);

     }

     public String removeSpaces(String str) {
         char[] toChar = str.toCharArray();
         @SuppressWarnings("")
         char[] noSpaces = new char[toChar.length];
         int j = 0;
         for (int i=0; i < toChar.length; i++) {
             if (toChar[i] == ' '){
                 continue;
             }
             noSpaces[j] = toChar[i];
             j++;
         }
         var arr = Arrays.copyOfRange(noSpaces, 0, j);
         return new String(arr);
     }

     public static void main(String[] args) {
         new Problem7().start(args);
     }
 }

 /*
Diseñad e implementad un método tal que como parámetro de entrada reciba una cadena de caracteres
str y como resultado devuelva la cadena consistente en eliminar todos los espacios de str.
Haced un programa que pida un texto al usuario y muestre el texto sin espacios.
 */