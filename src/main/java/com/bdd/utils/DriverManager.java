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
		                    driver.manage().window().maximize();
		                    break;
		                case "firefox":
		                	//String GeckoDriverPath = "C:\\Users\\Shreyasu\\Pooja\\WebAutomation\\RosemountTankMasterAT\\drivers\\geckodriver.exe";
		                	String GeckoDriverPath = currentDir + File.separator + "drivers" + File.separator + "geckodriver.exe";
			                System.setProperty("webdriver.gecko.driver", GeckoDriverPath);
		                    //WebDriverManager.firefoxdriver().setup();
		                    driver = new FirefoxDriver();
		                    driver.manage().window().maximize();
		                    break;
		                case "edge":
		                    //WebDriverManager.edgedriver().setup();
		                    String edgeDriverPath = currentDir + File.separator + "drivers" + File.separator + "msedgedriver.exe";
		                	//String edgeDriverPath = "C:\\Users\\Shreyasu\\Pooja\\WebAutomation\\RosemountTankMasterAT\\drivers\\msedgedriver.exe"; 
			                System.setProperty("webdriver.edge.driver", edgeDriverPath);
			                driver = new EdgeDriver();
		                    driver.manage().window().maximize();
		                    break;
		                default:
		                    throw new IllegalArgumentException("Browser not supported: " + browser);
		            }
		        }
		        return driver;
		    }
		 
		 
		 public static void quitDriver() {
		        if (driver != null) {
		            driver.quit();
		            driver = null;
		        }
		    }
		 
		 
		 

	}




