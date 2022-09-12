package recursion;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.annotation.processing.Generated;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class RecursiveDigitSumTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	@Test
	public void testSuperDigitWithNull() throws Exception {
		// TC1
		int k = 0;
		String n = null;
		String expected = "by input exception [" + n + "]";
		Exception result = assertThrows(Exception.class, 
				() -> RecursiveDigitSum.superDigit(n, k));
		
		Assert.assertEquals(expected, result.getMessage());
	}

	@Test
	public void testSuperDigitWithEmpty() throws Exception {
		// TC2
		int k = 1;
		String n = "";
		int expected = 0;
		int result = RecursiveDigitSum.superDigit(n, k);
		
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSuperDigitWithNegative1() throws Exception {
		// TC3
		int k = -1;
		String n = "1";
		String expected = "by input exception [" + k + "]";
		Exception result = assertThrows(Exception.class, 
				() -> RecursiveDigitSum.superDigit(n, k));
		
		Assert.assertEquals(expected, result.getMessage());
	}

	@Test
	public void testSuperDigit1() throws Exception {
		// TC4
		int k = 0;
		String n = "1";
		int expected = 1;
		int result = RecursiveDigitSum.superDigit(n, k);
		
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSuperDigitMax1() throws Exception {
		// TC5
		int k = 999999999;
		String n = "1";
		int expected = 9;
		int result = RecursiveDigitSum.superDigit(n, k);
		
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSuperDigit3() throws Exception {
		// TC6
		int k = 0;
		String n = "12";
		int expected = 3;
		int result = RecursiveDigitSum.superDigit(n, k);
		
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSuperDigit4() throws Exception {
		// TC7
		int k = 1;
		String n = "12";
		int expected = 3;
		int result = RecursiveDigitSum.superDigit(n, k);
		
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSuperDigitMax2() throws Exception {
		// TC8
		int k = 1;
		String n = "999999999";
		int expected = 9;
		int result = RecursiveDigitSum.superDigit(n, k);
		
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSuperDigitWithNegative2() throws Exception {
		// TC9
		int k = 1;
		String n = "-a";
		String expected = "by input exception [" + n + "]";
		Exception result = assertThrows(Exception.class, 
				() -> RecursiveDigitSum.superDigit(n, k));
		
		Assert.assertEquals(expected, result.getMessage());
	}

}