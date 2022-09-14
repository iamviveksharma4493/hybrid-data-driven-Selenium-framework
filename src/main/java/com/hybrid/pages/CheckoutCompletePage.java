package com.hybrid.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.base.TestBase;

public class CheckoutCompletePage extends TestBase {
	
	@FindBy (xpath="//img[@class='pony_express123']")
	WebElement checkoutCompletePageLogo;
	
	
	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePonyExpressImage(){
	return checkoutCompletePageLogo.isDisplayed();	
	}

}
