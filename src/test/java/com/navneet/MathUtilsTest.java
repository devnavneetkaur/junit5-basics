package com.navneet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {

		MathUtils mathUtils = new MathUtils();
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual, "should return the addition of two numbers");
	}

	@Test
	void computeAreaOfCircle() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeAreaOfCircle(10), "should return the right area of circle");
	}

	@Test
	void testDivide() {

		MathUtils mathUtils = new MathUtils();
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw exception");
	}
	
}
