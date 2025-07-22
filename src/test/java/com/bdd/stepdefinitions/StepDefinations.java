package com.bdd.stepdefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.bdd.pages.*;

import com.bdd.utils.DriverManager;

public class StepDefinations {
	private WebDriver driver;
	private OverviewPage overviewpage;
	private MovementPage movementpage;
	private WatchlistPage watchlistpage;
	private TankDetailsPage tankdetailspage;

	public StepDefinations() {
		driver = DriverManager.getDriver();
		overviewpage = new OverviewPage(driver);
		movementpage = new MovementPage(driver);
		watchlistpage = new WatchlistPage(driver);
		tankdetailspage = new TankDetailsPage(driver);

	}

	@Then("the user should be redirected to the overview page")
	public void the_user_should_be_redirected_to_the_overview_page() {
		Assert.assertTrue(overviewpage.VerifyOverViewPageIsDisplayed(), "Overview page is not displayed");
	}
	
	@Given("I am on the OverviewPage")
	public void i_am_on_the_overview_page() {
		the_user_should_be_redirected_to_the_overview_page();
	}

	@Then("I should see the {int} header tabs")
	public void i_should_see_the_header_tabs(Integer numberoftabs) {
		Assert.assertEquals(overviewpage.VerifyNumberofHeaderTabsinOverviewPage(), numberoftabs);
	}

	@Then("I verify the alltanks are displayed")
	public void i_verify_the_alltanks_are_displayed() {
		overviewpage.verifyAllTanksAreDisplayed();
	}

	@Then("I verify number of tanks are {int}")
	public void i_verify_number_of_tanks_are(Integer nTanks) {
		Assert.assertEquals(overviewpage.VerifyNumberofTanksinAllTanksTab(), nTanks);
	}
	
	@Then("I verify the level of all the tanks is greater than zero")
	public void i_verify_the_level_of_all_the_tanks_is_greater_than_zero() {
		Assert.assertTrue(overviewpage.VerifyLevelofTanksinOverviewPage(),"Level of Tanks are zero");
	}
	
	@Then("I verify the FWL of all the tanks is {double} m")
	public void i_verify_the_fwl_of_all_the_tanks_is_m(Double double1) {
		 Assert.assertTrue(overviewpage.VerifyFWLofTanksinOverviewPage(double1),"FWL of Tanks are not given value");
	}

	
	@Then("I verify the TOV of all the tanks is greater than zero")
	public void i_verify_the_tov_of_all_the_tanks_is_greater_than_zero() {
		Assert.assertTrue(overviewpage.VerifyTOVofTanksinOverviewPage(),"TOV of Tanks are negative");
	}


	@Then("I verify the number of movement tanks in AllTanks tab")
	public void i_verify_the_number_of_movement_tanks_in_all_tanks_tab() {
		Assert.assertTrue(overviewpage.VerifyNumberofMovementTanksinAllTanksTab() >= 0, "Negative Movement tank in all page");
	}

	@Then("I verify the number of tanks in movement page")
	public void i_verify_the_number_of_tanks_in_movement_page() {
		Assert.assertEquals(overviewpage.VerifyNumberofMovementTanksinAllTanksTab(),
				movementpage.VerifyNumberofTanksinMovementTanksTab());

	}
	@Then("I verify the flowrate of all the tanks is non zero")
	public void i_verify_the_flowrate_of_all_the_tanks_is_non_zero() {
	    Assert.assertTrue(movementpage.VerifyFlowRateofTanksinMovementPage(),"Flow rate tank is 0 ");
	}
	
	@Then("I verify the the flow rate of all the tanks and matches the arrow direction")
	public void i_verify_the_the_flow_rate_of_all_the_tanks_and_matches_the_arrow_direction() {
		Assert.assertTrue(movementpage.GetFlowRateValueofTankAndVerifytheArrowDisplayedInRightDirection(),"Verfication failed");
	}

	@Then("the watchlist count should increase to {int}")
	public void the_watchlist_count_should_increase_to(Integer expectedcount) {
		Assert.assertEquals(overviewpage.GetWatchListCount(), expectedcount);
	}

	@Then("{string} should appear in my watchlist")
	public void should_appear_in_my_watchlist(String tankname) {
		Assert.assertTrue(overviewpage.GetWatchListCount() > 0, "Tanks count is null");
		Assert.assertTrue(watchlistpage.VerifyTankIsDisplayed(tankname), "Tanks are not displayed");
	}

	@Then("I verify tank container is expanded with details")
	public void i_verify_tank_container_is_expanded_with_details() {
		Assert.assertTrue(overviewpage.VerifyTankIsExpanded(), "tank is not expanded");
	}

	@Then("I verify details link is displayed")
	public void i_verify_details_link_is_displayed() {
		Assert.assertTrue(overviewpage.VerifyTankDetailsButtonIsDisplayed(), "Tank Details is not displayed");
	}

	@Then("I verify Note link is displayed")
	public void i_verify_note_link_is_displayed() {
		Assert.assertTrue(overviewpage.VerifyTankNoteButtonIsDisplayed(), "Tank Note is not displayed");
	}

	@When("I click on the Details button")
	public void i_click_on_the_details_button() {
		overviewpage.ClickTankDetailsButton();
	}

	@Then("I should navigate to tankdetails page")
	public void i_should_navigate_to_tankdetails_page() {
		Assert.assertTrue(tankdetailspage.VerifyTankDetailsPageisDisplayed(), "TankDetails Page is not displayed");
	}

	@When("I click on {string} button in tankdetails page")
	public void i_click_on_button_in_tankdetails_page(String tabname) {
		tankdetailspage.ClickonNavigationButtonInDetailsPage(tabname);

	}

	@Then("I verify {string} details displayed")
	public void i_verify_details_displayed(String detailstabname) {
		Assert.assertTrue(tankdetailspage.VerifydetailsinTankDetails(detailstabname), "Tank Details are incorrect");
	}

	@When("I click on the Note button")
	public void i_click_on_the_note_button() {
		overviewpage.ClickTankNoteButton();
	}

	@When("I type {string} in the Note")
	public void i_type_in_the_note(String note) {
		overviewpage.EnterDetailsinNoteInTankDetails(note);
	}

	@When("I click on the {string} button in Note")
	public void i_click_on_the_button_in_note(String buttonname) {
		overviewpage.ClickonNoteButton(buttonname);
	}

	@Then("I verify note icon is displayed")
	public void i_verify_note_icon_is_displayed() {
		Assert.assertTrue(overviewpage.VerifyNoteIconisPresent(), "Note Icon is not displayed");
	}

	@Then("I verify {string} is displayed in the Note")
	public void i_verify_is_displayed_in_the_note(String note) {
		Assert.assertEquals(note, overviewpage.GetTextFromNoteInTankDetails());
	}

	@Then("I verify note icon is not displayed")
	public void i_verify_note_icon_is_not_displayed() {
		Assert.assertFalse(overviewpage.VerifyNoteIconisPresent(), "Note Icon is displayed");
	}
		
	
	
	


}
