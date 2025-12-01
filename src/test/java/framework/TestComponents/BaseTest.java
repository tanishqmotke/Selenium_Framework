package framework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public void initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/tanishqmotke/eclipse-workspace/SeleniumFramework/src/main/java/framework/resources/GlobalData.properties");
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	
	
}
