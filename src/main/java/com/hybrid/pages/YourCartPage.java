package com.hybrid.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.base.TestBase;

public class YourCartPage extends TestBase{
	
	@FindBy(xpath="//span[@class='title']")
	WebElement yourCartPageTitle;
	
	@FindBy(xpath="//button[@name='checkout']")
	WebElement ckeckoutBtn;
	
	
	
	
	public YourCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateYourCartPageTitle(){
		return driver.getTitle();
	}
	
	public CheckoutPage clickOnCkeckoutBtn(){
		ckeckoutBtn.click();
		return new CheckoutPage();
	}
	
	
	
	


}
