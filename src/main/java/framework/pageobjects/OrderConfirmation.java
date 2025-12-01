package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class OrderConfirmation extends AbstractComponent {
	WebDriver driver;

	public OrderConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="h1[class='hero-primary']")
	WebElement confirmMessage;
	
	public void confirmOrder(String ConfirmationTxt) {
		String confirmMsg = GetText(confirmMessage);
		confirmMsg.equalsIgnoreCase(ConfirmationTxt);
		
	}	
}
