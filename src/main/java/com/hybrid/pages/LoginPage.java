package com.hybrid.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.base.TestBase;

public class LoginPage extends TestBase {
	
	
	
	@FindBy(name = "user-name")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(name ="login-button")
	WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public ProductsPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new ProductsPage();
	}

}
