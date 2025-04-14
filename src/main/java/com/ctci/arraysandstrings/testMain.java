package com.ctci.arraysandstrings;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class testMain {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestIsUnique.class);
		for (Failure failure: result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}