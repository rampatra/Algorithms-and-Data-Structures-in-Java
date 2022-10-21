package palimdromeIndex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeIndexTest {

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

		PalindromeIndex.isPalindrome(null);

	}

	@Test
	public void emptyStringTest() throws Exception {

		input = "";

		assertTrue(PalindromeIndex.isPalindrome(input));

	}

	@Test
	public void singleCharTest() throws Exception {

		input = "H";

		assertTrue(PalindromeIndex.isPalindrome(input));

	}

	@Test
	public void alphaNumericPalindromeTest() throws Exception {

		input = "1234321";

		assertTrue(PalindromeIndex.isPalindrome(input));
	}

	@Test
	public void validPalindromeTest() throws Exception {

		input = "madam";

		assertTrue(PalindromeIndex.isPalindrome(input));
	}

	@Test
	public void invalidWordPalindromeTest() throws Exception {

		input = "rotators";

		assertFalse(PalindromeIndex.isPalindrome(input));
	}

	@Test
	public void invalidPalindromeTest() throws Exception {

		input = "I am a tester";

		assertFalse(PalindromeIndex.isPalindrome(input));
	}
}