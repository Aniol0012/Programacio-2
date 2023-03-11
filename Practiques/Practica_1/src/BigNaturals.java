import acm.program.CommandLineProgram;

import java.util.Arrays;

/**
 * Implementations of infinite precision naturals using arrays of ints
 * <p>
 * - Each position in the array corresponds to a digit (between 0 and 9)
 * - Least significative digit on pos 0
 * - No 0's allowed on the front (except for the case of number 0)
 *
 * @author jmgimeno
 */

public class BigNaturals extends CommandLineProgram {
    public int[] zero() {
        return new int[]{0};
    }

    public int[] one() {
        return new int[]{1};
    }

    public boolean equals(int[] number1, int[] number2) {
        if (number1.length != number2.length) {
            return false;
        }

        for (int position = 0; position < number1.length; position++) {
            if (number1[position] != number2[position]) {
                return false;
            }
        }
        return true;
    }

    public int[] add(int[] num1, int[] num2) {
        if (equals(num1, zero())) {
            return num2;
        } else if (equals(num2, zero())) {
            return num1;
        }

        int tempLength = Math.max(num1.length, num2.length);
        int total, carry = 0;
        int[] result = new int[tempLength + 1];

        for (int i = 0; i < tempLength; i++) {
            int digit1 = 0;
            int digit2 = 0;
            if (num1.length > i) {
                digit1 = num1[i];
            }
            if (num2.length > i) {
                digit2 = num2[i];
            }
            total = digit1 + digit2 + carry;
            if (total > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            result[i] = total % 10;
        }

        if (carry > 0) {
            result[tempLength] = carry;
        }

        int lastIndex = result.length - 1;
        int nonZeroDigit = 0;

        // Deletes the unnecessary 0's
        for (int i = 0; i <= lastIndex; i++) {
            if (result[i] != 0) {
                nonZeroDigit = i;
            }
        }

        // Checks if there are any 0's left
        if (nonZeroDigit != lastIndex) {
            int[] shorterResult = new int[nonZeroDigit + 1];
            for (int j = 0; j <= nonZeroDigit; j++) {
                shorterResult[j] = result[j];
            }
            result = shorterResult;
        }
        return result;
    }

    public int[] shiftLeft(int[] number, int positions) {
        if (equals(number, zero()) || positions == 0) {
            return number;
        }

        int[] result = new int[number.length + positions];

        for (int i = 0; i < number.length; i++) {
            result[i + positions] = number[i];
        }
        return result;
    }

    public int[] multiplyByDigit(int[] number, int digit) {
        if (equals(number, zero()) || digit == 0) {
            zero();
        }

        int[] result = zero();
        for (int i = 1; i <= digit; i++) {
            result = add(result, number);
        }
        return result;
    }

    public int[] multiply(int[] number1, int[] number2) {
        int[] result = zero();

        for (int i = 0; i < number1.length; i++) {
            int digit1 = number1[i];

            int[] partialResult = zero();
            int carry = 0;

            for (int j = 0; j < number2.length; j++) {
                int digit2 = number2[j];

                int product = digit1 * digit2 + carry;
                carry = product / 10;
                int digit = product % 10;

                int[] partial = shiftLeft(intToArray(digit), i + j);
                partialResult = add(partialResult, partial);
            }

            if (carry > 0) {
                int[] partial = shiftLeft(intToArray(carry), i + number2.length);
                partialResult = add(partialResult, partial);
            }
            result = add(result, partialResult);
        }
        return result;
    }

    public int[] factorial(int[] number) {
        if (equals(number, zero()) || equals(number, one())) {
            return one();
        }

        int[] result = number, currentFactor;

        for (currentFactor = intToArray(2); !equals(currentFactor, number); currentFactor = add(currentFactor, one())) {
            result = multiply(currentFactor, result);
        }
        return result;

    }

    public int[] fibonacci(int[] number) {
        printBar();
        if (equals(number, zero())) {
            return zero();
        } else if (equals(number, one())) {
            return one();
        }

        int[] previousFactor = zero();
        int[] currentFactor = one();
        int[] result = new int[number.length];
        // fib_n = fib_n-1 + fib_n-2
        for (int position = 0; position != number.length; position++) {
            int[] sum = add(previousFactor, currentFactor);
            previousFactor = currentFactor;
            currentFactor = sum;
            print("PV en " + position + ": ");
            println(previousFactor);
            print("CF en " + position + ": ");
            println(currentFactor);
        }
        return currentFactor;
    }

/*
    public int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - i - 1];
        }
        return result;
    }
 */

    public int[] intToArray(int integer) {
        return new int[]{integer};
    }

    public void println(int[] arr) { // Eliminar
        print("{*} [");
        for (int i = 0; i < arr.length - 1; i++) {
            print(arr[i] + ",");
        }
        println(arr[arr.length - 1] + "]");
    }

    public void run() {

//        testFromString();
//        testAsString();
//        testZero();
//        testOne();
//        testEquals();
//        testAdd();
//        testShiftLeft();
//        testMultiplyByDigit();
//        testMultiply();
//        testFactorial();
        testFibonacci();
    }

    public static void main(String[] args) {
        new BigNaturals().start(args);
    }

    // -----
    // TESTS
    // -----

    // Functions for simplifying vector tests.

    public int[] fromString(String number) {
        // "25"  -> {5, 2}
        // "1"   -> {1}
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String digit = number.substring(i, i + 1);
            digits[number.length() - i - 1] = Integer.parseInt(digit);
        }
        return digits;
    }

    private void testFromString() {
        printlnInfo("Inicio de las pruebas de fromString");
        if (!Arrays.equals(new int[]{5, 2}, fromString("25"))) {
            printlnError("Error en el caso \"25\"");
        }
        if (!Arrays.equals(new int[]{1}, fromString("1"))) {
            printlnError("Error en el caso \"1\"");
        }
        printlnInfo("Final de las pruebas de fromString");
    }

    public String asString(int[] ints) {
        // {1}    -> "1"
        // {5, 2} -> "25"
        char[] intToChar = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] chars = new char[ints.length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = intToChar[ints[ints.length - i - 1]];

        }
        return new String(chars);
    }

    private void testAsString() {
        printlnInfo("Inicio de las pruebas de fromString");
        if (!"25".equals(asString(new int[]{5, 2}))) {
            printlnError("Error en el caso int[] {5, 2}");
        }
        if (!"1".equals(asString(new int[]{1}))) {
            printlnError("Error en el caso int[] {1}");
        }
        printlnInfo("Final de las pruebas de fromString");
    }

    private void testZero() {
        printlnInfo("Inicio de las pruebas de zero");
        if (!"0".equals(asString(zero()))) {
            printlnError("Error en la función zero");
        }
        printlnOk("Final de las pruebas de zero");
    }

    private void testOne() {
        printlnInfo("Inicio de las pruebas de one");
        if (!"1".equals(asString(one()))) {
            printlnError("Error en la función one");
        }
        printlnOk("Final de las pruebas de one");
    }

    private void testEquals() {
        printlnInfo("Inicio de las pruebas de equals");
        if (equals(zero(), one())) {
            printlnError("Error en el caso 0 != 1");
        }
        if (!equals(one(), one())) {
            printlnError("Error en el caso 1 = 1");
        }
        if (!equals(fromString("12345"), fromString("12345"))) {
            printlnError("Error en el caso 12345 = 12345");
        }
        printlnOk("Final de las pruebas de equals");
    }

    private boolean checkAdd(String number1, String number2, String result) {
        return Arrays.equals(add(fromString(number1), fromString(number2)), fromString(result));
    }

    private void testAdd() {
        printlnInfo("Inicio de las pruebas de add");
        if (!checkAdd("1", "1", "2")) {
            printlnError("Error en la suma 1 + 1 = 2");
        }
        if (!checkAdd("5", "5", "10")) {
            printlnError("Error en la suma 5 + 5 = 10");
        }
        if (!checkAdd("99", "999", "1098")) {
            printlnError("Error en la suma 99 + 999 = 1098");
        }
        if (!checkAdd("999", "99", "1098")) {
            printlnError("Error en la suma 999 + 99 = 1098");
        }
        if (!checkAdd("5", "0", "5")) {
            printlnError("Error en la suma 5 + 0 = 5");
        }
        printlnOk("Final de las pruebas de add");
    }

    private boolean checkShiftLeft(String number, int exponent, String result) {
        return Arrays.equals(shiftLeft(fromString(number), exponent), fromString(result));
    }

    private void testShiftLeft() {
        printlnInfo("Inicio de las pruebas de shiftLeft");
        if (!checkShiftLeft("54", 1, "540")) {
            printlnError("Error en 54 1 posición a la izquierda = 540");
        }
        if (!checkShiftLeft("54", 3, "54000")) {
            printlnError("Error en 54 3 posiciones a la izquierda = 54000");
        }
        if (!checkShiftLeft("0", 3, "0")) {
            printlnError("Error en 0 3 posiciones a la izquierda = 0");
        }
        printlnOk("Final de las pruebas de shiftLeft");
    }

    private boolean checkMultByDigit(String number, int digit, String result) {
        return Arrays.equals(multiplyByDigit(fromString(number), digit), fromString(result));
    }

    private void testMultiplyByDigit() {
        printlnInfo("Inicio de las pruebas de multiplyByDigit");
        if (!checkMultByDigit("24", 2, "48")) {
            printlnError("Error en 24 * 2 = 48");
        }
        if (!checkMultByDigit("54", 3, "162")) {
            printlnError("Error en 54 * 3 = 162");
        }
        if (!checkMultByDigit("0", 3, "0")) {
            printlnError("Error en 0 * 3 = 0");
        }
        if (!checkMultByDigit("24", 0, "0")) {
            printlnError("Error en 24 * 0 = 0");
        }
        printlnOk("Final de las pruebas de multiplyByDigit");
    }

    // multiply

    private boolean checkMultiply(String number1, String number2, String result) {
        return Arrays.equals(multiply(fromString(number1), fromString(number2)), fromString(result));
    }

    private void testMultiply() {
        printlnInfo("Inicio de las pruebas de multiply");
        if (!checkMultiply("2", "3", "6")) {
            printlnError("Error en 2 * 3 = 6");
        }
        if (!checkMultiply("999", "888", "887112")) {
            printlnError("Error en 999 * 888 = 887112");
        }
        if (!checkMultiply("10", "5", "50")) {
            printlnError("Error en 10 * 50 = 50");
        }
        if (!checkMultiply("12", "555443535", "6665322420")) {
            printlnError("Error en 12 * 555443535 = 6665322420");
        }
        if (!checkMultiply("555443535", "12", "6665322420")) {
            printlnError("Error en 555443535 * 12 = 6665322420");
        }
        if (!checkMultiply("999", "10", "9990")) {
            printlnError("Error en 99 * 10 = 90");
        }
        if (!checkMultiply("100", "5", "500")) {
            printlnError("Error en 10 * 50 = 50");
        }
        if (!checkMultiply("5", "17", "85")) {
            printlnError("Error en 5 * 17 = 85");
        }
        if (!checkMultiply("24", "5", "120")) {
            printlnError("Error en 24 * 5 = 120");
        }
        if (!checkMultiply("0", "888", "0")) {
            printlnError("Error en 0 * 888 = 0");
        }
        if (!checkMultiply("20397882081197443358640281739902897356800000000", "40", "815915283247897734345611269596115894272000000000")) {
            printlnError("Error en último producto de 40!");
        }
        if (!checkMultiply("815915283247897734345611269596115894272000000000", "41", "33452526613163807108170062053440751665152000000000")) {
            printlnError("Error en último producto de 41!");
        }
        printlnOk("Final de las pruebas de multiply");
    }


    // factorial

    private boolean checkFactorial(String number, String result) {
        return Arrays.equals(factorial(fromString(number)), fromString(result));
    }

    private void testFactorial() {
        printlnInfo("Inicio de las pruebas de factorial");
        if (!checkFactorial("5", "120")) {
            printlnError("Error en 5! = 120");
        }
        if (!checkFactorial("0", "1")) {
            printlnError("Error en 0! = 1");
        }
        if (!checkFactorial("1", "1")) {
            printlnError("Error en 1! = 1");
        }
        if (!checkFactorial("6", "720")) {
            printlnError("Error en 6! = 720");
        }
        if (!checkFactorial("7", "5040")) {
            printlnError("Error en 7! = 5040");
        }
        if (!checkFactorial("8", "40320")) {
            printlnError("Error en 8! = 720");
        }
        if (!checkFactorial("9", "362880")) {
            printlnError("Error en 9! = 720");
        }
        if (!checkFactorial("11", "39916800")) {
            printlnError("Error en 11! = 720");
        }
        if (!checkFactorial("10", "3628800")) {
            printlnError("Error en 10! = 3628800");
        }
        if (!checkFactorial("15", "1307674368000")) {
            printlnError("Error en 15! = 1307674368000");
        }
        if (!checkFactorial("20", "2432902008176640000")) {
            printlnError("Error en 20! = 2432902008176640000");
        }
        if (!checkFactorial("40", "815915283247897734345611269596115894272000000000")) {
            printlnError("40! ---------> " + asString(factorial(fromString("40"))));
            printlnError("Error en 40! = 815915283247897734345611269596115894272000000000");
        }
        if (!checkFactorial("41", "33452526613163807108170062053440751665152000000000")) {
            printlnError("41! ---------> " + asString(factorial(fromString("41"))));
            printlnError("Error en 41! = 33452526613163807108170062053440751665152000000000");
        }
        if (!checkFactorial("42", "1405006117752879898543142606244511569936384000000000")) {
            printlnError("42! ---------> " + asString(factorial(fromString("42"))));
            printlnError("Error en 42! = 1405006117752879898543142606244511569936384000000000");
        }
        printlnOk("Final de las pruebas de factorial");
    }

    private boolean checkFibonacci(String number, String result) {
        return Arrays.equals(fibonacci(fromString(number)), fromString(result));
    }

    private void testFibonacci() {
        printlnInfo("Inicio de las pruebas del fibonacci");
        if (!checkFibonacci("0", "0")) {
            printlnError("Error en fibonacci(0) != 0");
        }
        if (!checkFibonacci("1", "1")) {
            printlnError("Error en fibonacci(1) != 1");
        }
        if (!checkFibonacci("2", "1")) {
            printlnError("Error en fibonacci(2) != 1");
        }
        if (!checkFibonacci("3", "2")) {
            printlnError("Error en fibonacci(3) != 2");
        }
        if (!checkFibonacci("4", "3")) {
            printlnError("Error en fibonacci(4) != 3");
        }
        if (!checkFibonacci("10", "55")) {
            printlnError("Error en fibonacci(10) != 55");
        }
        if (!checkFibonacci("20", "6765")) {
            printlnError("Error en fibonacci(20) != 6765");
        }
        if (!checkFibonacci("30", "832040")) {
            printlnError("Error en fibonacci(30) != 832040");
        }
        if (!checkFibonacci("40", "102334155")) {
            printlnError("Error en fibonacci(40) != 102334155");
        }
        if (!checkFibonacci("50", "12586269025")) {
            printlnError("Error en fibonacci(60) != 12586269025");
        }
        if (!checkFibonacci("100", "354224848179261915075")) {
            printlnError("Error en fibonacci(100) != 354224848179261915075");
        }
        if (!checkFibonacci("200", "280571172992510140037611932413038677189525")) {
            printlnError("Error en fibonacci(200) != 280571172992510140037611932413038677189525");
        }
        printlnOk("Final de las pruebas del fibonacci");
    }

    // Colorize output for CommandLineProgram

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public void printlnInfo(String message) {
        if (acm.program.CommandLineProgram.class.isInstance(this)) println(ANSI_BLUE + message + ANSI_RESET);
        else println(message);
    }

    public void printlnOk(String message) {
        if (acm.program.CommandLineProgram.class.isInstance(this)) println(ANSI_GREEN + "OK: " + message + ANSI_RESET);
        else println("OK: " + message);
    }

    public void printlnError(String message) {
        if (acm.program.CommandLineProgram.class.isInstance(this)) println(ANSI_RED + "ERROR: " + message + ANSI_RESET);
        else println("ERROR: " + message);
    }

    public void printBar() {
        println("--------------------------------------------------");
    }
}
