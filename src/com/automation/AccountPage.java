package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	
	public AccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement accountname;
	
	public String getUserName(){
		return accountname.getText();
	}
	
}
