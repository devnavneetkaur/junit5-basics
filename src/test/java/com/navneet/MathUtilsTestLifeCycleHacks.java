package com.navneet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default behaviour
class MathUtilsTestLifeCycleHacks {

	MathUtils mathUtils;

	@BeforeAll
	static void beforeallinit() {
		System.out.println("This needs to be run before all");
	}

	/*
	 * in case of PER_CLASS, no need to make method static, because test instance
	 * will be created only once
	 * 
	 * @BeforeAll void beforeallinit() {
	 * System.out.println("This needs to be run before all"); }
	 */

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Cleaning up....");
	}

	@Test
	@DisplayName("Testing add method")
	void testAdd() {

		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual, "should return the addition of two numbers");
	}

	@Test
	@EnabledOnOs(OS.WINDOWS)
	void computeAreaOfCircle() {

		assertEquals(314.1592653589793, mathUtils.computeAreaOfCircle(10), "should return the right area of circle");
	}

	@Test
	void testDivide() {

		boolean isServerUp = true;
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw exception");
	}

	@Test
	@Disabled
	@DisplayName("TDD mathod.. should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}

	@Test
	@DisplayName("Test multiply method")
	void testmultiply() {
		assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2)), () -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1)));

	}
}
