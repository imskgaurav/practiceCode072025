package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import main.java.utils.Constants;

public class BaseTest {
public static WebDriver driver;
public  static ExtentTest logger;
public static ExtentReports extent;
public static ExtentSparkReporter extentSparkReporter;

  @BeforeTest
  public void beforeTestMethod(){

    extentSparkReporter  = 
    new ExtentSparkReporter(System.getProperty("user.dir") + File.separator+"reports"+File.separator+"Automation TestResult");
    extentSparkReporter.config().setDocumentTitle("Automation REPORTS");
    extentSparkReporter.config().setReportName("Automation TestResult");
    extentSparkReporter.config().setTheme(Theme.STANDARD);
    extent = new ExtentReports();
    extent.attachReporter(extentSparkReporter);
    extent.setSystemInfo("Automation Tester", "EII execution");

  }
  @BeforeMethod
  @Parameters(value = {"browserName"})
  public void beforeMethodMethod(String browserName, Method testMethod){
    logger= extent.createTest(testMethod.getName());
   setUpDriver(browserName);
      driver.manage().window().maximize();
      driver.get(Constants.url);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


  }

  @AfterMethod
  public void afterMethodMethod(){


  }

  @AfterTest
  public void afterTestMethod(ITestResult result){
  if(result.getStatus()==ITestResult.SUCCESS){
     String methodName= result.getMethod().getMethodName();
     String logText= "Test case:"+ methodName+ " Passed";
Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
logger.log(Status.PASS, m);

  } else if(result.getStatus()==ITestResult.FAILURE) {
    String methodName = result.getMethod().getMethodName();

    String logText = "Test case:"+ methodName+ " Failed";
    Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);

logger.log(Status.FAIL, m);
  }
  driver.quit();

  }

  public void setUpDriver(String browserName){
    if(browserName.equalsIgnoreCase("chrome")){

      driver = new ChromeDriver();

    }else if(browserName.equalsIgnoreCase("edge")){

       driver = new EdgeDriver();
    }
      else{

        driver = new ChromeDriver();
    }

  }


}




