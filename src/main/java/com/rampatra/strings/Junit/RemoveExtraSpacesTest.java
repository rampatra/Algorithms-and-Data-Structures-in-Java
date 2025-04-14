import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveExtraSpacesTest {

    String stringTest1 = "Test with no extra space";
    String stringTest2 = "Test with extra   space";
    String stringTest3 = "  Test with extra space at the beginning";
    String stringTest4 = "Test with extra space at the end    ";

    @Test
    public void RemoveSpaceWithNoExtraSpace () {
        String expectedResult = "Test with no extra space";
        String actualResult = Main.removeExtraSpaces(stringTest1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void RemoveSpaceWithExtraSpace () {
        String expectedResult = "Test with extra space";
        String actualResult = Main.removeExtraSpaces(stringTest2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void RemoveSpaceWithSpaceAtBeginning () {
        String expectedResult = "Test with extra space at the beginning";
        String actualResult = Main.removeExtraSpaces(stringTest3);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void RemoveSpaceWithSpaceAtEnd () {
        String expectedResult = "Test with extra space at the end";
        String actualResult = Main.removeExtraSpaces(stringTest4);
        assertEquals(expectedResult, actualResult);
    }
}