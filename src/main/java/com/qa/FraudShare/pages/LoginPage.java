package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.FraudShare.base.BasePage;
import com.qa.FraudShare.utils.Constants;
import com.qa.FraudShare.utils.ElementUtils;

public class LoginPage extends BasePage{
	
	private WebDriver driver; // no one can access this driver
	
	ElementUtils elementutils;
	
	//By locators
	
	By FruadShareLogo = By.xpath("(//a/img)[position()=1]");
	By LimraLogo = By.xpath("(//a[@class='navbar-brand']/img)[position()=1]");
	By LomaLogo = By.xpath("(//a[@class='navbar-brand']/img)[position()=2]");
	By LoginHeader = By.tagName("h1");
	By UserName = By.xpath("//input[@id='Input_Username']");
	By Password = By.xpath("//input[@id='Input_Password']");
	By LoginBtn = By.xpath("//button[@id='btnLogin']");
	By ForgotPassword = By.xpath("//a[text()='Forgot your password?']");
	By ForgotUsername = By.xpath("//a[text()='Forgot your username?']");
	By CopyRightText = By.xpath("//a[contains(text(),'Need support? Emai')]");
	By LogoutDropdown = By.xpath("//p[@id='dropdownMenuButton']");
	By Logout = By.xpath("//a[text()='Logout']");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	public String loginPageTitle(){
		return elementutils.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean fraudShareLogoIsDisplayed(){
		//return driver.findElement(FruadShareLogo).isDisplayed();
		return elementutils.isDisplayed(FruadShareLogo);
	}
	
	public boolean limraLogoIsDisplayed(){
		//return driver.findElement(LimraLogo).isDisplayed();
		return elementutils.isDisplayed(LimraLogo);
	}
	
	public boolean lomaLogoIsDisplayed(){
		//return driver.findElement(LomaLogo).isDisplayed();
		return elementutils.isDisplayed(LomaLogo);
	}
	
	public String getLoginHeadervalue(){
		
		if(elementutils.isDisplayed(LoginHeader)){
			return elementutils.getText(LoginHeader);
		}
		return null;
	}
	
	public DashBoard doFraudShareLogin(String un, String pwd){
	
		elementutils.doSendKeys(UserName, un);
		elementutils.doSendKeys(Password, pwd);
		elementutils.doClick(LoginBtn);
		return new DashBoard(driver);
	}
	
	public String getForgotPasswordLinkText(){
		if(elementutils.isDisplayed(ForgotPassword)){
			return elementutils.getText(ForgotPassword);
		}
		return null;
	}
	
	public String getForgotUsernameLinkText(){
		if(elementutils.isDisplayed(ForgotUsername)){
			return elementutils.getText(ForgotUsername);
		}
		return null;
	}
	
	public boolean copyRightstextisDisplayed(){
		return elementutils.isDisplayed(CopyRightText);
	}
	
	

}
