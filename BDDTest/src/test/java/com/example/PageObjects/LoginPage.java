package com.example.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using ="//input[@name='username']")
	public WebElement Username;
		
	@FindBy(how=How.XPATH,using ="//input[@name='password']")
	public WebElement Password;
	
	@FindBy(how=How.XPATH,using ="//*[@class='oxd-form']/div[3]/button")
	public WebElement Submit;
	
	@FindBy(how=How.XPATH,using ="//*[@class='oxd-topbar-header-breadcrumb']/h6")
	public WebElement homePageHeading;
	
	@FindBy(how=How.XPATH,using ="//*[@class='orangehrm-login-error']/div[1]/div[1]/p")
	public WebElement actualErrorMessage;

	
	
}
