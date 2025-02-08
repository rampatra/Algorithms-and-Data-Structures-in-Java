import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void getTime () {
        Main main = new Main();
        String actualResult = main.getTime();
        String expectedResult = "twenty minutes past four";
        Assertions.assertEquals(expectedResult, actualResult);
    }

}