package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
//This will contain all the locators which belongs to the landing page
	WebDriver driver; //instance variable
	
//whenever we try to initialize the object of the class the constructor is called
	
	public LandingPage(WebDriver driver) {
		super(driver);
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
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement error;
	
	public String ErrorMessage() {
		waitForWebElementToAppear(error);
		return error.getText();
	}
	
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
