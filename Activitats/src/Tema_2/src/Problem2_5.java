package Tema_2.src;

import acm.program.CommandLineProgram;

import java.util.StringTokenizer;

public class Problem2_5 extends CommandLineProgram {

    public void run() {
        test1();
        test2();
        test3();
        printBar();
    }

    public static final String DELIMITERS = " ,.;:123456789";

    public String makeAcronym(String line) {
        if (line.length() == 0) {
            return line;
        }

        StringTokenizer st = new StringTokenizer(line, DELIMITERS);
        String acronym = "";

        while (st.hasMoreTokens()) {
            String word = st.nextToken();

            if (!isExcluded(word)) {
                acronym += Character.toUpperCase(word.charAt(0)) + ".";
            }
        }

        return acronym;
    }

    private boolean isExcluded(String word) {
        String[] excludedWords = {"el", "la", "un", "una", "unos", "unas", "los", "las", "y", "o", "de"};
        for (int i = 0; i < excludedWords.length; i++) {
            if (word.equals(excludedWords[i])) {
                return true;
            }
        }
        return false;
    }

    public void test1() {
        printBar();
        String str = "Escuela Politécnica Superior”";
        String resultStr = "E.P.S.";
        if (resultStr.equals(makeAcronym(str))) {
            println("Test 1 passed");
        } else {
            println("Test 1 didn't pass");
        }
    }

    public void test2() {
        printBar();
        String str = "National Basketball Association";
        String resultStr = "N.B.A.";
        if (resultStr.equals(makeAcronym(str))) {
            println("Test 2 passed");
        } else {
            println("Test 2 didn't pass");
        }
    }

    public void test3() {
        printBar();
        String str = "Estados Unidos de América";
        String resultStr = "E.U.A.";
        if (resultStr.equals(makeAcronym(str))) {
            println("Test 3 passed");
        } else {
            println("Test 3 didn't pass");
        }
    }

    public void printBar() {
        println("────────────────────────────────────────────");
    }

    public static void main(String[] args) {
        new Problem2_5().start(args);
    }
}