import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RansomNoteTest {
    @Test
    void testBothEmpty() {
        boolean result = RansomNote.canConstruct("", "");
        assertTrue(result);
    }

    @Test
    void testEmptyMagazine() {
        boolean result = RansomNote.canConstruct("a", "");
        assertFalse(result);
    }

    @Test
    void testEmptyRansomeNote() {
        boolean result = RansomNote.canConstruct("", "abc");
        assertTrue(result);
    }

    @Test
    void testCharCountZero() {
        boolean result = RansomNote.canConstruct("aa", "a");
        assertFalse(result);
    }

    @Test
    void testExtraUnusedChars() {
        boolean result = RansomNote.canConstruct("ab", "abcdxyz");
        assertTrue(result);
    }

    @Test
    void testMissingOneChar() {
        boolean result = RansomNote.canConstruct("abcdxyz", "bcdxyz");
        assertFalse(result);
    }
}
