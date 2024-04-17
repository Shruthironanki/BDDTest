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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.example.Listeners.ExtentReportListener;
import com.example.PageObjects.LoginPage;
	 
	public class LoginPageDefinitions extends ExtentReportListener
	{
		private WebDriver driver;
		PropertiesFileReader obj= new PropertiesFileReader();
		
	    @Given("User is on HRMLogin page")
	    public void loginTest() throws Throwable {
	 
	    	ExtentTest logInfo=null;
			try {
				test = extent.createTest(Feature.class, "Login to HRM Application");							
				test=test.createNode(Scenario.class, "Credentials Validation");						
				logInfo=test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
				Properties properties=obj.getProperty(); 		
				driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
				
				logInfo.pass("Opened chrome browser and entered HRMLogin page");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
				
			} 
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}	
	    		    	
	 
	    }
	 
	    @When("User enters username as {string} and password as {string}")
	    public void goToHomePage(String userName, String passWord) {
	    	
	    	ExtentTest logInfo=null;
			try {
										
				logInfo=test.createNode(new GherkinKeyword("When"), "User enters username and password");
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement UserName = wait.until(ExpectedConditions.visibilityOf((new LoginPage(driver).Username)));
				UserName.sendKeys(userName);
		    	new LoginPage(driver).Password.sendKeys(passWord);
		    	new LoginPage(driver).Submit.submit();
				logInfo.pass("User successfully entered username and password");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}
	    
	    }
	 
	    @Then("User should be able to login successfully and new page open")
	    public void verifyLogin() {
	    	
	    	ExtentTest logInfo=null;
			try {									
				logInfo=test.createNode(new GherkinKeyword("Then"), "User should be able to login successfully and new page open");
				
				 String homePageHeading = new LoginPage(driver).homePageHeading.getText();
				 
			        //Verify new page - HomePage
			      Assert.assertEquals(homePageHeading, "Dashboard");
			 				
				logInfo.pass("User logs in successfully.");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				System.out.println("closing browser");
				driver.quit();
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}  	
	    	
	        }
	 
	    @Then("User should be able to see error message {string}")
	    public void verifyErrorMessage(String expectedErrorMessage) {
	    	
	    	ExtentTest logInfo=null;
			try {									
				logInfo=test.createNode(new GherkinKeyword("Then"), "User should be able to see error message");
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
		    	WebElement actualErrorMessageElement = wait.until(ExpectedConditions.visibilityOf((new LoginPage(driver).actualErrorMessage)));
		    	
		        String actualErrorMessage = actualErrorMessageElement.getText();
		 
		        // Verify Error Message
		        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
				
				logInfo.pass("Validated Error Message");
				//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				System.out.println("closing browser");
				driver.quit();
				
			} catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);			
			}  	
	 
	    }


	 
	}
	

