package framework.SeleniumFramework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import framework.pageobjects.Checkout;
import framework.pageobjects.LandingPage;
import framework.pageobjects.OrderConfirmation;
import framework.pageobjects.PaymentPage;
import framework.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SubmitOrderTest {
	public static void main(String[] args){

		String ProductName = "ZARA COAT 3";
		String CountryName = "India";
		String Confirmation = " Thankyou for the order. ";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		LandingPage landingpage = new LandingPage(driver);
		landingpage.goToLandingPage();
		ProductCatalogue productCatalogue = landingpage.loginApplication("tanishqmotke110@gmail.com", "Pass@123");
		productCatalogue.ProductVisible();
		productCatalogue.getProductByName(ProductName);
		productCatalogue.addToCart(ProductName);
		Checkout checkout =productCatalogue.goToCartPage();

		Boolean match = checkout.CheckForProduct(ProductName);
		Assert.assertTrue(match);
		PaymentPage paymentpage = checkout.ClickCheckOut();
		
		paymentpage.selectCountry(CountryName);
		OrderConfirmation confirm = paymentpage.ClickSubmit();

		confirm.confirmOrder(Confirmation);
		driver.close();
	}

}
