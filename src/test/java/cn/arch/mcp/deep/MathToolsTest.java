package cn.arch.mcp.deep;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathToolsTest {

    @Test
    public void testAdd() {
        // 测试正数相加
        assertEquals(5, MathTools.add(2, 3));
        
        // 测试负数相加
        assertEquals(-5, MathTools.add(-2, -3));
        
        // 测试一正一负相加
        assertEquals(-1, MathTools.add(2, -3));
        
        // 测试零的相加
        assertEquals(0, MathTools.add(0, 0));
        
        // 测试最大值边界
        assertEquals(Integer.MAX_VALUE, MathTools.add(Integer.MAX_VALUE, 0));
    }

    @Test
    public void testSubtract() {
        // 测试正数相减
        assertEquals(2, MathTools.subtract(5, 3));
        
        // 测试负数相减
        assertEquals(1, MathTools.subtract(-2, -3));
        
        // 测试一正一负相减
        assertEquals(5, MathTools.subtract(2, -3));
        
        // 测试零的相减
        assertEquals(0, MathTools.subtract(0, 0));
        assertEquals(5, MathTools.subtract(5, 0));
        assertEquals(-5, MathTools.subtract(0, 5));
    }

    @Test
    public void testMultiply() {
        // 测试正数相乘
        assertEquals(15, MathTools.multiply(3, 5));
        
        // 测试负数相乘
        assertEquals(6, MathTools.multiply(-2, -3));
        
        // 测试一正一负相乘
        assertEquals(-6, MathTools.multiply(2, -3));
        
        // 测试零的相乘
        assertEquals(0, MathTools.multiply(0, 5));
        assertEquals(0, MathTools.multiply(5, 0));
        
        // 测试1的相乘
        assertEquals(5, MathTools.multiply(1, 5));
        assertEquals(5, MathTools.multiply(5, 1));
    }

    @Test
    public void testDivide() {
        // 测试正数相除
        assertEquals(2.5, MathTools.divide(5, 2), 0.001);
        
        // 测试负数相除
        assertEquals(2.0, MathTools.divide(-6, -3), 0.001);
        
        // 测试一正一负相除
        assertEquals(-2.0, MathTools.divide(6, -3), 0.001);
        
        // 测试零被除
        assertEquals(0.0, MathTools.divide(0, 5), 0.001);
        
        // 测试除以1
        assertEquals(5.0, MathTools.divide(5, 1), 0.001);
    }

    @Test
    public void testDivideByZero() {
        // 测试除以零的异常
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> MathTools.divide(5, 0)
        );
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    public void testFactorial() {
        // 测试基本阶乘
        assertEquals(1, MathTools.factorial(0));
        assertEquals(1, MathTools.factorial(1));
        assertEquals(2, MathTools.factorial(2));
        assertEquals(6, MathTools.factorial(3));
        assertEquals(24, MathTools.factorial(4));
        assertEquals(120, MathTools.factorial(5));
        assertEquals(720, MathTools.factorial(6));
    }

    @Test
    public void testFactorialNegative() {
        // 测试负数阶乘的异常
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> MathTools.factorial(-1)
        );
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }

    @Test
    public void testIsPrime() {
        // 测试非质数
        assertFalse(MathTools.isPrime(-1));
        assertFalse(MathTools.isPrime(0));
        assertFalse(MathTools.isPrime(1));
        assertFalse(MathTools.isPrime(4));
        assertFalse(MathTools.isPrime(6));
        assertFalse(MathTools.isPrime(8));
        assertFalse(MathTools.isPrime(9));
        assertFalse(MathTools.isPrime(10));
        assertFalse(MathTools.isPrime(15));
        assertFalse(MathTools.isPrime(25));
        
        // 测试质数
        assertTrue(MathTools.isPrime(2));
        assertTrue(MathTools.isPrime(3));
        assertTrue(MathTools.isPrime(5));
        assertTrue(MathTools.isPrime(7));
        assertTrue(MathTools.isPrime(11));
        assertTrue(MathTools.isPrime(13));
        assertTrue(MathTools.isPrime(17));
        assertTrue(MathTools.isPrime(19));
        assertTrue(MathTools.isPrime(23));
        assertTrue(MathTools.isPrime(29));
        assertTrue(MathTools.isPrime(31));
    }

    @Test
    public void testGcd() {
        // 测试基本最大公约数
        assertEquals(1, MathTools.gcd(1, 1));
        assertEquals(1, MathTools.gcd(1, 5));
        assertEquals(5, MathTools.gcd(5, 5));
        assertEquals(5, MathTools.gcd(10, 15));
        assertEquals(6, MathTools.gcd(12, 18));
        assertEquals(1, MathTools.gcd(7, 11));
        
        // 测试负数
        assertEquals(5, MathTools.gcd(-10, 15));
        assertEquals(5, MathTools.gcd(10, -15));
        assertEquals(5, MathTools.gcd(-10, -15));
        
        // 测试零
        assertEquals(5, MathTools.gcd(0, 5));
        assertEquals(5, MathTools.gcd(5, 0));
    }

    @Test
    public void testPower() {
        // 测试基本幂运算
        assertEquals(1, MathTools.power(5, 0));
        assertEquals(5, MathTools.power(5, 1));
        assertEquals(25, MathTools.power(5, 2));
        assertEquals(125, MathTools.power(5, 3));
        assertEquals(8, MathTools.power(2, 3));
        assertEquals(16, MathTools.power(2, 4));
        
        // 测试负数底数
        assertEquals(1, MathTools.power(-5, 0));
        assertEquals(-5, MathTools.power(-5, 1));
        assertEquals(25, MathTools.power(-5, 2));
        assertEquals(-125, MathTools.power(-5, 3));
        
        // 测试零的幂
        assertEquals(0, MathTools.power(0, 1));
        assertEquals(0, MathTools.power(0, 5));
        assertEquals(1, MathTools.power(0, 0)); // 0^0 = 1 by convention
    }

    @Test
    public void testPowerNegativeExponent() {
        // 测试负指数的异常
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> MathTools.power(5, -1)
        );
        assertEquals("Negative exponents are not supported for integer results", exception.getMessage());
    }
} 