package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	// 1. By locators
	private By emailId  = By.xpath("//input[@type=\"email\"]");
	private By password = By.xpath("//input[@type='password']");
	private By loginBtn = By.xpath("//button[@type=\"submit\"]");
	private By lostPass = By.linkText("Lost password?");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isLostPassDisplayed() {
		return driver.findElement(lostPass).isDisplayed();
	}

	public void enterEmail(String un) {
		driver.findElement(emailId).sendKeys(un);
		
	}
	
	public void enterPass(String pass) {
		driver.findElement(password).sendKeys(pass);
		
	}
	
	public void clickLogfin() {
		driver.findElement(loginBtn).click();
		
	}
	
	public HomePage doLogin(String un, String pass) {
		
		driver.findElement(emailId).sendKeys(un);

		
		driver.findElement(password).sendKeys(pass);

		driver.findElement(loginBtn).click();
		
		return new HomePage(driver);
		
	}
	
	
	
}
