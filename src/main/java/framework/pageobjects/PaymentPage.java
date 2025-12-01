package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	WebDriver driver; // instance variable

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver; // points to the instance variable
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement selectbox;

	By selectBoxOption = By.cssSelector(".ta-results");

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectOptResult;

	public void selectCountry(String Country) {
		SelectBox(selectbox, Country);
		waitForElementToAppear(selectBoxOption);
		selectOptResult.click();
	}

	@FindBy(css = ".action__submit")
	WebElement Submit;

	public OrderConfirmation ClickSubmit() {
		Submit.click();
		OrderConfirmation confirm = new OrderConfirmation(driver);
		return confirm;
	}

}
