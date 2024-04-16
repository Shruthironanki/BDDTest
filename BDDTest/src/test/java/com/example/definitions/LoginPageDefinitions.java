package com.example.definitions;

import io.cucumber.java.After;

import com.example.Utility.BrowserUtility;
import com.example.Utility.PropertiesFileReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.PageObjects.LoginPage;
	 
	public class LoginPageDefinitions {
		private WebDriver driver;
		PropertiesFileReader obj= new PropertiesFileReader();
		
	    @Given("User is on HRMLogin page")
	    public void loginTest() throws Throwable {
	 
	    	Properties properties=obj.getProperty(); 		
			driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
							    	
	        //driver.get(url);
	 
	    }
	 
	    @When("User enters username as {string} and password as {string}")
	    public void goToHomePage(String userName, String passWord) {
	    		    	
	    	new LoginPage(driver).Username.sendKeys(userName);
	    	new LoginPage(driver).Password.sendKeys(passWord);
	    	new LoginPage(driver).Submit.submit();
	        	
	    
	    }
	 
	    @Then("User should be able to login successfully and new page open")
	    public void verifyLogin() {
	 
	        String homePageHeading = new LoginPage(driver).homePageHeading.getText();
	 
	        //Verify new page - HomePage
	        Assert.assertEquals(homePageHeading, "Dashboard");
	 
	    }
	 
	    @Then("User should be able to see error message {string}")
	    public void verifyErrorMessage(String expectedErrorMessage) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	WebElement actualErrorMessageElement = wait.until(ExpectedConditions.visibilityOf((new LoginPage(driver).actualErrorMessage)));
	    	
	        String actualErrorMessage = actualErrorMessageElement.getText();
	 
	        // Verify Error Message
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	 
	    }
	 
	    @After
	    public void teardown() {
	 
	        driver.quit();
	    }
	 
	}
	

