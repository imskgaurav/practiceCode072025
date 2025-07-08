package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import test.java.BaseTest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer{

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        String fileName = System.getProperty("user.dir")+ File.separator+ "screenshots"+ File.separator+ result.getMethod().getMethodName();
       File file =   ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(fileName+".png"));
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
       annotation.setRetryAnalyzer(RetryAnalyser.class);
    }
    

}
