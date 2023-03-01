package src;

import acm.program.CommandLineProgram;

public class Problem2_3 extends CommandLineProgram {

    public void run() {
        printBar();
        test1();
        test2();
        test3();
        test4();
        printBar();
    }

    public String encodeCesar(String message, int distance) {
        int[] messageInt = new int[message.length()];
        char[] messageCharArr = message.toCharArray();
        char[] result = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            messageInt[i] = messageCharArr[i];
            if (Character.isLetter(messageInt[i])) {
                messageInt[i] += distance;
            }
            result[i] = Character.toChars(messageInt[i])[0];
        }
        return String.valueOf(result);
    }

    public void test1() {
        String str = "ABC";
        int distance = 2;
        String resultStr = "CDE";
        println("Original string: |" + str + "| Distance: " + distance);
        println("Result string: |" + encodeCesar(str, distance) + "|");
        if (resultStr.equals(encodeCesar(str, distance))) {
            println("Test 1 passed");
        } else {
            println("Test 1 didn't pass");
        }
    }

    public void test2() {
        printBar();
        String str = "b";
        int distance = -1;
        String resultStr = "a";
        println("Original string: |" + str + "| Distance: " + distance);
        println("Result string: |" + encodeCesar(str, distance) + "|");
        if (resultStr.equals(encodeCesar(str, distance))) {
            println("Test 2 passed");
        } else {
            println("Test 2 didn't pass");
        }
    }

    public void test3() {
        printBar();
        String str = "AB$C";
        int distance = 2;
        String resultStr = "CD$E";
        println("Original string: |" + str + "| Distance: " + distance);
        println("Result string: |" + encodeCesar(str, distance) + "|");
        if (resultStr.equals(encodeCesar(str, distance))) {
            println("Test 3 passed");
        } else {
            println("Test 3 didn't pass");
        }
    }

    public void test4() {
        printBar();
        String str = "ABC ";
        int distance = 2;
        String resultStr = "CDE ";
        println("Original string: |" + str + "| Distance: " + distance);
        println("Result string: |" + encodeCesar(str, distance) + "|");
        if (resultStr.equals(encodeCesar(str, distance))) {
            println("Test 4 passed");
        } else {
            println("Test 4 didn't pass");
        }
    }

    public void printBar() {
        println("———————————————————————————————————————");
    }

    public static void main(String[] args) {
        new Problem2_3().start(args);
    }
}