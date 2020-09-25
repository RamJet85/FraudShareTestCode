package com.qa.FraudShare.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BaseTest;

public class SettingsPageTest extends BaseTest{
	
	
	@BeforeClass
	public void settingsPageSetUp(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		settingsPage = dashBoard.clickOnSettingsTab();
			
	}
	
	@Test
	public void signUpForAlerts(){
		settingsPage.signupForAlertNotifications();
	}

}
