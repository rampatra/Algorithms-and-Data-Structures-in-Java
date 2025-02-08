package com.rampatra.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestStringToInteger {
	//It assumes the {@code string} contains ASCII characters only.
	
	@Test
	public static void AllTestCases() {
		//Empty cases
		String test1 = "";
		int retVal = -1;
		//In this case, we're expected to be thrown the numberFormatException
		try {
			retVal = StringToInteger.getIntegerFromString(test1);
		}catch (NumberFormatException e) {
			System.out.println("Exception case for \" Empty cases \" executed successfully.");
		}finally {
			System.out.println("End exception case. Return value: " + retVal);
		}
		
			
		//Positive number
		String test2 = "2147483647";
		retVal = Integer.MAX_VALUE;
		
		assertEquals(StringToInteger.getIntegerFromString(test2), retVal);
		
		//Negative number
		String test3 = "-2147483648";
		retVal = Integer.MIN_VALUE;
				
		assertEquals(retVal, StringToInteger.getIntegerFromString(test3));
		
		//Zero leading 
		String test4 = "00000000000000000000000123123123";
		retVal = 123123123;
		
		assertEquals(StringToInteger.getIntegerFromString(test4), retVal);
		
		
		//Zero leading and minus sign
		String test5 = "00000-213";
		retVal = 0;
		
		//In this case, we're expected to be thrown the numberFormatException
		try {
			retVal = StringToInteger.getIntegerFromString(test5);
		}catch (NumberFormatException e) {
			System.out.println("Exception case for \" Zero leading and minus sign \" executed successfully.");
		}finally {
			System.out.println("End exception case. Return value: " + retVal);
		}
		
		
		//Ascii string
		String test6 = "QWERTYUIOPASDFGHJKLZXCVBNM 1234567890 qwertyuiopasdfghjklzxcvbnm -=+!@#$%^&*() >:{ }|\\\\]";
			
		//In this case, we're expected to be thrown the numberFormatException
		try {
			retVal = StringToInteger.getIntegerFromString(test6);
		}catch (NumberFormatException e) {
			System.out.println("Exception case for \" Ascii string \" executed successfully.");
		}finally {
			System.out.println("End exception case. Return value: " + retVal);
		}
		
		
		//Trailing ASCII character, positive value
		String test7 = "123AAABBB";
		retVal = 123;
				
		//In this case, we're expected to be thrown the numberFormatException
		try {
			retVal = StringToInteger.getIntegerFromString(test7);
		}catch (NumberFormatException e) {
			System.out.println("Exception case for \" Trailing ASCII character, positive value \" executed successfully.");
		}finally {
			System.out.println("End exception case. Return value: " + retVal);
		}
		
		
		//Trailing ASCII character, negative value
		String test8 = "-123AAABBB";
		retVal = 123;
				
		//In this case, we're expected to be thrown the numberFormatException
		try {
			retVal = StringToInteger.getIntegerFromString(test8);
		}catch (NumberFormatException e) {
			System.out.println("Exception case for \" Trailing ASCII character, negative value \" executed successfully.");
		}finally {
			System.out.println("End exception case. Return value: " + retVal);
		}

				
	}
	
    public static void main(String[] args) {
    	AllTestCases();
    }
}
