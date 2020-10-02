package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.utils.Constants;
import com.qa.FraudShare.utils.ElementUtils;
import com.qa.FraudShare.utils.JavaScriptUtils;

public class IncidentSubmission extends BasePage {
	
	private WebDriver driver;
	
	ElementUtils elementutils;
	JavaScriptUtils jsUtil;
	
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
	//By AccountWasAccessed = By.xpath("//b[contains(text(),'Account was accessed')]/..//following-sibling::div//td//input[@id='WasAccountAccessedYes']");
	By SubmitBtn = By.xpath("//div[@id='fraudDataSubmitButton']");
	By Close = By.xpath("//button[@id='closemodal']");
	By Additional = By.xpath("//textarea[@id='FraudDescription']");
	By IncidentNo = By.xpath("//*[contains(text(),'Incident Number')]");
	
	By dateOfInitial = By.id("DateOfInitialContact");
	By dateOfDetection = By.id("DateOfDetection");
	//By IncidentText = By.xpath("//td[contains(text(),'INCIDENT SUBMISSION SUMMARY')]/ancestor::tbody");
	By incidentText = By.xpath("//td[contains(text(),'Incident Number : ')]");
	
	
	// Mandatory fields error messages
	By IncidentsErrorsList = By.xpath("//div[@id='incidentTab']//p[@id]");
	
	public IncidentSubmission(WebDriver driver) {
		this.driver = driver;
		elementutils = new ElementUtils(driver);
		jsUtil = new JavaScriptUtils(driver);
	}
	
	public String IncidentSubmissionPageTitle(){
		return elementutils.waitForTitlePresent(Constants.INCIDENT_PAGE_TITLE, 10);
	}

	public String SingleIncidentSubmissionIsDisplayed() {

		if (elementutils.isDisplayed(SingleIncidentSubmission)) {
			return elementutils.getText(SingleIncidentSubmission);
		}
		return null;
	}

	public String BatchUploadIsDisplayed() {
		if (elementutils.isDisplayed(BatchUpload)) {
			return elementutils.getText(BatchUpload);
		}
		return null;
	}
	
	public int getProductLineDropdownlist(){
		return elementutils.getDropDownOptionsCountWithoutSelect(ProductLine);
					
	}
		
	public void submitSingleIncident(String PL, String GI, String Dis, String AP, String AM, String TT, String DIC, String DD,
			String DM, String FS, String text, String AV,String AR, String Accessed){
		
		elementutils.selectValueFromDropDownWithoutSelect(ProductLine, PL);
		elementutils.selectValueFromDropDownWithoutSelect(GroupORIndividual, GI);
		elementutils.selectValueFromDropDownWithoutSelect(Disbursement, Dis);
		elementutils.Single_Multi_AllSelectDropDown(AccessPoint, AP);
		elementutils.Single_Multi_AllSelectDropDown(AccessMethod, AM);
		elementutils.selectValueFromDropDownWithoutSelect(TransactionType, TT);
		jsUtil.sendKeysByJs("DateOfInitialContact", DIC);
		jsUtil.sendKeysByJs("DateOfDetection", DD);
		elementutils.selectValueFromDropDownWithoutSelect(DetectionMethod, DM);
		elementutils.selectValueFromDropDownWithoutSelect(FraudScheme, FS);
		elementutils.doSendKeys(Additional, text);
		elementutils.getElement(AccountValue).sendKeys(AV);
		elementutils.getElement(AmountRequested).sendKeys(AR);
		elementutils.selectRadioButtonFromList(AccountWasAccessed, "id", Accessed);
		elementutils.doClick(SubmitBtn);
	    elementutils.waitForElementPresent(incidentText, 10);
	    String incidentTextPopUp = elementutils.getText(incidentText);
	    System.out.println(incidentTextPopUp);
	    elementutils.waitForElementPresent(Close, 10).click();
				
	}
	
	public void incidentSubmissionFromExcel(String PL, String GI, String Dis, String AP, String AM, String TT, String dOI, String dOD, String DM,
			String FS, String AV, String AR, String WasAcc){
			
		elementutils.selectValueFromDropDownWithoutSelect(ProductLine, PL);
		elementutils.selectValueFromDropDownWithoutSelect(GroupORIndividual, GI);
		elementutils.selectValueFromDropDownWithoutSelect(Disbursement, Dis);
		elementutils.Single_Multi_AllSelectDropDown(AccessPoint, AP);
	    elementutils.Single_Multi_AllSelectDropDown(AccessMethod, AM);
		elementutils.selectValueFromDropDownWithoutSelect(TransactionType, TT);
		jsUtil.sendKeysByJs("DateOfInitialContact", dOI);
		jsUtil.sendKeysByJs("DateOfDetection", dOD);
		elementutils.selectValueFromDropDownWithoutSelect(DetectionMethod, DM);
		elementutils.selectValueFromDropDownWithoutSelect(FraudScheme, FS);
		elementutils.doSendKeys(AccountValue, AV);
		elementutils.getElement(AmountRequested).sendKeys(AR);

        elementutils.selectRadioButtonFromList(AccountWasAccessed, "id", WasAcc);
		elementutils.doClick(SubmitBtn);
		//elementutils.handleJavaScriptPopUp();
		String incidentTextPopUp = elementutils.getText(incidentText);
	    System.out.println(incidentTextPopUp);
		
		elementutils.waitForElementPresent(Close, 10).click();
		
		
	
		
	}
	
	public void submitIncidentWithoutMandatoryValues(){
		
		elementutils.doTextBoxClear(dateOfInitial);
		elementutils.handleJavaScriptPopUp();
		elementutils.doTextBoxClear(dateOfDetection);
		elementutils.handleJavaScriptPopUp();
		elementutils.doClick(SubmitBtn);
		elementutils.handleJavaScriptPopUp();
		elementutils.getListOfErrorMessagesText(IncidentsErrorsList);
		
	}
	
	public void submitIncidentWithInvalidDates(){
		
		
	}
	
		
		
	}
	

