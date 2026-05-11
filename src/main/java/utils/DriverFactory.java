package main.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * DriverFactory - Encapsulates driver creation logic
 * Implements: Strategy Pattern + Open/Closed Principle
 * Dependency Inversion: Depends on WebDriver interface, not concrete classes
 * Single Responsibility: ONLY create drivers
 *
 * Benefits:
 * - Easy to add new browser types without modifying BaseTest
 * - Centralized driver creation logic
 * - Testable and maintainable
 */
public class DriverFactory {

    /**
     * Factory method to create appropriate WebDriver based on browser name
     *
     * @param browserName - Type of browser (chrome, edge, firefox, etc.)
     * @return WebDriver instance
     * @throws IllegalArgumentException if browser type not supported
     */
    public static WebDriver createDriver(String browserName) {
        if (browserName == null || browserName.trim().isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty");
        }

        return switch (browserName.toLowerCase().trim()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            // TODO: Add more browser types as needed
            // case "firefox" -> new FirefoxDriver();
            // case "safari" -> new SafariDriver();
            default -> throw new IllegalArgumentException("Browser not supported: " + browserName);
        };
    }
}

