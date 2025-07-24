package com.bdd.hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bdd.utils.DriverManager;
import com.bdd.utils.Screenshots;

import io.cucumber.java.*;

	public class Hooks {

	    @BeforeAll
	    public static void beforeAll() {
	        // Runs once before all scenarios
	        System.out.println("=== Starting test suite ===");
	    }

	    @Before
	    public void beforeScenario(Scenario scenario) {
	        // Runs before each scenario
	        DriverManager.getDriver();
	        System.out.println("Starting scenario: " + scenario.getName());
	    }

	    @AfterStep
	        public void afterStep(Scenario scenario) {
	            String stepName = scenario.getName() + "-" + scenario.getLine();
	            String screenshotPath = Screenshots.takeScreenshot(DriverManager.getDriver(), stepName);
	            
	            if (screenshotPath != null) {
	                // Attach screenshot to Cucumber report
	                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", stepName);
	            }
	    }

	    @After
	    public void afterScenario(Scenario scenario) {
	        // Runs after each scenario
	        System.out.println("Finished scenario: " + scenario.getName() + " - Status: " + scenario.getStatus());
	        DriverManager.quitDriver();
	    }

	    @AfterAll
	    public static void afterAll() {
	        System.out.println("=== Test suite completed ===");
	    }
	}


