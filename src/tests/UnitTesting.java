package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyClass {

	
	@Test
	public void test_01() {
		
		//assertThrows()
		assertThrows(IllegalArgumentException.class,() ->{
			CompressString.compress("");
			
		});
	}
	@Test
	public void test_02() {
		
		assertEquals("a2b",CompressString.compress("aab"));
		
	}
	@Test
	public void test_03() {
		
		assertEquals("ab",CompressString.compress("ab"));
		
	}
	@Test
	public void test_04() {
		
		assertEquals("abc",CompressString.compress("abc"));
		
	}
	@Test
	public void test_05() {
		
		assertEquals("abc2",CompressString.compress("abcc"));
		
	}

}