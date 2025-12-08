package framework.SeleniumFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import framework.TestComponents.BaseTest;
import framework.pageobjects.Checkout;
import framework.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest{
	
	@Test
	public void LoggingPageError() throws Exception {

	landingpage.loginApplication("tanishqmotke@gmail.com", "Pass@123");
	AssertJUnit.assertEquals("Incorrect email or password.",landingpage.ErrorMessage());
	}
	
	@Test
	public void ProductValidationError() throws Exception {

		String ProductName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingpage.loginApplication("tanishqmotke110@gmail.com", "Pass@123");
		productCatalogue.ProductVisible();
		productCatalogue.getProductByName(ProductName);
		productCatalogue.addToCart(ProductName);
		Checkout checkout =productCatalogue.goToCartPage();
		Boolean match = checkout.CheckForProduct("ZARA COAT 33");
		Assert.assertFalse(match);
}
}
