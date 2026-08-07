package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	private By menu = By.xpath("//ul[@id='side-menu']/li");
	private By eventOption = By.xpath("//span[@class=\"fa fa-plus-circle\"]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public int menuCount() {
		return driver.findElements(menu).size()-1;
		
	}
	
	public List<String> getMenuOptions() {
		List<String> menuList = new ArrayList<>();
		List<WebElement> menuOptions = driver.findElements(menu);
		for(WebElement element: menuOptions) {
			String str = element.getText();
			System.out.println(str);
			menuList.add(str);
		}
		
		return menuList;
	}

	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public String  getEventOption() {

		return driver.findElement(eventOption).getText();
	}
	
}
