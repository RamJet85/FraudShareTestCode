package com.qa.FraudShare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BaseTest;
import com.qa.FraudShare.utils.Constants;
import com.qa.FraudShare.utils.ExcelUtils;

public class IncidentSubmissionTest extends BaseTest{
	

	@BeforeClass
	public void IncidentSubmissionPageSetUp(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		incidentSubmission = dashBoard.clickOnIncidentSubmissionTab();
			
	}
	
	@Test(priority=1)
	public void verifyIncidentSubmissionPageTilte(){
		String title = incidentSubmission.IncidentSubmissionPageTitle();
		System.out.println("IncidentPageTitle is: "+title);
		Assert.assertEquals(title, Constants.INCIDENT_PAGE_TITLE);
			
	}
	@Test(priority=2)
	public void verifyIncidentSubmissionValueTest(){
		String text = incidentSubmission.SingleIncidentSubmissionIsDisplayed();
		System.out.println("The value is: "+text);
		Assert.assertEquals(text, "Fraud Incident Submission");
	}
	@Test(priority=3)
	public void verifyBatchUploadValueTest(){
		String text = incidentSubmission.BatchUploadIsDisplayed();
		System.out.println("The value is: "+text);
		Assert.assertEquals(text, "Batch Upload");
	}
	
	@Test(priority=4)
	public void verifyProductLineTest(){
		int list = incidentSubmission.getProductLineDropdownlist();
		System.out.println(list);
		
	}
		
	@Test (priority=5)
	public void verifyIncidentSubmissionTest(){
		
		incidentSubmission.submitSingleIncident("Annuity", "Group", "Wire", "IVR", "Fax", "Bank Account Change", "09/10/2020",
				"09/13/2020", "Advisor", "Customer Impersonation", "TextContent", "200", "278",
				"WasAccountAccessedYes");  
	
	}
	
	@DataProvider
	public Object[][] getTestData(){
		return ExcelUtils.getTestData("IncidentSubmission");
	}
	
	@Test(priority =6,dataProvider="getTestData")
	public void verifyIncidentSubmissionFromExcel(String PLI, String GORI, String DIS, String ACP, String ACM, String TR, String dateOI, String dateOD, String DTM,
			String Scheme, String TAV, String TAR, String Acc){
		
		incidentSubmission.incidentSubmissionFromExcel(PLI, GORI, DIS, ACP, ACM, TR, dateOI, dateOD, DTM, Scheme, TAV, TAR, Acc);
		
		
	}
	
	@Test(priority=7)
	public void verifySubmitIncidentwithoutMandatoryValuesTest(){
		incidentSubmission.submitIncidentWithoutMandatoryValues();
	}

	
		
	}
	


