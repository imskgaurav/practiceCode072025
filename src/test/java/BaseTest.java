package test.java;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.lang.reflect.Method;
import java.time.Duration;
import main.java.utils.Constants;
import main.java.utils.DriverManager;
import main.java.utils.ReportManager;

/**
 * BaseTest - Test lifecycle management (Refactored for SOLID principles)
 *
 * SOLID Compliance:
 * ✅ Single Responsibility: ONLY manages test lifecycle (@Before/@After)
 * ✅ Open/Closed: Delegates to DriverManager & ReportManager (extensible)
 * ✅ Dependency Inversion: Depends on abstraction through managers
 * ✅ Interface Segregation: Focused on one concern
 *
 * Design Patterns:
 * - Singleton: Uses DriverManager & ReportManager singletons
 * - Template Method: Defines test setup/teardown flow
 */
public class BaseTest {
    protected WebDriver driver;
    protected ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod() {
        // Initialize Report Manager (Singleton - only once)
        ReportManager.getInstance().initializeReport();
    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) {
        // Initialize WebDriver using DriverManager (Singleton)
        DriverManager.getInstance().initializeDriver(browserName);
        driver = DriverManager.getInstance().getDriver();

        // Create test in report
        logger = ReportManager.getInstance().createTest(testMethod.getName());

        // Browser setup
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethodMethod() {
        // Can add cleanup if needed
    }

    @AfterTest
    public void afterTestMethod(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText;
        Status status;

        if (result.getStatus() == ITestResult.SUCCESS) {
            logText = "Test case: " + methodName + " Passed";
            status = Status.PASS;
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(status, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            logText = "Test case: " + methodName + " Failed";
            status = Status.FAIL;
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(status, m);
        }

        // Cleanup resources
        DriverManager.getInstance().quitDriver();
        ReportManager.getInstance().flushReport();
    }

    /**
     * Static method for backward compatibility
     * (Can be removed once all tests extend BaseTest)
     */
    @Deprecated(forRemoval = true, since = "2.0")
    public static WebDriver setUpDriver(String browserName) {
        DriverManager.getInstance().initializeDriver(browserName);
        return DriverManager.getInstance().getDriver();
    }


}




