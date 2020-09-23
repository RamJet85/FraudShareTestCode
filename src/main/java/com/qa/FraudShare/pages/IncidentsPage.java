package com.qa.FraudShare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IncidentsPage {
	
	private WebDriver driver;
	
	public IncidentsPage(WebDriver driver){
		this.driver = driver;
		System.out.println("driver");
		
	}

	By name = By.xpath("gff");
}
