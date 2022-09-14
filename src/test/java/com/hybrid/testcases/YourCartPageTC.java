package com.hybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hybrid.base.TestBase;
import com.hybrid.pages.CheckoutPage;
import com.hybrid.pages.LoginPage;
import com.hybrid.pages.ProductsPage;
import com.hybrid.pages.YourCartPage;

public class YourCartPageTC extends TestBase {

	LoginPage loginPage;
	ProductsPage productsPage;
	YourCartPage yourCartPage;
	CheckoutPage checkoutPage;

	public YourCartPageTC() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productsPage = new ProductsPage();
		yourCartPage = new YourCartPage();
		checkoutPage = new CheckoutPage();
		
	}

	// @Test(priority = 1)
	// public void verifyCartBtnTest() {
	// System.out.println("Inside veriyCartBtnTest method");
	// productsPage.clickOnCartBtn();
	// }

	@Test
	public void verifyYourCartPageTitleTest() {
		String yourCartPageTitle = yourCartPage.validateYourCartPageTitle();
		Assert.assertEquals(yourCartPageTitle, "Swag Labs", "Products page title not matched");
	}

	@Test
	public void verifyCheckoutBtnTest() {

		productsPage.clickOnAddToCartBtn();
		productsPage.clickOnCartBtn();
		checkoutPage = yourCartPage.clickOnCkeckoutBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
