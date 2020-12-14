package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.utils.ElementUtils;

public class EditIncidentPage {
	
	WebDriver driver;
	ElementUtils elementutils; 
	
	
	private By fraudIncidentsHeader = By.xpath("//div[contains(text(),'Fraud Incidents')]");
	private By searchFilter = By.xpath("//input[@id='txtFilter']");
	By searchButton = By.xpath("(//input[@id='txtFilter']/..//child::div)[position()=1]");
	By searchValue = By.xpath("//td[contains(text(),'1004512')]");
	By editIncident = By.xpath("//input[@id='editOn']");
	By disPosition = By.xpath("//input[@id='btnDisposition']");
	By deleteIncident = By.xpath("//button[@id='btnDel']");
	
	
	public EditIncidentPage(WebDriver driver){
		
		this.driver = driver;
		elementutils = new ElementUtils(driver);
		
	}
	
	public String incidentPageTitle(){
		return elementutils.waitForTitlePresent("Incidents - FraudShare", 10);
	}
	
	public String pageHeader(){
		if(elementutils.isDisplayed(fraudIncidentsHeader)){
			return elementutils.getText(fraudIncidentsHeader);
		}
		return null;
	}
	
	public String EditIncidentLabelExists(){
		
		if(elementutils.isDisplayed(editIncident)){
			return elementutils.getText(editIncident);
		}
		return null;	
	}
	
	public void searchFunctionality(){
		elementutils.doSendKeys(searchFilter, "1004512");
		elementutils.doClick(searchButton);
		elementutils.clickWhenReady(searchValue, 15);
	}
	
	public String DispositionLabelExists(){
		
		elementutils.waitForElementPresent(disPosition, 10);
		if(elementutils.isDisplayed(disPosition)){
			return elementutils.getText(disPosition);
		}
		return null;
	}
	 
	public String DeleteIncidentLabelExists(){
		elementutils.waitForElementPresent(editIncident, 10);
		if(elementutils.isDisplayed(deleteIncident)){
			return elementutils.getText(deleteIncident);
		}
		return null;
	}
	
}
