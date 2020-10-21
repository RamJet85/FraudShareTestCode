package com.qa.FraudShare.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.base.BaseTest;
import com.qa.FraudShare.pages.LoginPage;

public class HelpPageTest extends BaseTest {
	
		
	
	@BeforeTest
	public void setup(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
			
	}

	@BeforeClass
	public void clickOnHelpPageTab(){
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		helpPage = dashBoard.clickOnHelpTab();
		
	}
	
	@Test
	public void verifyHelpPageHeaderTextTest(){
		String text =helpPage.helpPageHeaderText();
		System.out.println(text);
		
	}
}
