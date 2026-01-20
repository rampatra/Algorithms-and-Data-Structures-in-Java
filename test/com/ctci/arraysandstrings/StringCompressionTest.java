package com.ctci.arraysandstrings;

import org.junit.Before;
import org.junit.Test;

public class StringCompressionTest {
	public static String str1;

	public static String str2;

	public static String str3;

	@Before
	public void setup() {
		str1 = "aaabbccaaaaa";
		str2 = "adddcc2";
		str3 = "";
	}

	@Test
	public void testCompressStr() {
		System.out.println(str1 + ": " + StringCompression.compressString(str1));
		System.out.println(str2 + ": " + StringCompression.compressString(str2));
		System.out.println(str3 + ": " + StringCompression.compressString(str3));
	}
}