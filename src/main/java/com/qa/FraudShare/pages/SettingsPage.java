package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.utils.ElementUtils;

public class SettingsPage extends BasePage{
	
	private WebDriver driver;
	ElementUtils elementutils;
	
	//By locators
	By CheckBox = By.xpath("//input[@id='SignForAlert1']");
	By SaveButton = By.xpath("//div[contains(text(),'SAVE')]");
	
	
	public SettingsPage(WebDriver driver){
		this.driver = driver;
		elementutils = new ElementUtils(driver);
				
	}
	
	public void signupForAlertNotifications(){
		if(driver.findElement(CheckBox).isSelected()){
			driver.findElement(CheckBox).click();
		}
		else {
			driver.findElement(CheckBox).click();
		}
		
	}
	
	
	

}
