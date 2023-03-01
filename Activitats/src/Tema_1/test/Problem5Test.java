package test;

import org.junit.jupiter.api.Test;
import src.Problem5;

import static org.junit.Assert.assertArrayEquals;

class Problem5Test {
    @Test
    void test1() { // Array regular
        Problem5 problem5 = new Problem5();
        int[][] left = {{24, 54}, {21, 56}};
        int[][] right = {{47, 94}, {68, 34}};
        int[][] result = {{4800, 4092}, {4795, 3878}};
        assertArrayEquals(result, problem5.matrixMultiplication(left, right));
        problem5.printMatrix(result, 1);

    }

    @Test
    void test2() { // Array amb negatius
        Problem5 problem5 = new Problem5();
        int[][] left = {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
        int[][] right = {{510, 213, 4}, {-5, 56, 321}, {21, 54, 396}};
        int[][] result = {{-563, -487, -1834}, {-2141, -1456, -3997}, {-3719, -2425, -6160}};
        assertArrayEquals(result, problem5.matrixMultiplication(left, right));
        problem5.printMatrix(result, 2);
    }

    @Test
    void test3() { // Array irregular
        Problem5 problem5 = new Problem5();
        int[][] left = {{12, 36, 43}};
        int[][] right = {{1, 6}, {41, 41}, {5, 34}};
        int[][] result = {{1703, 3010}};
        assertArrayEquals(result, problem5.matrixMultiplication(left, right));
        problem5.printMatrix(result, 3);
    }

    @Test
    void test4() { // Array buida
        Problem5 problem5 = new Problem5();
        int[][] emptyMatrix = {{}};
        assertArrayEquals(emptyMatrix, problem5.matrixMultiplication(emptyMatrix, emptyMatrix));
        problem5.printMatrix(emptyMatrix, 2);
    }

}