package com.bdd.utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
	import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

	public class Screenshots {
	    
	    private static final String SCREENSHOT_DIR = "target/screenshots/";
	    
	    public static String takeScreenshot(WebDriver driver, String stepName) {
	        try {
	            // Create screenshot directory if it doesn't exist
	            Path path = Paths.get(SCREENSHOT_DIR);
	            if (!Files.exists(path)) {
	                Files.createDirectories(path);
	            }
	            
	            // Generate timestamp and filename
	            String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date());
	            String fileName = String.format("%s-%s.png", stepName, timestamp);
	            
	            // Take screenshot
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            Path destination = Paths.get(SCREENSHOT_DIR + fileName);
	            Files.copy(screenshot.toPath(), destination);
	            
	            return destination.toString();
	        } catch (IOException e) {
	            System.err.println("Failed to take screenshot: " + e.getMessage());
	            return null;
	        }
	    }
	}


