package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='email' and @name='email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='passwd' and @name='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin' and @name='SubmitLogin']")
	WebElement Submit;
	
	public void Login(String uname, String pass){
		
		IndexPage ip = new IndexPage(driver);
		
		ip.loginClick();
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		
		Submit.click();
		
	}
}
