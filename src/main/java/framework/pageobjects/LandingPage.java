package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
//This will contain all the locators which belongs to the landing page
	WebDriver driver; //instance variable
	
//whenever we try to initialize the object of the class the constructor is called
	
	public LandingPage(WebDriver driver) {
		this.driver = driver; //points to the instance variable
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	//WebElement userPassword = driver.findElement(By.id("userPassword"));
	
	@FindBy(id="login")
	WebElement LoginBtn;
	//WebElement LoginBtn = driver.findElement(By.id("login"));
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		LoginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goToLandingPage() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	
}
