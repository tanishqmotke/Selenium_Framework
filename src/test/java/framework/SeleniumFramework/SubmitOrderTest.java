package framework.SeleniumFramework;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;
import framework.pageobjects.Checkout;
import framework.pageobjects.LandingPage;
import framework.pageobjects.OrderConfirmation;
import framework.pageobjects.OrderTest;
import framework.pageobjects.PaymentPage;
import framework.pageobjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest {
	
	String ProductName = "ZARA COAT 3";
	String CountryName = "India";
	String ExpectedConfirmation = " Thankyou for the order. ";
	
	@Test
	public void submitOrder() throws Exception {

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

		String confirmation = confirm.confirmOrder();
		confirmation.equalsIgnoreCase(ExpectedConfirmation);
	}
	
	@Test(dependsOnMethods={"submitOrder"})
	public void OrderHistory() {
		landingpage.loginApplication("tanishqmotke110@gmail.com", "Pass@123");
		OrderTest orderPage = landingpage.goToOrderPage();
		orderPage.CheckOrderName(ProductName);
	}

}
