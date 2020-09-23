package com.qa.FraudShare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BaseTest;
import com.qa.FraudShare.utils.Constants;

public class IncidentSubmissionTest extends BaseTest{
	

	@BeforeClass
	public void IncidentSubmissionPageSetUp(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		IS = dashBoard.clickOnIncidentSubmissionTab();
			
	}
	
	@Test(priority=1)
	public void verifyIncidentSubmissionPageTilte(){
		String title = IS.IncidentSubmissionPageTitle();
		System.out.println("IncidentPageTitle is: "+title);
		Assert.assertEquals(title, Constants.INCIDENT_PAGE_TITLE);
			
	}
	@Test(priority=2)
	public void verifyIncidentSubmissionValueTest(){
		String text = IS.SingleIncidentSubmissionIsDisplayed();
		System.out.println("The value is: "+text);
		Assert.assertEquals(text, "Fraud Incident Submission");
	}
	@Test(priority=3)
	public void verifyBatchUploadValueTest(){
		String text = IS.BatchUploadIsDisplayed();
		System.out.println("The value is: "+text);
		Assert.assertEquals(text, "Batch Upload");
	}
	
	@Test(priority=4)
	public void verifyProductLineTest(){
		int list = IS.getProductLineDropdownlist();
		System.out.println(list);
		
	}
		
	@Test (priority=5)
	public void verifyIncidentSubmissionTest(){
		
		String text = IS.submitSingleIncident("Annuity", "Group", "Wire", "IVR", "Fax", "Bank Account Change", "09/10/2020",
				"09/13/2020", "Advisor", "Customer Impersonation", "TextContent", "200", "278");
		System.out.println(text);
       
	
	}

	
		
	}
	


