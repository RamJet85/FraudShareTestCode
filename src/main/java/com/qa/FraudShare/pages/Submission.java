package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.utils.ElementUtils;
import com.qa.FraudShare.utils.JavaScriptUtils;

public class Submission extends BasePage {
 
	private WebDriver driver;
	ElementUtils elementutils;
	JavaScriptUtils jsutils;
	
	By SingleIncidentSubmission = By.xpath("//button[@id='incidentLnk']");
	By BatchUpload = By.xpath("//button[@id='uploadLnk']");
	By ProductLine = By.xpath("//select[@id='ProductLineId']/option");
	By GroupORIndividual = By.xpath("//select[@id='GrpIndvdlProduct']/option");
	By Disbursement = By.xpath("//select[@id='RequestDisburseMethodId']/option");
	By AccessPoint = By.xpath("//select[@id='AccessPointIdList']/option");
	By AccessMethod = By.xpath("//select[@id='AccessMethodIdList']/option");
	By TransactionType = By.xpath("//select[@id='TransactionTypeIdList']/option");
	By DetectionMethod = By.xpath("//select[@id='DetectionMethodIdList']/option");
	By FraudScheme = By.xpath("//select[@id='FraudSchemeId']/option");
	By AccountValue = By.cssSelector("input#TotalAccountValue");
	By AmountRequested = By.cssSelector("input#AmountRequested");
	By AccountWasAccessed = By.xpath("//b[contains(text(),'Account was accessed')]/..//following-sibling::div//td//input[@type='radio']");
	By SubmitBtn = By.xpath("//div[@id='fraudDataSubmitButton']");
	By Close = By.xpath("//button[@id='closemodal']");
	By Additional = By.xpath("//textarea[@id='FraudDescription']");
	By date = By.id("DateOfInitialContact");
	
	public Submission(WebDriver driver){
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	public void incidentSubmission(String PL, String GI, String Dis, String AP, String AM, String TT, String DM, String FS, String AV,
			String AR){
		
		
		elementutils.selectValueFromDropDownWithoutSelect(ProductLine, PL);
		elementutils.selectValueFromDropDownWithoutSelect(GroupORIndividual, GI);
		elementutils.selectValueFromDropDownWithoutSelect(Disbursement, Dis);
		elementutils.Single_Multi_AllSelectDropDown(AccessPoint, AP);
		elementutils.Single_Multi_AllSelectDropDown(AccessMethod, AM);
		elementutils.selectValueFromDropDownWithoutSelect(TransactionType, TT);
		jsutils.sendKeysByJs("DateOfInitialContact", "18/15/2019");
		
		
		elementutils.selectValueFromDropDownWithoutSelect(DetectionMethod, DM);
		elementutils.selectValueFromDropDownWithoutSelect(FraudScheme, FS);
		elementutils.getElement(AccountValue).sendKeys(AV);
		elementutils.getElement(AmountRequested).sendKeys(AR);

        elementutils.selectRadioButtonFromList(AccountWasAccessed, "id", "WasAccountAccessedYes");
		elementutils.doClick(SubmitBtn);
		elementutils.waitForElementPresent(Close, 10).click();
		
		
		
		
		
		
		
		
		
	}


}
