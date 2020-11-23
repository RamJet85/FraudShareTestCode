package com.qa.FraudShare.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.pages.DashBoard;
import com.qa.FraudShare.pages.DataExport;
import com.qa.FraudShare.pages.LoginPage;
import com.qa.FraudShare.utils.ExcelUtils;

public class DataExportTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	DashBoard dashBoard;
	DataExport dataExport;
	
	
	@BeforeTest
	public void setup(){
		 basePage = new BasePage();
		 prop =  basePage.init_properties();
		 driver = basePage.init_driver(prop);
		 loginPage = new LoginPage(driver);
		 
	}
	
	@BeforeClass
	public void login(){
		
		dashBoard = loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password"));
		dataExport = dashBoard.clickOnDataExportTab();
		
	}
	
	@Test(priority=1)
	public void verifyDataExportTitleTest(){
		
		String text = dataExport.datExportPageTitle();
		Assert.assertEquals(text, "Data Export - FraudShare" );
		
	}
	
	@Test(priority=2)
	public void verifyHeaderTest(){
		String text = dataExport.dataExportHeaderText();
		Assert.assertEquals(text, "Data Export" );

	}
	
	@Test(priority=3)
	public void verifyEIDTest(){
		String text = dataExport.exportIncidentDataText();
		Assert.assertEquals(text, "Export Incidents Data" );

	}
	
	@Test(priority=4)
	public void verifyETITest(){
		String text = dataExport.exportThreatIndicatorsText();
		Assert.assertEquals(text, "Export Threat Indicators" );

	}
	
	@DataProvider
	public Object[][] getExportIncidentsData(){
		return ExcelUtils.getTestData("ExportIncidents");
	}
	
	@Test(priority=5, dataProvider="getExportIncidentsData")
	public void verifyEIDdownload(String st, String ed){
				
		dataExport.downloadExportIncidentsValidDates(st, ed);

	}
	
	@Test(priority=6)
	public void backTest(){
		dataExport.back();
	}
	
	@Test(priority=7)
	public void verifyEIDwithInvalid() {
		String text = dataExport.downloadEIDReportwithInvalidDates("12/65/2024", "12/65/2039");
		System.out.println(text);
		Assert.assertEquals(text, "An error occurred while processing your request. Please Contact Support");
		
	}
	@Test(priority=8)
	public void backTest1(){
		dataExport.back();
	}
	@Test(priority=9)
	public void verifyAddressToolTipText(){
		String text = dataExport.getAddresstoolTipText();
		System.out.println(text);
		Assert.assertEquals(text, "Addresses created or updated during the selected "
				+ "date range will be exported in a typical address format with each "
				+ "address component in a separate field.");
	}
	
	@DataProvider
	public Object[][] getTiData(){
	    return ExcelUtils.getTestData("ExportThreat");
		
	}
	@Test(dataProvider="getTiData")
	public void verifyExportTiTest(String fd, String ed, String threats){
		dataExport.downloadExportThreatIndicatorsWithValidDates( fd,  ed,  threats);
	}
	
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}

	
}


