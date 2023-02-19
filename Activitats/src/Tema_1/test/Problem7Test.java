import Tema_1.src.Problem7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void test1() {
        Problem7 problem7 = new Problem7();
        String str = "hola que tal";
        String strResult = "holaquetal";
        assertEquals(strResult, problem7.removeSpaces(str));
        problem7.printString(strResult, 1);
    }

    @Test
    void test2() {
        Problem7 problem7 = new Problem7();
        String str = "     test string ";
        String strResult = "teststring";
        assertEquals(strResult, problem7.removeSpaces(str));
        problem7.printString(strResult, 2);
    }

    @Test
    void test3() {
        Problem7 problem7 = new Problem7();
        String str = " ";
        String strResult = "";
        assertEquals(strResult, problem7.removeSpaces(str));
        problem7.printString(strResult, 3);
    }


}