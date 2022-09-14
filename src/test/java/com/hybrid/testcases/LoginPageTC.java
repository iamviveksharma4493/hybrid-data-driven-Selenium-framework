package com.hybrid.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hybrid.base.TestBase;
import com.hybrid.pages.LoginPage;
import com.hybrid.pages.ProductsPage;

public class LoginPageTC extends TestBase {

	LoginPage loginPage;
	ProductsPage productsPage;

	public LoginPageTC() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyLoginPageTitleTest() {
		String loginPagetitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPagetitle, "Swag Labs");
	}

	@Test
	public void loginTest() {
		productsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
