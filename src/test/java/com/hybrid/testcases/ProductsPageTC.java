package com.hybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hybrid.base.TestBase;
import com.hybrid.pages.LoginPage;
import com.hybrid.pages.ProductsPage;
import com.hybrid.pages.YourCartPage;

public class ProductsPageTC extends TestBase {

	LoginPage loginPage;
	ProductsPage productsPage;
	YourCartPage yourCartPage;

	public ProductsPageTC() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productsPage = new ProductsPage();
		yourCartPage = new YourCartPage();
		
	}

	@Test
	public void verifyProductsPageTitleTest() {
		String productsPagetitle = productsPage.validateProductsPageTitle();
		Assert.assertEquals(productsPagetitle, "Swag Labs", "Products page title not matched");
	} // above mentioned msg to show if title mismatches

	@Test
	public void verifyBackpackNameTest() {
		Assert.assertTrue(productsPage.verifyBackpackName());
	}

	@Test
	public void validateBackpackNameTest() {
		Assert.assertEquals(productsPage.validateBackpackName(), "Sauce Labs Backpack", "Backpack name is incorrect");
	}

	@Test
	public void verifyAddToCartBtnTest() {
		productsPage.clickOnAddToCartBtn();

	}

	@Test
	public void verifyCartBtnTest() {
		yourCartPage = productsPage.clickOnCartBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
