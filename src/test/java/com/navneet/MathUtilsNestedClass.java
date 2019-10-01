package com.navneet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

@DisplayName("When running MathUtilsNestedClass")
class MathUtilsNestedClass {

	MathUtils mathUtils;

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@Nested
	@DisplayName("add method")
	class AddTest {
		@Test
		@DisplayName("When adding the two positive numbers")
		void testAddPositive() {

			assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
		}

		@Test
		@DisplayName("When adding the two positive numbers")
		void testAddNegitive() {

			int expected = 2;
			int actual = mathUtils.add(1, 1);
			assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);
		}
	}

	//@Test
	@RepeatedTest(3)
	void computeAreaOfCircle(RepetitionInfo repetitionInfo) {
		System.out.println("Current repetition...." + repetitionInfo.getTotalRepetitions());

		assertEquals(314.1592653589793, mathUtils.computeAreaOfCircle(10), "should return the right area of circle");
	}
}
