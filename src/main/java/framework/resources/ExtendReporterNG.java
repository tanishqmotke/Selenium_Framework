package framework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {

	static ExtentReports report;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter repo = new ExtentSparkReporter(path);
		repo.config().setDocumentTitle("Test Result");
		
		report=new ExtentReports();
		report.attachReporter(repo);
		report.setSystemInfo("Tester", "Tanishq Motke");
		return report;
	}
}
