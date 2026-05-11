package main.java.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

/**
 * ReportManager - Singleton pattern for ExtentReports management
 * Implements: Singleton Pattern + Single Responsibility Principle
 * Responsibility: ONLY manage report lifecycle and test logging
 */
public class ReportManager {
    private static volatile ReportManager instance;
    private ExtentReports extent;
    private ExtentSparkReporter extentSparkReporter;

    // Private constructor
    private ReportManager() {
    }

    /**
     * Get singleton instance of ReportManager
     */
    public static ReportManager getInstance() {
        if (instance == null) {
            synchronized (ReportManager.class) {
                if (instance == null) {
                    instance = new ReportManager();
                }
            }
        }
        return instance;
    }

    /**
     * Initialize ExtentReports with configuration
     */
    public void initializeReport() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + File.separator
                    + "reports" + File.separator + "Automation TestResult";

            extentSparkReporter = new ExtentSparkReporter(reportPath);
            extentSparkReporter.config().setDocumentTitle("Automation REPORTS");
            extentSparkReporter.config().setReportName("Automation TestResult");
            extentSparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(extentSparkReporter);
            extent.setSystemInfo("Automation Tester", "EII execution");
        }
    }

    /**
     * Create a new test in the report
     */
    public ExtentTest createTest(String testName) {
        if (extent == null) {
            throw new IllegalStateException("Report not initialized. Call initializeReport() first.");
        }
        return extent.createTest(testName);
    }

    /**
     * Flush and finalize the report
     */
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    /**
     * Get ExtentReports instance
     */
    public ExtentReports getExtent() {
        if (extent == null) {
            throw new IllegalStateException("Report not initialized. Call initializeReport() first.");
        }
        return extent;
    }
}

