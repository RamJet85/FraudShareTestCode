package com.qa.FraudShare.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BaseTest;
import com.qa.FraudShare.utils.ExcelUtils;

public class SubmissionPageTest extends BaseTest{
	
	@BeforeClass
	public void IncidentSubmissionPageSetUp(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		submissionPage = dashBoard.clickOnIncidentTab();
			
	}
	
	@DataProvider
	public Object[][] getTestData(){
		return ExcelUtils.getTestData("IncidentSubmission");
	}
	
	@Test(dataProvider="getTestData")
	public void verifyIncidentSubmissionFromExcel(String PLI, String GORI, String DIS, String ACP, String ACM, String TR, String dateOI, String dateOD, String DTM,
			String Scheme, String TAV, String TAR, String Acc){
		
		submissionPage.incidentSubmissionFromExcelSheet(PLI, GORI, DIS, ACP, ACM, TR, dateOI, dateOD, DTM, Scheme, TAV, TAR, Acc);
		
		
	}
	
	

}
