import com.rampatra.arrays.CelebrityProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CelebrityProblemTest {
    @Test
    public void testThereNoPerson() {
        int[][] peoples = new int[][]{};
        Assertions.assertEquals(-1, CelebrityProblem.findCelebrity(peoples));
    }
    @Test
    public void testThereOnlyOnePerson() {
        int[][] peoples = new int[][]{{0}};
        Assertions.assertEquals(-1, CelebrityProblem.findCelebrity(peoples));
    }
    @Test
    public void testNoCelebrity() {
        int[][] peoples = new int[][]{{0, 1, 1, 0},{0, 0, 1, 0},{0, 0, 0, 1},{0, 0, 1, 0}};
        Assertions.assertEquals(-1, CelebrityProblem.findCelebrity(peoples));
    }
    @Test
    public void testCelebrityAtPosition0() {
        int[][] peoples = new int[][]{{0, 0, 0, 0},{1, 0, 1, 0},{1, 0, 0, 1},{1, 0, 1, 0}};
        Assertions.assertEquals(0, CelebrityProblem.findCelebrity(peoples));
    }
    @Test
    public void testCelebrityAtPosition1() {
        int[][] peoples = new int[][]{{0, 1, 1, 0},{0, 0, 0, 0},{0, 1, 0, 0},{0, 1, 1, 0}};
        Assertions.assertEquals(1, CelebrityProblem.findCelebrity(peoples));
    }
    @Test
    public void testCelebrityAtPosition2() {
        int[][] peoples = new int[][]{{0, 1, 1, 0},{0, 0, 1, 0},{0, 0, 0, 0},{0, 1, 1, 0}};
        Assertions.assertEquals(2, CelebrityProblem.findCelebrity(peoples));
    }
    @Test
    public void testCelebrityAtPosition3() {
        int[][] peoples = new int[][]{{0, 0, 1, 1},{0, 0, 1, 1},{1, 0, 0, 1},{0, 0, 0, 0}};
        Assertions.assertEquals(3, CelebrityProblem.findCelebrity(peoples));
    }
}