package framework.SeleniumFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import framework.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{
	
	@Test
	public void submitOrder() throws Exception {

	landingpage.loginApplication("tanishqmotke@gmail.com", "Pass@123");
	Assert.assertEquals("Incorrect email or password.",landingpage.ErrorMessage());
	}
}
