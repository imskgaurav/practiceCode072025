package main.java.SelTraining;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.network.Network;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.BaseTest;

import java.util.Optional;

/**
 * TestActions - Example test class (Refactored for SOLID principles)
 *
 * SOLID Compliance:
 * ✅ Single Responsibility: ONLY contains test methods
 * ✅ Open/Closed: Uses inherited setup/teardown (extensible)
 * ✅ Dependency Inversion: Depends on BaseTest abstraction
 *
 * Usage:
 * - Extends BaseTest: Inherits @BeforeMethod and @AfterMethod
 * - WebDriver initialized automatically via BaseTest
 * - Just write test logic in @Test methods
 */
public class TestActions extends BaseTest {

    private final String url = "https://www.google.com";

    @Test
    public void clickOnSearchBtn() {
        // WebDriver is automatically initialized by BaseTest@BeforeMethod
        // No need to manually call setUpDriver() anymore!
        driver.get(url);
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Google");
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        // Network.enable() expects 5 arguments. Commented out for now.
        // devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request ->
            System.out.println("Request URL: " + request.getRequest().getUrl())
        );
    }


}
