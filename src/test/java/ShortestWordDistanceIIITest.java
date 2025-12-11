import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortestWordDistanceIIITest {
    @Test
    void testDifferentWordsAdjacent() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        assertEquals(1, ShortestWordDistanceIII.findShortestDistance(words, "makes", "coding"));
    }

    @Test
    void testDifferentWordsNotAdjacent() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        assertEquals(3, ShortestWordDistanceIII.findShortestDistance(words, "practice", "coding"));
    }

    @Test
    void testSameWords() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        assertEquals(3, ShortestWordDistanceIII.findShortestDistance(words, "makes", "makes"));
    }

    @Test
    void testWord1BeforeWord2() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        assertEquals(1, ShortestWordDistanceIII.findShortestDistance(words, "makes", "perfect"));
    }

    @Test
    void testWord2BeforeWord1() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        assertEquals(1, ShortestWordDistanceIII.findShortestDistance(words, "perfect", "makes"));
    }
}
