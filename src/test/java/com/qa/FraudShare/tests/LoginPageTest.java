package com.qa.FraudShare.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.pages.LoginPage;

public class LoginPageTest{
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
			
	}
	
	@Test(priority=1)
	public void verifyloginPageTitleTest(){
		String title = loginPage.loginPageTitle();
		System.out.println("LoginPage title is: "+title);
		Assert.assertEquals(title, "Log in - FraudIdentityServer");
	}
	
	@Test(priority=2)
	public void verifyfraudShareLogoTest(){
		boolean flag = loginPage.fraudShareLogoIsDisplayed();
		System.out.println("FrauShareLogoIsDisplaying: "+flag);
	}
	
	@Test(priority=3)
	public void verifyLimraLogoTest(){
		boolean flag = loginPage.limraLogoIsDisplayed();
		System.out.println("LimraLogoIsDisplaying: "+flag);
	
	}
	
	@Test(priority=4)
	public void verifyLomaLogoTest(){
		boolean flag = loginPage.lomaLogoIsDisplayed();
		System.out.println("LomaLogoIsDisplaying: "+flag);
	
	}
	
	@Test(priority=5)
	public void verifyLoginPageHeaderTest(){
		String text = loginPage.getLoginHeadervalue();
		System.out.println("LoginPage Header text is: "+text);
		Assert.assertEquals(text, "Log in");
	}
	/*@DataProvider()
	public Object[][] getTestData(){
		return ExcelUtils.getTestData("Login");
	}*/
	
	@Test(priority=6)
	public void forgotUsernameLinkIsDisplayed(){
		String text = loginPage.getForgotUsernameLinkText();
		System.out.println("Forgot UserName text is: "+text);
		Assert.assertEquals(text, "Forgot your username?");
		
	}
	
	@Test(priority=7)
	public void forgotPasswordLinkIsDisplayed(){
		String text = loginPage.getForgotPasswordLinkText();
		System.out.println("Forgot UserName text is: "+text);
		Assert.assertEquals(text, "Forgot your password?");
			
	}
	
	@Test(priority=8)
	public void verifyLogintest(){
		loginPage.doFraudShareLogin(prop.getProperty("FraudUser"), prop.getProperty("password").trim());	
		//loginPage.doFraudShareLogin(username, pqsswd);
		
	}
	
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


