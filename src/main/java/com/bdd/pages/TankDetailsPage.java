package com.bdd.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TankDetailsPage {
	WebDriver driver; 
	
	@FindBy(className = "breadcrumb-container")
	private WebElement tankdetailsHeader;
	
	@FindBy(id = "NavigationLinkInventoryAId")
	private WebElement inventorynavigationbutton;
	
	@FindBy(id = "NavigationLinkLevelAId")
	private WebElement levelnavigationbutton;
	
	@FindBy(id = "NavigationLinkTemperatureAId")
	private WebElement tempPressurenavigationbutton;
	
	@FindBy(id = "NavigationLinkAlarmLimitsAId")
	private WebElement alarmlimitsnavigationbutton;
	
	@FindBy (id = "TankDetailInventoryAId")
	private WebElement tankdetailInventorypanel;
	
	@FindBy(id = "ProductAId")
	private WebElement tankdetailInventorypanelProduct;
	
	@FindBy(xpath = "//*[@id =\"tankdetaillevel\"]/..")
	private WebElement tankdetaillevelpanel;
	
	@FindBy(id ="UllageAId")
	private WebElement tankdetaillevelpanelUllage;
	
	@FindBy(xpath= "//*[@id =\"tankdetailtemperature\"]/..")
	private WebElement tankdetailTempPressurepanel;
	
	@FindBy(id = "Avg_TempAId")
	private WebElement tankdetailTempPressurepanelAvgTemperature;
	
	@FindBy(xpath ="//*[@id =\"tankdetailalarmlimits\"]/..")
	private WebElement tankdetailAlarmLimitspanel;
	
	@FindBy(id = "HiHiAId")
	private WebElement tankdetailAlarmLimitspanelLevelHighHigh;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
	public TankDetailsPage(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public boolean VerifyTankDetailsPageisDisplayed() {
		return tankdetailsHeader.isDisplayed();
	}
	
	public void ClickonNavigationButtonInDetailsPage(String buttonName) {
		if(tankdetailsHeader.isDisplayed()) {
			switch (buttonName.toLowerCase()) {
			case "inventory":
				inventorynavigationbutton.click();
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				break;
			case "level":
				levelnavigationbutton.click();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				break;
			case "temperaturepressure":
				tempPressurenavigationbutton.click();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				break;
			case "alarmlimits":
				alarmlimitsnavigationbutton.click();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				break;
			default:
                throw new IllegalArgumentException("Button is not displayed: " + buttonName);
        }
			}
		else {
			System.out.println("Tank Details Page is not displayed");
		}
	}
	
	
	public boolean  VerifydetailsinTankDetails(String detailsTabName) {
		if(!tankdetailsHeader.isDisplayed()) {
			return false;
		}
		 try {
			switch(detailsTabName.toLowerCase()) {
			case "inventory":
				return tankdetailInventorypanel.isDisplayed()&& tankdetailInventorypanelProduct.isDisplayed();
			case "level":
				return tankdetaillevelpanel.isDisplayed() && tankdetaillevelpanelUllage.isDisplayed();
			case "temperaturepressure":
				return tankdetailTempPressurepanel.isDisplayed()&&tankdetailTempPressurepanelAvgTemperature.isDisplayed();
			case "alarmlimits":
				return tankdetailAlarmLimitspanel.isDisplayed()&& tankdetailAlarmLimitspanelLevelHighHigh.isDisplayed();
			default:
				throw new IllegalArgumentException("Tab is not displayed: " + detailsTabName);
				
			}
		 }
			catch (NoSuchElementException e) {
		        return false;
		}
		 }
		 
		
	

	}
	
	
	
	


