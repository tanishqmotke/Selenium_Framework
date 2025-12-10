package framework.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import framework.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/tanishqmotke/eclipse-workspace/SeleniumFramework/src/main/java/framework/resources/GlobalData.properties");
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException {	
		driver = initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.goToLandingPage();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
