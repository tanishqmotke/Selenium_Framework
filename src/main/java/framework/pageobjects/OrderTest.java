package framework.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class OrderTest extends AbstractComponent{
	WebDriver driver; 
	
	public OrderTest(WebDriver driver) {
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tbody tr")
	List<WebElement> listofOrder;
	
	public Boolean CheckOrderName(String productName) {
		Boolean match = listofOrder.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
		}
	}
	
	
