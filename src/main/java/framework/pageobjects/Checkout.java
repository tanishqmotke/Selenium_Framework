package framework.pageobjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import framework.AbstractComponents.AbstractComponent;

public class Checkout extends AbstractComponent{
	WebDriver driver; 
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement>cartProduct;
	
	//public List<WebElement> cartProduct() {
	//	return cartProduct;
	//}
	
	public boolean CheckForProduct(String ProductName) {
		Boolean match = cartProduct.stream()
				.anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	@FindBy(css=".totalRow button")
	WebElement CheckOut;
	public PaymentPage ClickCheckOut() {
		CheckOut.click();
		PaymentPage paymentpage = new PaymentPage(driver);
		return paymentpage;
	}
	

}
