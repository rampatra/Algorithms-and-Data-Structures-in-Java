package sentencePalindrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentencePalindromeTest {

	private String input;

	@Before
	public void setUp() throws Exception {

		input = null;

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test(expected = NullPointerException.class)
	public void nullStringTest() throws Exception {

		SentencePalindrome.isPalindrome(null);
	}

	@Test
	public void emptyStringTest() throws Exception {

		input = "";

		assertTrue(SentencePalindrome.isPalindrome(input));

	}

	@Test
	public void multipleWhiteSpaceTest() throws Exception {

		input = "A   Santa         at Nasa";

		assertTrue(SentencePalindrome.isPalindrome(input));

	}

	@Test
	public void singleCharTest() throws Exception {

		input = "H";

		assertTrue(SentencePalindrome.isPalindrome(input));

	}

	@Test
	public void punctuationTest() throws Exception {

		input = "Eva, can I see bees in a cave?";

		assertTrue(SentencePalindrome.isPalindrome(input));

	}

	@Test
	public void unicodeTest() throws Exception {

		input = "Step on no pet.";

		assertFalse(SentencePalindrome.isPalindrome(input));

	}

	@Test
	public void alphaNumericPalindromeTest() throws Exception {

		input = "Air 2 an a2ria";

		assertTrue(SentencePalindrome.isPalindrome(input));
	}

	@Test
	public void validPalindromeTest() throws Exception {

		input = "No lemon no melon";

		assertTrue(SentencePalindrome.isPalindrome(input));
	}

	@Test
	public void invalidPalindromeTest() throws Exception {

		input = "I am a tester";

		assertFalse(SentencePalindrome.isPalindrome(input));
	}
}
