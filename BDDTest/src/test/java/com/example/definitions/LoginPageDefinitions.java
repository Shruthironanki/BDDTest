package com.example.definitions;

	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//import io.github.bonigarcia.wdm.WebDriverManager;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	//import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.Assert;
import org.testng.annotations.Test;

//import java.time.Duration;
	 
	public class LoginPageDefinitions {
	  public static WebDriver driver;
	   // public final static int TIMEOUT = 5;
	 
	    @Before
	    public void setUp() {
	    	
	    	System.out.println("abc");
	    	
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	//driver.manage().timeouts().implicitlyWait(());
	    	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	    	driver.manage().window().maximize();
//	    	
//	    	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\srava\\OneDrive\\Documents\\Test suites\\chrome-win64\\chrome-win64\\chrome.exe");
//	        ChromeOptions options = new ChromeOptions();
//	       options.setBinary("C:\\Users\\srava\\OneDrive\\Documents\\Test suites\\chrome-win64\\chrome-win64\\chrome.exe");
//	        options.addArguments("--remote-allow-origins=*");
//	        
//	        options.addArguments("--start-maximized");
//	        driver = new ChromeDriver(options);
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	        
//	       driver = new ChromeDriver(options);
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	 
	    }
	 
	    @Given("User is on HRMLogin page {string}")
	    public void loginTest(String url) {
	 
	        driver.get(url);
	 
	    }
	 
	    @When("User enters username as {string} and password as {string}")
	    public void goToHomePage(String userName, String passWord) {
	 
	        // login to application
	        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
	        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();
	 
	        // go the next page
	    }
	 
	    @Then("User should be able to login successfully and new page open")
	    public void verifyLogin() {
	 
	        String homePageHeading = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
	 
	        //Verify new page - HomePage
	        Assert.assertEquals(homePageHeading, "Dashboard");
	 
	    }
	 
	    @Then("User should be able to see error message {string}")
	    public void verifyErrorMessage(String expectedErrorMessage) {
	 
	        String actualErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();
	 
	        // Verify Error Message
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	 
	    }
	 
	    @After
	    public void teardown() {
	 
	        driver.quit();
	    }
	 
	}
	

