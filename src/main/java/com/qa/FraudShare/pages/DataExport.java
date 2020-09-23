package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.utils.ElementUtils;
import com.qa.FraudShare.utils.JavaScriptUtils;

public class DataExport {
	
	//private WebDriver driver;
	ElementUtils elementutils;
	JavaScriptUtils jsUtil;
	
	//By locators
	By Header = By.xpath("(//*[contains(text(),'Data Export')])[position()='2']");
	By EIDHeader = By.xpath("//*[contains(text(),'Export Incidents Data')]");
	By ETIHeader = By.xpath("//*[contains(text(),'Export Threat Indicators')]");
	By EIDFromDate = By.id("txtFromDateData");
	By EIDEndDate = By.id("txtToDateData");
	By EFIDownload = By.xpath("//input[@id='btndownloadData']");
	By ETIFromDate = By.id("txtFromDateThreatData");
	By ETIEndDate = By.id("txtToDateThreatData");
	By ETIDownload = By.xpath("btndownloadThreatData");
	By SlectAllETI = By.xpath("//select[@id='threatIndicators']/option");
	By error = By.xpath("//*[contains(text(),'An error occurred while processing your request. Please Contact Support')]");
	
	public DataExport(WebDriver driver){
		//this.driver = driver;
		elementutils = new ElementUtils(driver);
		jsUtil = new JavaScriptUtils(driver);
		
	}
	
	public String datExportPageTitle(){
		return elementutils.waitForTitlePresent("Data Export - FraudShare", 10);
		
	}
	
	public String dataExportHeaderText(){
		if(elementutils.isDisplayed(Header)){
			return elementutils.getText(Header);
		}
		else{
			return null;
		}
	}
	
	public String exportIncidentDataText(){
		if(elementutils.isDisplayed(EIDHeader)){
			return elementutils.getText(EIDHeader);
		}
		return null;
	}
	
	public String exportThreatIndicatorsText(){
		if(elementutils.isDisplayed(ETIHeader)){
			return elementutils.getText(ETIHeader);
		}
		return null;
	}
	
		
	public void downloadExportIncidentsValidDates(String FromDate, String EndDate){
		
		jsUtil.sendKeysByJs("txtFromDateData", FromDate);
		jsUtil.sendKeysByJs("txtToDateData", EndDate);
		elementutils.doClick(EFIDownload);
		
		
	}
	
	public String downloadEIDReportwithInvalidDates(String FromDate, String EndDate){
		jsUtil.sendKeysByJs("txtFromDateData", FromDate);
		jsUtil.sendKeysByJs("txtToDateData", EndDate);
		elementutils.doClick(EFIDownload);
		if(elementutils.waitForElementPresent(error, 10).isDisplayed()){
			return elementutils.getText(error);
		}
		return null;
	}
			

}
