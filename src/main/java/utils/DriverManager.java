package main.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Singleton DriverManager - Thread-safe WebDriver instance management
 * Implements: Singleton Pattern + Dependency Inversion Principle
 * Responsibility: ONLY manage WebDriver lifecycle (Single Responsibility)
 */
public class DriverManager {
    private static volatile DriverManager instance;
    private WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {
    }

    /**
     * Thread-safe lazy initialization of singleton instance
     * Uses double-checked locking pattern
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    /**
     * Initialize WebDriver using the DriverFactory
     *
     * @param browserName - Browser type to initialize
     */
    public void initializeDriver(String browserName) {
        if (this.driver == null) {
            this.driver = DriverFactory.createDriver(browserName);
        }
    }

    /**
     * Get the current WebDriver instance
     */
    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    /**
     * Quit the WebDriver and clean up resources
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Close the current window
     */
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

