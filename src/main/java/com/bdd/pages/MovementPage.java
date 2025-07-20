package com.bdd.pages;

import java.util.List;

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
	
	
	public MovementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyMovementTabIsSelected() {
		return movementTab.isDisplayed();
	}
	
	public int VerifyNumberofTanksinAllTanksTab() {
		System.out.println("Number of tanks in movement in movement page: " + alltanksinMovementlist.size());
		return alltanksinMovementlist.size();
	}
	

}
