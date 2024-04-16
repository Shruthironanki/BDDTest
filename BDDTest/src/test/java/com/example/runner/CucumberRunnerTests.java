package com.example.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
    
@CucumberOptions(features = {"src/test/resources/features"}, tags = "@Regression", glue = {"com.example.definitions"},
                 plugin = {})
    
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {    	
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

//    @Test(dataProvider = "features")    
//    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
//    	//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
//    }
//    
//    @DataProvider//(parallel=true)
//    public Object[][] features() {
//       /return testNGCucumberRunner.provideFeatures();    	
//    	 return testNGCucumberRunner.provideScenarios();
//    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {    	
        testNGCucumberRunner.finish();    
        
	
    }
    
}