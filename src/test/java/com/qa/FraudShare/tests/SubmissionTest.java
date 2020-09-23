package com.qa.FraudShare.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BaseTest;
import com.qa.FraudShare.utils.ExcelUtils;

public class SubmissionTest extends BaseTest {
	
	@BeforeClass
	public void IncidentSubmissionPageSetUp(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		SB = dashBoard.clickOnSubmissionTab();
			
	}
	
	@DataProvider
	public Object[][] getTestData(){
		return ExcelUtils.getTestData("IncidentSubmission");
	}
	
	@Test(dataProvider="getTestData")
	public void createIncident(String PLl, String GORI, String DIS,  String ARM, String AVM, String TR, String DTM, String Scheme,
			String TAV, String TAMR){
		SB.incidentSubmission(PLl,GORI,DIS,ARM, AVM,TR,DTM,Scheme,TAV,TAMR);
	}
	
	
	
	

}