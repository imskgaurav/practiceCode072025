package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * ElementFetch - Web Element finder utility
 * Implements: Dependency Inversion Principle
 * Responsibility: Find WebElements using Selenium locators
 * Uses: DriverManager (Singleton) for thread-safe driver access
 */
public class ElementFetch {

    /**
     * Get a single WebElement by identifier type and value
     * @param identifierType - Type of identifier (ID, NAME, XPATH)
     * @param identifierVal - Value of the identifier
     * @return WebElement found using the locator
     */
    public WebElement getWebElement(String identifierType, String identifierVal) {
        WebDriver driver = DriverManager.getInstance().getDriver();

        switch (identifierType) {
            case "ID":
                return driver.findElement(By.id(identifierVal));
            case "NAME":
                return driver.findElement(By.name(identifierVal));
            case "XPATH":
                return driver.findElement(By.xpath(identifierVal));
            default:
                return null;
        }
    }

    /**
     * Get a list of WebElements by identifier type and value
     * @param identifierType - Type of identifier (ID, css, XPATH, TAGNAME)
     * @param idtVal - Value of the identifier
     * @return List of WebElements found using the locator
     */
    public List<WebElement> getListWebElements(String identifierType, String idtVal) {
        WebDriver driver = DriverManager.getInstance().getDriver();

        switch (identifierType) {
            case "ID":
                return driver.findElements(By.id(idtVal));
            case "css":
                return driver.findElements(By.cssSelector(idtVal));
            case "XPATH":
                return driver.findElements(By.xpath(idtVal));
            case "TAGNAME":
                return driver.findElements(By.tagName(idtVal));
            default:
                return null;
        }
    }
}
