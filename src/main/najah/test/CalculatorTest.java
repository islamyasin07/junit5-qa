package main.najah.test;

import main.najah.code.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Calculator Tests")
public class CalculatorTest {

	Calculator calculator;

	@BeforeAll
	static void setUpOnce() {
		System.out.println("Starting Calculator test suite...");
	}

	@AfterAll
	static void tearDownOnce() {
		System.out.println("Finished all Calculator tests.");
	}

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Finished a test.");
	}

	@Test
	@Order(1)
	@DisplayName("Addition with multiple numbers")
	void testAddition() {
		int result = calculator.add(2, 3, 4, 1);
		assertEquals(10, result);
	}

	@Test
	@Order(2)
	@DisplayName("Division with valid numbers")
	void testDivision() {
		int result = calculator.divide(10, 2);
		assertEquals(5, result);
	}

	@Test
	@Order(3)
	@DisplayName("Division by zero should throw exception")
	void testDivisionByZero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
		assertEquals("Cannot divide by zero", exception.getMessage());
	}

	@ParameterizedTest
	@Order(4)
	@ValueSource(ints = {0, 1, 2, 3, 4})
	@DisplayName("Factorial of small non-negative integers")
	void testFactorialValues(int input) {
		int result = calculator.factorial(input);
		assertTrue(result >= 1, "Factorial should be at least 1");
	}

	@Test
	@Order(5)
	@DisplayName("Factorial with negative input should throw exception")
	void testFactorialNegative() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
		assertEquals("Negative input", exception.getMessage());
	}

	@Test
	@Order(6)
	@Timeout(1)
	@DisplayName("Addition performance test")
	void testAdditionSpeed() {
		int result = calculator.add(100, 200);
		assertEquals(300, result);
	}

	@Test
	@Order(7)
	@Disabled("Expected to fail: this is a placeholder for future error handling test")
	@DisplayName("Disabled test for empty input")
	void testEmptyInputFail() {
		calculator.add(); 
		fail("This test is disabled and should be implemented properly later.");
	}
}
