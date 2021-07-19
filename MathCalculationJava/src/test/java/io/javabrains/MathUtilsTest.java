/**
* The MathUtilsTest program to test all the math methods from MathUtils class
* Each method tested with different set of values
* Parameterized test also implemented for some method
* 
* @author  Biyas Banerjee
* @version 1.0
* @since   2021-07-19 
*/

package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;

import javax.activity.InvalidActivityException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
//--------------------------------------------------------------

@DisplayName("Testing Math methods when running MathUtils")

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class MathUtilsTest {	
	//initialize MathUtils class
	MathUtils  mu ;
	
	//initialize the object for TestInfo and TestReport
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This method needs to be run before all test cases..");
	}
	
	//below annotation to initialize the object at the beginning of the tests. so we can avoid creating instance before each test case.
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
	    this.testInfo = testInfo;
	    this.testReporter= testReporter;
		mu = new MathUtils();
		
		//below lines will display the report of each test case before it execute
		testReporter.publishEntry("Running: " + testInfo.getDisplayName() + " with Tags: "+ testInfo.getTags());

	}
	
	//below annotation is to clean after each test case runs
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up ...");
	}
	
	// -----------------------------------ADDITION TEST----------------------------------------------
	@Nested
	@DisplayName("Add test methods")
	class AddTests{		
		@Test
		@DisplayName("Testing add method with positive numbers")
		@Tag("Math")
		void AddTestWithPositiveNumbers() {
			int expected=7;
			int actual= mu.addition(3,4);
			assertEquals(expected,actual, ()-> "Test should return the sum of two numbers.");
		}
		
		@Test
		@DisplayName("Testing add method with negative numbers")
		@Tag("Math")
		void AddTestWithNegativeNumbers() {
			int expected=-7;
			int actual= mu.addition(-3,-4);
			assertEquals(expected,actual, ()-> "Test should return the sum of two numbers.");
		}
	}

	// -----------------------------------SUBTRACTION TEST----------------------------------------------
	//prepare test data
	public static Collection subtractTestData() {
		return Arrays.asList(new Object[][] {{ 7, 8, -1 }, { 20, 31, -11 }, { 9, 1, 8 },{5,-1,6}, {9,-4,13} });
	}
	
	@ParameterizedTest(name= "{index} :subtractionTest({0},{1}) = {2}")
	@Tag("Math")
	@DisplayName("Testing Subtract method")
	@MethodSource("subtractTestData")
	void subtractionTest(int v1, int v2, int expected) {
		assertEquals(expected,mu.subtraction(v1, v2), ()-> "Test should return the difference of two numbers.");
	}
	
	
	// for the below method assumeTrue method used when test will not run if the environment is not available
	// like if the server is down in that scenario below test will skipped
	@Test
	@Tag("Math")
	@DisplayName("Testing Subtract method with negative numbers")
	void subtractionTest2() {
		boolean isServerUp= true;
		assumeTrue(isServerUp);
		int expected= -8;
		int actual= mu.subtraction(-20, -12);
		assertEquals(expected,actual, ()-> "Test should return the difference of two numbers.");
	}
	
	// -----------------------------------PRODUCT TEST----------------------------------------------
	@Test
	@Tag("Math")
	@DisplayName("Testing product method")
	void productTest() {
		int expected=30;
		int actual= mu.product(5, 6);
		assertEquals(expected,actual, ()-> "Test should return the product of two numbers.");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("Testing product method with different values")
	void productTestALl() {
		// Below line give the information about the test method on console while running
		System.out.println("Running " + testInfo.getDisplayName() + " with Tags "+ testInfo.getTags());
		
		//below line give a report of what time the test executed and end what time as a report not in the console
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with Tags "+ testInfo.getTags());
		assertAll(
				()-> assertEquals(20, mu.product(10, 2), ()-> "Test should return the product of two positive numbres"),
				()-> assertEquals(0, mu.product(10, 0), ()-> "Test should return the product of two numbres"),
				()-> assertEquals(20, mu.product(20, 1), ()-> "Test should return the product of two numbres"),
				()-> assertEquals(12, mu.product(-6, -2), ()-> "Test should return the product of two negative numbres"),
				()-> assertEquals(-20, mu.product(-10, 2), ()-> "Test should return the product of two one negative numbres")
				);
	}	
	
	// -----------------------------------DIVISION  TEST----------------------------------------------

	@Test
	@DisplayName("Division by zero")
	@Tag("Math")
    public void testDivideWithZero() {
		assertThrows(ArithmeticException.class, () -> mu.division(1, 0),() -> "Divide should throw ArithmeticException when denominator is zero");
	}
	
	// Test cases for the division of two numbers
	
	//prepare test data
	public static Collection divTestData() {
		return Arrays.asList(new Object[][] { { -9, -3, 3 },
											{ 15, 5, 3 },
											{ -6, 2, -3 },
											{ 2.4, 2, 1.2},
											{ 4.8, 2.4, 2.0},
											{ -9.8, 2, -4.9},
											{ -2.4, -1.2, 2.0}
										});		
	}

	@ParameterizedTest(name = "{index}: testDivide({0}, {1})= {2}")
	@DisplayName("Division method for different types of numbers")
	@MethodSource("divTestData")
	@Tag("Math")
	public void testDivide(double v1, double v2, double exp)throws InvalidActivityException {
		assertEquals(exp, mu.division(v1, v2), () -> "should return the quitient value");
	}
	
	//---------------------------------Test the product of two vectors---------------------------
	//prepare test data
	static java.util.stream.Stream<Arguments> arrayTestData() {
		return java.util.stream.Stream.of(Arguments.of(
						Arrays.asList(2, 4, 1).toArray(), 
						Arrays.asList(1, 2, 3).toArray(),
						Arrays.asList(2, 8, 3).toArray()),
				
						Arguments.of(
						Arrays.asList(0,1,0).toArray(), 
						Arrays.asList(2,0,0).toArray(), 
						Arrays.asList(0,0,0).toArray()),
						
						Arguments.of(
						Arrays.asList(-2,1,10).toArray(), 
						Arrays.asList(3,2,-1).toArray(),
						Arrays.asList(-6,2,-10).toArray())
		);
	}
	
	@ParameterizedTest(name = "{index}: productVectorTest({0}, {1})= {2}")
	@DisplayName("Product of two vectors method using collection of data")
	@MethodSource("arrayTestData")
	public void productVectorTest(Object[] v1, Object[] v2, Object[] exp) {
		assertArrayEquals(testProductVectorHelper(exp), mu.productVector(testProductVectorHelper(v1), testProductVectorHelper(v2)), () -> "should return the product of two vectors");		
	}
	
	public int[] testProductVectorHelper(Object[] v1) {
		int[] arr=new int[v1.length];
		for(int i=0; i<v1.length; i++) {
			arr[i]=(Integer)v1[i];
		}
		return arr;
	}
	
	//---------------------------------SHAPE TEST---------------------------
	@Test
	@Tag("Shape")
	@DisplayName("Testing area of a circle method")
	void computeCircleAreaTest() {
		assertEquals(314.1592653589793,mu.computeCircleArea(10),"Test should return the area of a circle.");
	}
	
	//----------------------Sample example of disable test case---------------------------
	//if we make a test disable test method when it runs
	@Test
	@Disabled
	@DisplayName("TDD method,test should not run")
	void disableTest() {
		fail("This test should fail");
	}

}


//EnableOnOs(OS.LINUX)    --> this annotation only enable the test for Linux OS
// @Tag annotation only runs those tests which are those tag name.
//To apply this right click on the test class-> Run configuration -> 
// Left side RC on Junit test -new configuration -> type a name-> click run
// all test... radio button -> select JUit5 from drop down--> apply
// then click configure button--> click Include Tag radio button--> ok --> run
// Then it will only runs those test cases which that TAG name mentioned