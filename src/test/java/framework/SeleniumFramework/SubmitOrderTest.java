package framework.SeleniumFramework;

import org.testng.annotations.DataProvider;
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

	@Test(dataProvider="getData",groups= {"Purchase","Smoke"})
	public void submitOrder(String email,String password, String ProductName) throws Exception {

		ProductCatalogue productCatalogue = landingpage.loginApplication(email,password);
		productCatalogue.ProductVisible();
		productCatalogue.getProductByName(ProductName);
		productCatalogue.addToCart(ProductName);
		Checkout checkout = productCatalogue.goToCartPage();

		Boolean match = checkout.CheckForProduct(ProductName);
		Assert.assertTrue(match);
		PaymentPage paymentpage = checkout.ClickCheckOut();

		paymentpage.selectCountry(CountryName);
		OrderConfirmation confirm = paymentpage.ClickSubmit();

		String confirmation = confirm.confirmOrder();
		confirmation.equalsIgnoreCase(ExpectedConfirmation);
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistory() {
		landingpage.loginApplication("tanishqmotke110@gmail.com", "Pass@123");
		OrderTest orderPage = landingpage.goToOrderPage();
		Assert.assertTrue(orderPage.CheckOrderName(ProductName));
	}

	@DataProvider
	public Object[][] getData() {
		// let suppose you want run the above two test with two different datasets
		// this is the syntax of two dimension array new Object [][] 
		//we can create two dimension array of String or int as well. int [] [] , String [] []
		return new Object[] [] {{"tanishqmotke110@gmail.com","Pass@123","ZARA COAT 3"},{"tanishqmotke110@gmail.com","Pass@123","ZARA COAT 3"}}; // let say you want to return two data sets
	}
}
