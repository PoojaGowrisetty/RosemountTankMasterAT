package com.bdd.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MovementPage {
	
	WebDriver driver;
	
	@FindBy(id = "OverviewButtonId")
	private WebElement overviewTablink;

	@FindBy(id = "MovementButtonId")
	private WebElement movementTablink;
	
	@FindBy(id = "WatchlistButtonId")
	private WebElement watchlistTablink;

	@FindBy(id = "InventoryButtonId")
	private WebElement inventoryTablink;

	@FindBy(id = "ReportButtonId")
	private WebElement reportTablink;
	
	@FindBy(xpath = "//a[@class =\"router-link-exact-active active active-route\"]")
    private WebElement movementTab;
	
	@FindBy(css = "div.tank-card-container")
	private List<WebElement> alltanksinMovementlist;
	
	public WebElement getFlowRateofTank(String tankname) {
    	return driver.findElement(By.xpath("//*[@id=\"tankHeaderTitle_AId\" and contains(text(), \""+tankname+ "\")]/ancestor::div[@class=\"tank-card-container\"]//*[@id=\"Flow_RateAId\"]/div/span[1]/span[2]"));
    	
    }
	public WebElement getArrowofTank(String tankname) {
    	return driver.findElement(By.xpath("//*[@id=\"tankHeaderTitle_AId\" and contains(text(), \""+tankname+"\")]/ancestor::div[@class=\"tank-card-container\"]//*[@class = \"arrow-polygon\"]"));
    }
    
    
	
	
	public MovementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyMovementTabIsSelected() {
		return movementTab.isDisplayed() && driver.getCurrentUrl().contains("/movement"); 
		
	}
	
	public int VerifyNumberofTanksinMovementTanksTab() {
		System.out.println("Number of tanks in movement in movement page: " + alltanksinMovementlist.size());
		return alltanksinMovementlist.size();
	}
	
	public boolean VerifyFlowRateofTanksinMovementPage() {
		try {
		for (WebElement tank : alltanksinMovementlist) {
			if(tank.isDisplayed())
			{
			String tankname = tank.findElement(By.id("tankHeaderTitle_AId")).getText();
			double getflowRate = Double.parseDouble(getFlowRateofTank(tankname).getText().replace(",", ""));
			if (getflowRate == 0)
			{
				System.out.println("Flow Rate is 0.0 for the tank"+tankname);
				return false;
			}
			}
		}
			
		return true;
		}
		catch(TimeoutException e)
		{
			return false;
		}
	}
		
	
	
	public boolean GetFlowRateValueofTankAndVerifytheArrowDisplayedInRightDirection() {
		try {
		for (WebElement tank : alltanksinMovementlist) {
			if(tank.isDisplayed())
			{
			String tankname = tank.findElement(By.id("tankHeaderTitle_AId")).getText();
			double getflowRate = Double.parseDouble(getFlowRateofTank(tankname).getText().replace(",", ""));
			
			if (getflowRate < 0) {
				String arrowPoints = getArrowofTank(tankname).getAttribute("points");
				 if (!arrowPoints.contains("33,68")) {
	                    System.out.println("FAIL: Arrow not pointing down for negative flow in tank: " + tankname);
	                    return false;
	                }
								
			}
			else if (getflowRate > 0) {
				String arrowPoints = getArrowofTank(tankname).getAttribute("points");
				if(!arrowPoints.contains("33,25")) {
					{
	                    System.out.println("FAIL: Arrow not pointing up for positive flow in tank: " + tankname);
	                    return false;
	                }
				}
			 
			}
			}
		}
			return true;
		}catch(TimeoutException e) {
			return false;
		}
			}
	

}
