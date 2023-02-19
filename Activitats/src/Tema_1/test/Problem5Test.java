import Tema_1.src.Problem5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {
@Test
void test1 () { // Array regular
	Problem5 problem5 = new Problem5();
	int[][] left = {{2, 3}, {4, 5}};
	int[][] right = {{1, 0}, {0, 1}};
	int[][] result = {{2, 3}, {4, 5}};
	assertArrayEquals(result, problem5.matrixMultiplication(left, right));
}
@Test
void test2 () { // Array amb negatius
	Problem5 problem5 = new Problem5();
	int[][] left = {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
	int[][] right = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
	int[][] result = {{-2, -5, -2}, {-5, -14, -5}, {-8, -23, -8}};;
	assertArrayEquals(result, problem5.matrixMultiplication(left, right));
}

@Test
void test3 () { // Array irregular
	Problem5 problem5 = new Problem5();
	int[][] left = {{1, 2, 3}, {4, 5, 6}};
	int[][] right = {{1}, {2}};
	assertNull(problem5.matrixMultiplication(left, right));
}

@Test
void test4() { // Array buida
	Problem5 problem5 = new Problem5();
	int[][] emptyMatrix = new int[][] {};
	assertArrayEquals(emptyMatrix,problem5.matrixMultiplication(emptyMatrix,emptyMatrix));
}
}