package com.bdd.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WatchlistPage {
	
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
    private WebElement watchlistTab;
	
	public WebElement getTankName(String tankname) {
	    return driver.findElement(By.xpath(
	        "//*[@id=\"tankHeaderTitle_AId\" and contains(text(), \"" + tankname + "\")]"
	    ));
	
	
	}
	
	public WatchlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyWatchlistTabIsSelected() {
		return watchlistTab.isDisplayed();
	}
	
	public boolean VerifyTankIsDisplayed(String tankname) {
		WebElement tanknameIcon = getTankName(tankname);
		return tanknameIcon.isDisplayed();
		
	}
	

}
