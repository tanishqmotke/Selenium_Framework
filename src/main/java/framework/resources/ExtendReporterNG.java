package framework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

	ExtentReports report;
	
	public void getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter repo = new ExtentSparkReporter(path);
		repo.config().setDocumentTitle("Test Result");
		
		new ExtentReports();
		report.attachReporter(repo);
		report.setSystemInfo("Tester", "Tanishq Motke");
		
	}
}
