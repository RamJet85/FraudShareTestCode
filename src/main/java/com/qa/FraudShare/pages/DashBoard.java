package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.utils.Constants;
import com.qa.FraudShare.utils.ElementUtils;

public class DashBoard {
	
	private WebDriver driver;
	ElementUtils elementutils;
	
	//By locators
	
	By TrendingChartHeader = By.xpath("//div[contains(text(),'Daily Incident Intensity')]");
	By IncidentSubmission = By.xpath("//span[contains(text(),'INCIDENT SUBMISSION')]");
	By Settings = By.xpath("//span[contains(text(),'SETTINGS')]");
	By DataExport = By.xpath("//span[contains(text(),'DATA EXPORT')]");
	By help = By.xpath("//span[contains(text(),'HELP')]");
	By Search = By.xpath("//input[@id='txtFilter']");
	By TextBox = By.xpath("//div[@class='input-group-text small-textBox']");
	By TI = By.xpath("//div[contains(text(),'# of Threat Indicators : 0')]");
	By Companies = By.xpath("//div[contains(text(),'# of Companies : 0')]");
	
	public DashBoard(WebDriver driver){
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	
	public String dashBoardTitle(){
		return elementutils.waitForTitlePresent(Constants.DASHBOARD_PAGE_TITLE, 10);
	}
	
	public String TrendingChartsHeaderValue(){
		if(elementutils.isDisplayed(TrendingChartHeader)){
		return elementutils.getText(TrendingChartHeader);
			
		}
		return null;
	}
	
	public IncidentSubmission clickOnIncidentSubmissionTab(){
		
		elementutils.waitForElementToBeClickable(IncidentSubmission, 10).click();
		return new IncidentSubmission(driver);
	
	}
	
	public SubmissionPage clickOnIncidentTab(){
		
		elementutils.waitForElementToBeClickable(IncidentSubmission, 10).click();
		return new SubmissionPage(driver);
	}
	
        
    public DataExport clickOnDataExportTab(){
    	elementutils.waitForElementToBeClickable(DataExport, 10).click();
    	return new DataExport(driver);
    }
    
    public SettingsPage clickOnSettingsTab(){
    	elementutils.waitForElementToBeClickable(Settings, 10).click();
    	return new SettingsPage(driver);
    }
    
    public HelpPage clickOnHelpTab(){
    	elementutils.waitForElementToBeClickable(help, 10).click();
    	return new HelpPage(driver);
    }
    
    public String searchFunctionality(String data){
    	elementutils.doSendKeys(Search,data);
    	elementutils.doClick(TextBox);
    	return elementutils.waitForElementPresent(TI, 10).getText();
    	
    }
	
	

}
