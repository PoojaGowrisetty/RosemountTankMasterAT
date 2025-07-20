package com.bdd.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/features",
				 glue = {"com.bdd.stepdefinitions","com.bdd.hooks"},
				 plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
				 monochrome = true,
				 tags = "@overviewpage")
public class TestRunner extends AbstractTestNGCucumberTests {
	// This class will be used to run the Cucumber tests with TestNG
	// The @CucumberOptions annotation specifies the configuration for the Cucumber tests
	// Features are located in src/test/resources/features
	// Step definitions are in com.bdd.stepdefinitions
	// Reports will be generated in target/cucumber-reports.html and target/cucumber.json
	// The tests will run with monochrome output and only the tests tagged with @smoke will be executed
	
	TestNGCucumberRunner testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

}
