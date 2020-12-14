package com.qa.FraudShare.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.pages.DashBoard;
import com.qa.FraudShare.pages.EditIncidentPage;
import com.qa.FraudShare.pages.LoginPage;

public class EditIncidentPageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	DashBoard dashBoard;
	EditIncidentPage editIncidentPage;
	
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}	
		
	@BeforeClass
	public void login(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		editIncidentPage = dashBoard.clickOnIncidentsTab();
		
	}
	
	@Test(priority=1)
	public void verifyEditIncidentTitleTest(){
		
		String text = editIncidentPage.incidentPageTitle();
		Assert.assertEquals(text, "Incidents - FraudShare");
		
	}
	
	@Test(priority=2)
	public void verifyPageHeaderTest(){
		String header = editIncidentPage.pageHeader();
		Assert.assertEquals(header, "Fraud Incidents");
	}
	
	
	@Test(priority=3)
	public void verifySearchFunctionality(){
		editIncidentPage.searchFunctionality();
	}
	@Test(priority=4)
	public void verifyeditIncidentLableTest(){
		String editLabel = editIncidentPage.EditIncidentLabelExists();
		Assert.assertEquals(editLabel, "EDIT INCIDENT");
	}
		
	@Test(priority=5, enabled= false)
	public void verifyDispositionLabelTest(){
		String b1 = editIncidentPage.DispositionLabelExists();
		System.out.println(b1);
		Assert.assertEquals(b1, "DISPOSITION");
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
	

}
