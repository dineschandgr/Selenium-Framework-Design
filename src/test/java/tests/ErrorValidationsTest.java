package tests;

import TestComponents.BaseTest;
import com.sun.net.httpserver.Authenticator.Retry;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ProductCatalogPage;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer= Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingPage.loginApplication("dineshchandgr@gmail.com", "Password@2");
		Assert.assertEquals("Incorrec email or password.", landingPage.getErrorMessgage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		ProductCatalogPage productCatalogue = landingPage.loginApplication("dineshchandgr@gmail.com", "Password@1");
		List<WebElement> products = productCatalogue.getProductList();
		Thread.sleep(2000);
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductFound("ZARA COAT 33");
		Assert.assertFalse(match);
	}

	
	

}
