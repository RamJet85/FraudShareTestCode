package com.qa.FraudShare.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.FraudShare.pages.DashBoard;
import com.qa.FraudShare.pages.DataExport;
import com.qa.FraudShare.pages.IncidentSubmission;
import com.qa.FraudShare.pages.LoginPage;
import com.qa.FraudShare.pages.SettingsPage;
import com.qa.FraudShare.pages.SubmissionPage;

public class BaseTest {
		
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public DashBoard dashBoard;
	public IncidentSubmission incidentSubmission;
	public DataExport dataExport;
	public SettingsPage settingsPage;
	public SubmissionPage submissionPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
			
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}

}
