package com.hybrid.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.base.TestBase;

public class ProductsPage extends TestBase {
	
	@FindBy(xpath="//span[@class='title']")
	WebElement productsPageTitle;
	
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartBtn;
	
	@FindBy(xpath="//div[contains(text(), 'Sauce Labs Backpack')]")
	WebElement backpackName;
	
	public ProductsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateProductsPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyBackpackName(){
		return backpackName.isDisplayed();
	}
	
	public String validateBackpackName(){
		String backpackName = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]")).getText();
		System.out.println(backpackName);
		return backpackName;
	}
	
	public void clickOnAddToCartBtn(){
		addToCartBtn.click();
	}
	
	public YourCartPage clickOnCartBtn(){
		cartBtn.click();
		return new YourCartPage();
	}

}
