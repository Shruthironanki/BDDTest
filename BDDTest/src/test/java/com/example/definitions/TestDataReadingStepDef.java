package com.example.definitions;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.example.Listeners.ExtentReportListener;
import com.example.PageObjects.LoginPage;
import com.example.Utility.BrowserUtility;
import com.example.Utility.ExcelHandler;
import com.example.Utility.PropertiesFileReader;
import com.example.Utility.TestDataHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class TestDataReadingStepDef extends ExtentReportListener
{
	PropertiesFileReader obj= new PropertiesFileReader();
	
	TestDataHandler testdata=new TestDataHandler();
	
	@Given("^Read test data for testcase_(\\d+)$")
	public void read_test_data_for_testcase_(int arg1) throws Throwable 
	{
		
		ExtentTest logInfo=null;
		try {
			test = extent.createTest(Feature.class, "Login to HRM Application");							
			test=test.createNode(Scenario.class, "Credentials Validation");						
			logInfo=test.createNode(new GherkinKeyword("Given"), "Reads test data for testcase");
			Properties properties=obj.getProperty(); 		
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(properties.getProperty("testdatafilepath"), properties.getProperty("sheetname"), "TestCase_001");
			System.out.println(TestDataInMap.get("Skill_7"));
			
			testdata.setTestDataInMap(TestDataInMap);	
			
			
			logInfo.pass("Successfully reads test data for testcase");
			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
			
		} 
		catch (AssertionError | Exception e) {
			
			logInfo.fail("User unable to read test data");
						
		}	
		
	}
	
	@When("^Read test data for skill two$")
	public void read_test_data_for_skill_two() throws Throwable
	{
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("When"), "Read test data for skill two");
			
			Map<String,String> testDataInMap=testdata.getTestDataInMap();
			System.out.println(testDataInMap.get("Skill_2"));
			
			logInfo.pass("User successfully reads test data for skill two");
			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			logInfo.fail("User unable to read test data for skill two");			
		}
		
		
		
	}

	@Then("^Read test data for skill Three$")
	public void read_test_data_for_skill_Three() throws Throwable 
	{
		ExtentTest logInfo=null;
		try {
									
			logInfo=test.createNode(new GherkinKeyword("Then"), "Read test data for skill three");
			
			Map<String,String> testDataInMap=testdata.getTestDataInMap();
			System.out.println(testDataInMap.get("Skill_3"));
			
			logInfo.pass("User successfully reads test data for skill three");
			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			
		} catch (AssertionError | Exception e) {
			logInfo.fail("User unable to read test data for skill three");			
		}
				
		
	}	

}
