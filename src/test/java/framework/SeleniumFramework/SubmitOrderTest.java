package framework.SeleniumFramework;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;
import framework.pageobjects.Checkout;
import framework.pageobjects.OrderConfirmation;
import framework.pageobjects.OrderTest;
import framework.pageobjects.PaymentPage;
import framework.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String ProductName = "ZARA COAT 3";
	String CountryName = "India";
	String ExpectedConfirmation = " Thankyou for the order. ";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws Exception {
		ProductCatalogue productCatalogue = landingpage.loginApplication(input.get("email"),input.get("password"));
		productCatalogue.ProductVisible();
		productCatalogue.getProductByName(input.get("product"));
		productCatalogue.addToCart(input.get("product"));
		Checkout checkout = productCatalogue.goToCartPage();

		Boolean match = checkout.CheckForProduct(input.get("product"));
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
		
		HashMap<Object,Object> map = new HashMap<Object, Object>();
		map.put("email", "tanishqmotke110@gmail.com");
		map.put("password","Pass@123");
		map.put("product","ZARA COAT 3");
		
		HashMap<Object,Object> map2 = new HashMap<Object, Object>();
		map2.put("email", "tanishqmotke110@gmail.com");
		map2.put("password","Pass@123");
		map2.put("product","ZARA COAT 3");
	
		return new Object[] [] {{map},{map2}}; // let say you want to return two data sets
	}
}
