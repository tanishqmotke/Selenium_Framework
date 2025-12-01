package framework.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver; // instance variable

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver; // points to the instance variable
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By productList = By.cssSelector(".mb-3");

	public List<WebElement> ProductVisible() {
		waitForElementToAppear(productList);
		return products;
	}

	public WebElement getProductByName(String ProductName) {
		WebElement prod = ProductVisible().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}
	
	By toastcontainer = By.cssSelector("#toast-container");
	By animationLoad = By.cssSelector(".ng-animating");

	
	public void addToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(toastcontainer);
		waitForElementToDisappear(animationLoad);
	}
	
	

}
