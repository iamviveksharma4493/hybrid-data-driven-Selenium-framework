package com.hybrid.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.base.TestBase;

public class CheckoutOverviewPage extends TestBase {

	@FindBy(xpath = "//button[@name='finish']")
	WebElement finishBtn;
	
	public CheckoutOverviewPage(){
		PageFactory.initElements(driver, this);
	}

	public CheckoutCompletePage clickOnFinishBtn() {
		finishBtn.click();
		return new CheckoutCompletePage();
	}

}
