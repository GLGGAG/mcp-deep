package cn.arch.mcp.deep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
} 