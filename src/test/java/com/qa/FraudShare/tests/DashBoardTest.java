package com.qa.FraudShare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BaseTest;
import com.qa.FraudShare.utils.Constants;

public class DashBoardTest extends BaseTest{
	
	@BeforeClass
	public void DashBoardSetup(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyDashBoardTitleTest(){
		
		String text = dashBoard.dashBoardTitle();
		Assert.assertEquals(text, Constants.DASHBOARD_PAGE_TITLE);
		
	}
	
	@Test
	public void verifyTrendingChartsHeaderTest(){
		String text = dashBoard.TrendingChartsHeaderValue();
		Assert.assertEquals(text, "Daily Incident Intensity");
	}
	
	@Test
	public void verifyWSearchFunctionality(){
		String text =dashBoard.searchFunctionality("TEst engineer");
		System.out.println("The incident text is: "+text);
		Assert.assertEquals(text, "# of Threat Indicators : 0");
	}

}
