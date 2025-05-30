package cn.arch.mcp.deep;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.main.web-application-type=none"
})
public class McpDeepApplicationTest {

    @Test
    public void contextLoads() {
        // This test verifies that the Spring application context loads successfully
        // If the context fails to load, this test will fail
    }

    @Test
    public void mainMethodTest() {
        // Test that the main method can be called without throwing exceptions
        // We don't actually start the application to avoid port conflicts
        String[] args = {};
        
        // This would normally start the application, but we're just testing
        // that the method exists and can be called
        // McpDeepApplication.main(args); // Commented out to avoid starting the app
        
        // Instead, we'll just verify the class exists and has the main method
        try {
            McpDeepApplication.class.getDeclaredMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError("Main method not found", e);
        }
    }
}