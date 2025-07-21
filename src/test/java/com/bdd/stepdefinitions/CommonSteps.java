package com.bdd.stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.bdd.pages.*;
import com.bdd.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {
	 private WebDriver driver;	
	 private OverviewPage overviewpage;
	 private MovementPage movementpage;
	 private WatchlistPage watchlistpage;
	 private InventoryPage inventorypage;
	 private ReportsPage reportspage;
	 
	 public CommonSteps() {
		 driver = DriverManager.getDriver();
		 overviewpage = new OverviewPage(driver);
		 movementpage = new MovementPage(driver);
		 watchlistpage = new WatchlistPage(driver);
		 inventorypage = new InventoryPage(driver);
		 reportspage = new ReportsPage(driver);
	 }
		 
	       
	 @When("I click on the {string} tab")
		public void i_click_on_the_tab(String string) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    overviewpage.ClickonHeaderTab(string);
		}
	 
	 @Then("I should navigate to {string} page")
		public void i_should_navigate_to_page(String tabName) {
			if (tabName != null) {
				switch (tabName.toLowerCase()) {
				case "overview":
					Assert.assertTrue(overviewpage.VerifyOverViewPageIsDisplayed(), "Overview page is not displayed"); 
					break;
				case "movement":
					Assert.assertTrue(movementpage.VerifyMovementTabIsSelected(), "Movement page is not displayed");
					break;
				case "watchlist":
					Assert.assertTrue(watchlistpage.VerifyWatchlistTabIsSelected(), "Watchlist page is not displayed");
					break;
				case "inventory":
					Assert.assertTrue(inventorypage.VerifyInventoryTabIsSelected(), "Inventory page is not displayed");
					break;
				case "reports":
					Assert.assertTrue(reportspage.VerifyReportsTabIsSelected(), "Reports page is not displayed");
					break;
				default:
					throw new IllegalArgumentException("Tab not presnt: " + tabName);
				}
			}
				
		}
	 
	    @When("I click the star icon for {string}")
		public void i_click_the_star_icon_for(String tankname) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    overviewpage.ClickonStarIconOfTank(tankname);
		}
	    
	    @When("I click the {string} container")
		public void i_click_the_container(String tankname) {
		    overviewpage.ClickonTankcontainer(tankname);
		}
	 
	 

}
