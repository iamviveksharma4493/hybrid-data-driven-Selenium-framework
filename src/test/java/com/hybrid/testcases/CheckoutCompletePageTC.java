package com.hybrid.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid.base.TestBase;
import com.hybrid.pages.CheckoutCompletePage;
import com.hybrid.pages.CheckoutOverviewPage;
import com.hybrid.pages.CheckoutPage;
import com.hybrid.pages.LoginPage;
import com.hybrid.pages.ProductsPage;
import com.hybrid.pages.YourCartPage;
import com.hybrid.util.TestUtil;

public class CheckoutCompletePageTC extends TestBase {

	LoginPage loginPage;
	ProductsPage productsPage;
	YourCartPage yourCartPage;
	TestUtil testUtil;
	CheckoutPage checkoutPage;
	CheckoutOverviewPage checkoutOverviewPage;
	String sheetName = "Your Info";
	CheckoutCompletePage checkoutCompletePage;

	public CheckoutCompletePageTC() {
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
		checkoutOverviewPage = new CheckoutOverviewPage();
		checkoutCompletePage = new CheckoutCompletePage();
		
	}

	@DataProvider
	public Object[][] getSwagTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "getSwagTestData")
	public void verifyImageTest(String firstName, String lastName, String zip) {

		productsPage.clickOnAddToCartBtn();
		productsPage.clickOnCartBtn();
		yourCartPage.clickOnCkeckoutBtn();
		checkoutPage.clickOnContinueBtn(firstName, lastName, zip);
		checkoutOverviewPage.clickOnFinishBtn();
		// checkoutCompletePage

		boolean flag = checkoutCompletePage.validatePonyExpressImage();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
