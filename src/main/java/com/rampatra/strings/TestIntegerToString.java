package com.rampatra.strings;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class TestIntegerToString {
	
	@Test
    static void integerCases(){
        //Positive, small number, expected: true
        int a1 = 123; 
        String a2 = "123";

        //Negative, small number, expected: true
        int b1 = -123; 
        String b2 = "-123";
        
        //0, expected: true
        int c1 = 0; 
        String c2 = "0";

        boolean resultA = a2.equals(IntegerToString.getStringFromInteger(a1));
        boolean resultB = b2.equals(IntegerToString.getStringFromInteger(b1));
        boolean resultC = c2.equals(IntegerToString.getStringFromInteger(c1));

        assertTrue(resultA);
        assertTrue(resultB);
        assertTrue(resultB);
    }
	
	@Test
    static void boundaryCases() {
    	//INT_MAX
    	int a1 = Integer.MAX_VALUE;
    	String a2 = "2147483647";
    	
    	//INT_MIN
    	int b1 = Integer.MIN_VALUE;
    	String b2 = "-2147483648";
    	
    	//Trailing zero
    	int c1 = 000000000000;
    	String c2 = "0";
    	
    	boolean resultA = a2.equals(IntegerToString.getStringFromInteger(a1));
        boolean resultB = b2.equals(IntegerToString.getStringFromInteger(b1));
        boolean resultC = c2.equals(IntegerToString.getStringFromInteger(c1));
        
        assertTrue(resultA);
        assertTrue(resultB);
        assertTrue(resultC);
    }

    public static void main(String args[]){
        integerCases();
        boundaryCases();
    }
}