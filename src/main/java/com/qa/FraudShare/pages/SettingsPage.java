package com.qa.FraudShare.pages;

import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.utils.ElementUtils;

public class SettingsPage {
	
	private WebDriver driver;
	ElementUtils elementutils;
	
	public SettingsPage(WebDriver driver){
		this.driver = driver;
		elementutils = new ElementUtils(driver);
		//constructor
		System.out.println("text");
	}

}
