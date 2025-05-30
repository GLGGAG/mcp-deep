package cn.arch.mcp.deep;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class MathToolsTest {

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        
        @Test
        @DisplayName("Should add positive numbers correctly")
        public void testAddPositiveNumbers() {
            assertEquals(5, MathTools.add(2, 3));
            assertEquals(10, MathTools.add(7, 3));
        }
        
        @Test
        @DisplayName("Should add negative numbers correctly")
        public void testAddNegativeNumbers() {
            assertEquals(-5, MathTools.add(-2, -3));
            assertEquals(-10, MathTools.add(-7, -3));
        }
        
        @Test
        @DisplayName("Should add positive and negative numbers correctly")
        public void testAddMixedNumbers() {
            assertEquals(-1, MathTools.add(2, -3));
            assertEquals(1, MathTools.add(3, -2));
        }
        
        @Test
        @DisplayName("Should handle zero correctly")
        public void testAddWithZero() {
            assertEquals(0, MathTools.add(0, 0));
            assertEquals(5, MathTools.add(5, 0));
            assertEquals(5, MathTools.add(0, 5));
        }
        
        @Test
        @DisplayName("Should handle boundary values")
        public void testAddBoundaryValues() {
            assertEquals(Integer.MAX_VALUE, MathTools.add(Integer.MAX_VALUE, 0));
            assertEquals(Integer.MIN_VALUE, MathTools.add(Integer.MIN_VALUE, 0));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        
        @Test
        @DisplayName("Should subtract positive numbers correctly")
        public void testSubtractPositiveNumbers() {
            assertEquals(2, MathTools.subtract(5, 3));
            assertEquals(0, MathTools.subtract(5, 5));
        }
        
        @Test
        @DisplayName("Should subtract negative numbers correctly")
        public void testSubtractNegativeNumbers() {
            assertEquals(1, MathTools.subtract(-2, -3));
            assertEquals(-1, MathTools.subtract(-3, -2));
        }
        
        @Test
        @DisplayName("Should handle zero correctly")
        public void testSubtractWithZero() {
            assertEquals(5, MathTools.subtract(5, 0));
            assertEquals(-5, MathTools.subtract(0, 5));
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        
        @Test
        @DisplayName("Should multiply positive numbers correctly")
        public void testMultiplyPositiveNumbers() {
            assertEquals(6, MathTools.multiply(2, 3));
            assertEquals(20, MathTools.multiply(4, 5));
        }
        
        @Test
        @DisplayName("Should multiply negative numbers correctly")
        public void testMultiplyNegativeNumbers() {
            assertEquals(6, MathTools.multiply(-2, -3));
            assertEquals(-6, MathTools.multiply(-2, 3));
            assertEquals(-6, MathTools.multiply(2, -3));
        }
        
        @Test
        @DisplayName("Should handle zero correctly")
        public void testMultiplyWithZero() {
            assertEquals(0, MathTools.multiply(5, 0));
            assertEquals(0, MathTools.multiply(0, 5));
            assertEquals(0, MathTools.multiply(0, 0));
        }
        
        @Test
        @DisplayName("Should handle one correctly")
        public void testMultiplyWithOne() {
            assertEquals(5, MathTools.multiply(5, 1));
            assertEquals(5, MathTools.multiply(1, 5));
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {
        
        @Test
        @DisplayName("Should divide positive numbers correctly")
        public void testDividePositiveNumbers() {
            assertEquals(2.0, MathTools.divide(6, 3), 0.001);
            assertEquals(2.5, MathTools.divide(5, 2), 0.001);
        }
        
        @Test
        @DisplayName("Should divide negative numbers correctly")
        public void testDivideNegativeNumbers() {
            assertEquals(2.0, MathTools.divide(-6, -3), 0.001);
            assertEquals(-2.0, MathTools.divide(-6, 3), 0.001);
            assertEquals(-2.0, MathTools.divide(6, -3), 0.001);
        }
        
        @Test
        @DisplayName("Should handle zero dividend correctly")
        public void testDivideZeroDividend() {
            assertEquals(0.0, MathTools.divide(0, 5), 0.001);
        }
        
        @Test
        @DisplayName("Should throw exception for division by zero")
        public void testDivideByZero() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, 
                () -> MathTools.divide(5, 0)
            );
            assertEquals("Division by zero is not allowed", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Factorial Tests")
    class FactorialTests {
        
        @Test
        @DisplayName("Should calculate factorial of small numbers correctly")
        public void testFactorialSmallNumbers() {
            assertEquals(1, MathTools.factorial(0));
            assertEquals(1, MathTools.factorial(1));
            assertEquals(2, MathTools.factorial(2));
            assertEquals(6, MathTools.factorial(3));
            assertEquals(24, MathTools.factorial(4));
            assertEquals(120, MathTools.factorial(5));
        }
        
        @Test
        @DisplayName("Should calculate factorial of larger numbers correctly")
        public void testFactorialLargerNumbers() {
            assertEquals(720, MathTools.factorial(6));
            assertEquals(5040, MathTools.factorial(7));
            assertEquals(40320, MathTools.factorial(8));
        }
        
        @Test
        @DisplayName("Should throw exception for negative numbers")
        public void testFactorialNegativeNumber() {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, 
                () -> MathTools.factorial(-1)
            );
            assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Prime Number Tests")
    class PrimeTests {
        
        @Test
        @DisplayName("Should identify small prime numbers correctly")
        public void testSmallPrimes() {
            assertTrue(MathTools.isPrime(2));
            assertTrue(MathTools.isPrime(3));
            assertTrue(MathTools.isPrime(5));
            assertTrue(MathTools.isPrime(7));
            assertTrue(MathTools.isPrime(11));
            assertTrue(MathTools.isPrime(13));
        }
        
        @Test
        @DisplayName("Should identify composite numbers correctly")
        public void testCompositeNumbers() {
            assertFalse(MathTools.isPrime(4));
            assertFalse(MathTools.isPrime(6));
            assertFalse(MathTools.isPrime(8));
            assertFalse(MathTools.isPrime(9));
            assertFalse(MathTools.isPrime(10));
            assertFalse(MathTools.isPrime(12));
        }
        
        @Test
        @DisplayName("Should handle edge cases correctly")
        public void testPrimeEdgeCases() {
            assertFalse(MathTools.isPrime(0));
            assertFalse(MathTools.isPrime(1));
            assertFalse(MathTools.isPrime(-1));
            assertFalse(MathTools.isPrime(-5));
        }
        
        @Test
        @DisplayName("Should identify larger prime numbers correctly")
        public void testLargerPrimes() {
            assertTrue(MathTools.isPrime(17));
            assertTrue(MathTools.isPrime(19));
            assertTrue(MathTools.isPrime(23));
            assertTrue(MathTools.isPrime(29));
            assertTrue(MathTools.isPrime(31));
        }
    }

    @Nested
    @DisplayName("Greatest Common Divisor Tests")
    class GcdTests {
        
        @Test
        @DisplayName("Should calculate GCD of positive numbers correctly")
        public void testGcdPositiveNumbers() {
            assertEquals(6, MathTools.gcd(12, 18));
            assertEquals(5, MathTools.gcd(15, 25));
            assertEquals(1, MathTools.gcd(7, 11));
            assertEquals(4, MathTools.gcd(8, 12));
        }
        
        @Test
        @DisplayName("Should handle zero correctly")
        public void testGcdWithZero() {
            assertEquals(5, MathTools.gcd(5, 0));
            assertEquals(5, MathTools.gcd(0, 5));
            assertEquals(0, MathTools.gcd(0, 0));
        }
        
        @Test
        @DisplayName("Should handle negative numbers correctly")
        public void testGcdNegativeNumbers() {
            assertEquals(6, MathTools.gcd(-12, 18));
            assertEquals(6, MathTools.gcd(12, -18));
            assertEquals(6, MathTools.gcd(-12, -18));
        }
        
        @Test
        @DisplayName("Should handle identical numbers correctly")
        public void testGcdIdenticalNumbers() {
            assertEquals(5, MathTools.gcd(5, 5));
            assertEquals(10, MathTools.gcd(10, 10));
        }
        
        @Test
        @DisplayName("Should handle coprime numbers correctly")
        public void testGcdCoprimeNumbers() {
            assertEquals(1, MathTools.gcd(3, 7));
            assertEquals(1, MathTools.gcd(8, 9));
            assertEquals(1, MathTools.gcd(13, 17));
        }
    }
} 