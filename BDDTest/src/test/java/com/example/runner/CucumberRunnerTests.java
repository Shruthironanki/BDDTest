package com.example.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = {"src/test/resources/features"}, 
				glue = {"com.example.definitions"},
				tags = "@Regression")
				

				
    
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {    	
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {    	
        testNGCucumberRunner.finish();    
        

    }
    
}