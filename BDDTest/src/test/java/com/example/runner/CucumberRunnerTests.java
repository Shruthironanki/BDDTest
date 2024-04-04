package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(features = {"src/test/resources/features"}, tags = "@Regression", glue = {"com.example.definitions"},
                 plugin = {})
    
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}