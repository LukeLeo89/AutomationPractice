package com.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import generic.Config;

public class TestCase1 {
	WebDriver driver;
	
	@BeforeSuite
	public void setBrowser(){
		System.setProperty(Config.CHROMEDRIVERKEY, Config.CHROMEDRIVERVALUE);
		driver = new ChromeDriver();
	}
	
	@Test
	public void Login() throws IOException{
		
		driver.get(Config.WEBSITELINK);
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage(driver);
		
		String username = "xyz.abc@hij.com";
		String password = "abcdefg";
		
		lp.Login(username, password);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		AccountPage ap = new AccountPage(driver);
		
		js.executeScript("window.scrollBy(0,-900)");
		System.out.println(ap.getUserName());
		
		if(ap.getUserName().equals("abc xyz")){
			Reporter.log("Test successfull!!!!!!", true);
		}else{
			Reporter.log("Test Fail!!!!!!", true);
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		
		File destfile = new File("C:\\Users\\Luke.Sam\\Java Workspace\\AutomationPractice\\testdestfile.png");
		
		FileUtils.copyFile(sourcefile, destfile);
		
	}
	
	@AfterSuite
	public void closeBrowser(){
		driver.close();
	}
}
