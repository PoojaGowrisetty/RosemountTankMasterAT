package com.bdd.utils;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


	public class DriverManager {
		 private static WebDriver driver;
		 static String currentDir = System.getProperty("user.dir"); 

		 public static WebDriver getDriver() {
		        if (driver == null) {
		        	String browser = ConfigManager.getProperty("browser");
		            switch (browser.toLowerCase()) {
		                case "chrome":
		                    WebDriverManager.chromedriver().setup();
		                    driver = new ChromeDriver();		                   
		                    break;
		                case "firefox":
		                	String GeckoDriverPath = currentDir + File.separator + "drivers" + File.separator + "geckodriver.exe";
			                System.setProperty("webdriver.gecko.driver", GeckoDriverPath);
		                    //WebDriverManager.firefoxdriver().setup();
		                    driver = new FirefoxDriver();
		                    break;
		                case "edge":
		                    //WebDriverManager.edgedriver().setup();
		                    String edgeDriverPath = currentDir + File.separator + "drivers" + File.separator + "msedgedriver.exe";
			                System.setProperty("webdriver.edge.driver", edgeDriverPath);
			                driver = new EdgeDriver();
		                    break;
		                default:
		                    throw new IllegalArgumentException("Browser not supported: " + browser);
		            }
		        }
		        driver.manage().window().maximize();
		        return driver;
		    }
		 
		 
		 public static void quitDriver() {
		        if (driver != null) {
		            driver.quit();
		            driver = null;
		        }
		    }
		 
		 
		 

	}




