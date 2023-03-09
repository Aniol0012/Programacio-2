package Tema_2.src;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class Problem2_4 extends CommandLineProgram {

    public void run() {
        test1();
        test2();
        test3();
        test4();
        test5();
        printBar();
    }

    public static final String DELIMITERS = " ,.;:123456789";

    public String longestWord(String line) {
        if (line.length() == 0) {
            return line;
        }

        int maxLength = 0;
        String longestWord = "";
        StringTokenizer st = new StringTokenizer(line, DELIMITERS);

        while (st.hasMoreTokens()) {
            String word = st.nextToken();

            if (word.length() >= maxLength) { // If the length of the words is equal, it returns the last one
                maxLength = word.length();
                longestWord = word;
            }
        }
        return longestWord;
    }

    public void test1() {
        printBar();
        String str = "hey, how are you today";
        String resultStr = "today";
        if (resultStr.equals(longestWord(str))) {
            println("Test 1 passed");
        } else {
            println("Test 1 didn't pass");
        }
    }

    public void test2() {
        printBar();
        String str = "The quick brown fox jumps over the lazy dog";
        String resultStr = "jumps";
        if (resultStr.equals(longestWord(str))) {
            println("Test 2 passed");
        } else {
            println("Test 2 didn't pass");
        }
    }

    public void test3() {
        printBar();
        String str = "This is a test string";
        String resultStr = "string";
        if (resultStr.equals(longestWord(str))) {
            println("Test 3 passed");
        } else {
            println("Test 3 didn't pass");
        }
    }

    public void test4() {
        printBar();
        String str = "Testing 123,testinglong 123";
        String resultStr = "testinglong";
        if (resultStr.equals(longestWord(str))) {
            println("Test 4 passed");
        } else {
            println("Test 4 didn't pass");
        }
    }

    public void test5() {
        printBar();
        String str = "";
        String resultStr = "";
        if (resultStr.equals(longestWord(str))) {
            println("Test 5 passed");
        } else {
            println("Test 5 didn't pass");
        }
    }

    public void printBar() {
        println("────────────────────────────────────────────");
    }

    public static void main(String[] args) {
        new Problem2_4().start(args);
    }
}