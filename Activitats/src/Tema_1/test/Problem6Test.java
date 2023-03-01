package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {
    @Test
    void test1() {
        Problem6 problem6 = new Problem6();
        String str = "hola";
        String strResult = "ola";
        assertEquals(strResult, problem6.removeExtrems(str));
        problem6.printString(strResult, 1);
    }

    @Test
    void test2() {
        Problem6 problem6 = new Problem6();
        String str = "hola que tal";
        String strResult = "ola que tal";
        assertEquals(strResult, problem6.removeExtrems(str));
        problem6.printString(strResult, 2);
    }

    @Test
    void test3() {
        Problem6 problem6 = new Problem6();
        String str = "do";
        String strResult = "";
        assertEquals(strResult, problem6.removeExtrems(str));
        problem6.printString(strResult, 3);
    }
}