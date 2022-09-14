package com.hybrid.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.base.TestBase;

public class CheckoutPage extends TestBase {

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='postalCode']")
	WebElement postalCode;

	@FindBy(xpath = "//input[@name='continue']")
	WebElement continueBtn;

	
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateCheckoutPageTitle() {
		return driver.getTitle();
	}

	public CheckoutOverviewPage clickOnContinueBtn(String fname, String lname, String zip) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(zip);
		continueBtn.click();

		return new CheckoutOverviewPage();
	}

}
