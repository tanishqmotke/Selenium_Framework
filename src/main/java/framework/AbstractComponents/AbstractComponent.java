package framework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.Checkout;
import framework.pageobjects.OrderTest;

public class AbstractComponent {
//This will have all the reusable code
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {	
		this.driver = driver;
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderHeader;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement error) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Wait.until(ExpectedConditions.visibilityOf(error));
	}
	
	public Checkout goToCartPage() {
		cartHeader.click();
		Checkout checkout = new Checkout(driver);
		return checkout;
	}
	
	public OrderTest goToOrderPage() {
		OrderHeader.click();
		OrderTest orderhistory = new OrderTest(driver);
		return orderhistory;
	}
	
	public void SelectBox(WebElement selectbox,String Option) {
		Actions a = new Actions(driver);
		a.click(selectbox).sendKeys(Option).build().perform();
	}
	
	public String GetText(WebElement element) {
		String Text = element.getText();
		return Text;
	}
}
