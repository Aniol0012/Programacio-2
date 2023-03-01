package src;

import acm.program.CommandLineProgram;

import java.util.Arrays;


public class Problem7 extends CommandLineProgram {
    public String removeSpaces(String str) {
        char[] strToChar = str.toCharArray();
        char[] strResult = new char[strToChar.length];
        int resultLenght = 0;
        for (int i = 0; i < strToChar.length; i++) {
            if (strToChar[i] == ' ') {
                continue;
            }
            strResult[resultLenght] = strToChar[i];
            resultLenght++;
        }
        return new String(Arrays.copyOfRange(strResult, 0, resultLenght));
    }

    public void printString(String str, int testNumber) {
        println("[" + testNumber + "] El string resultant és: `" + str + "`");
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