package framework.TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import framework.resources.ExtendReporterNG;

public class Listeners extends BaseTest implements ITestListener {
ExtentTest test;
ExtentReports extent = ExtendReporterNG.getReportObject();

@Override
public void onTestStart(ITestResult result) {
	test = extent.createTest(result.getMethod().getMethodName());
}

@Override
public void onTestSuccess(ITestResult result) {
	
}

@Override
public void onTestFailure(ITestResult result) {
	test.fail(result.getThrowable());
	String screenshortPath = null;
	try {
		screenshortPath = getScreenshot(result.getMethod().getMethodName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(screenshortPath,result.getMethod().getMethodName());
}

public void onTestSkipped(ITestResult result) {
 // not implemented
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
 // not implemented
}

public void onTestFailedWithTimeout(ITestResult result) {
 onTestFailure(result);
}

public void onStart(ITestContext context) {
 // not implemented
}

public void onFinish(ITestContext context) {
 // not implemented
}
}

