package src;

import acm.program.CommandLineProgram;

import java.util.Arrays;


public class Problem6 extends CommandLineProgram {
    public String removeExtrems(String str) {
        if (str.length() <= 2) {
            return "";
        }
        byte[] strBytes = str.getBytes();
        return new String(Arrays.copyOfRange(strBytes, 1, str.length()));
    }

    public void printString(String str, int testNumber) {
        println("[" + testNumber + "] El string resultant és: `" + str + "`");
    }

    public static void main(String[] args) {
        new Problem6().start(args);
    }
}

 /*
Diseñad e implementad un método tal que como parámetro de entrada
reciba una cadena de caracteres str y como resultado devuelva la
cadena consistente en eliminar los caracteres primero y último de str.

Tened en cuenta qué devolvéis si la cadena está vacía o consiste
solamente en un carácter.
Haced un programa que pida un texto al usuario y muestre el texto sin
los extremos.
 */