package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.utils.ElementUtils;

public class HelpPage {
	
	private WebDriver driver;
	ElementUtils elementUtils;

	
	By helpCenterLogo = By.xpath("//div[contains(text(),'Help Center')]");
	
    public HelpPage(WebDriver driver) {	
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		
	}
    
    public String helpPageHeaderText(){
    	if(elementUtils.isDisplayed(helpCenterLogo)){
    		return elementUtils.getText(helpCenterLogo);
    	}
    	 return null;
    		
    	}
    		
    	
    
    
}
