package com.bdd.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage {
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

	@FindBy(id = "alltanks_TabAId")
	private WebElement allTankTablink;

	@FindBy(xpath = "//div[@class=\"tabs-container\"]/div/ul/li")
	private List<WebElement> headerTabslist;

	@FindBy(css = "div.tank-card-container")
	private List<WebElement> alltankslist;

	@FindBy(id = "tankHeaderTitle_AId")
	private List<WebElement> alltanksNamelist;

	@FindBy(xpath = "//*[@class =\"arrow-polygon\"]")
	private List<WebElement> alltanksMovementTankslist;

	@FindBy(xpath = "//*[@id=\"WatchlistButtonId\"]//span/span")
	private WebElement watchlistcount;

	@FindBy(xpath = "//*[@class=\"expanded-tank\"]")
	private WebElement expandedtank;

	@FindBy(id = "TankDetailButtonAId")
	private WebElement tankDetailButton;
	
	@FindBy(id = "TankCommentButtonAId")
	private WebElement tankNoteButton;
	
	@FindBy(id = "textarea")
	private WebElement tankNoteField;
	
	@FindBy(id ="SaveButtonAId")
	private WebElement tankNoteSaveButton;
	
	@FindBy(id = "CloseButtonAId")
	private WebElement tankNoteCancelButton;
	
	@FindBy(id="ClearButtonAId")
	private WebElement tankNoteClearNoteButton;
	
	@FindBy(id = "comment-icon-AId")
	private List<WebElement> tankNoteCommentIcon;


	public WebElement getStarIcon(String tankname) {
		return driver.findElement(By.xpath("//*[@id=\"tankHeaderTitle_AId\" and contains(text(), \"" + tankname
				+ "\")]/ancestor::div[@class=\"tank-card-container\"]//*[@data-icon=\"star\"]"));
	}

	public WebElement getTank(String tankname) {
		return driver
				.findElement(By.xpath("//*[@id=\"tankHeaderTitle_AId\" and contains(text(), \"" + tankname + "\")]"));
	}

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyOverViewPageIsDisplayed() {
		return overviewTablink.isDisplayed();
	}

	public int VerifyNumberofHeaderTabsinOverviewPage() {
		return headerTabslist.size();
	}

	public void ClickonHeaderTab(String tabname) {
		try {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			if (tabname != null) {
				switch (tabname.toLowerCase()) {
				case "overview":
					overviewTablink.click();
					break;
				case "movement":
					movementTablink.click();
					wait.until(ExpectedConditions.urlContains("/movement"));
					break;
				case "watchlist":
					watchlistTablink.click();
					wait.until(ExpectedConditions.urlContains("/watchlist"));
					break;
				case "inventory":
					inventoryTablink.click();
					wait.until(ExpectedConditions.urlContains("/inventory"));
					break;
				case "reports":
					reportTablink.click();
					wait.until(ExpectedConditions.urlContains("/reports/"));
					break;
				default:
					throw new IllegalArgumentException("Tab not presnt: " + tabname);
				}
			}
		} catch (StaleElementReferenceException e) {
			PageFactory.initElements(driver, this);
			ClickonHeaderTab(tabname);

		}

	}

	public boolean verifyAllTanksAreDisplayed() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(alltankslist));
		if (alltankslist.isEmpty()) {
			System.out.println("No tanks are displayed.");
			return false;
		}
		for (WebElement tank : alltankslist) {
			if (!tank.isDisplayed()) {
				System.out.println("Not all tanks are displayed.");
				return false;
			}
		}
		System.out.println("All tanks are displayed.");
		return true;
		}

		catch (TimeoutException e) {
	        throw new NoSuchElementException("All tanks not displayed");
	}
	}

	public int VerifyNumberofTanksinAllTanksTab() {
		return alltankslist.size();
	}

	public int VerifyNumberofMovementTanksinAllTanksTab() {
		System.out.println("Number of tanks in movement in all tanks page: " + alltanksMovementTankslist.size());
		return alltanksMovementTankslist.size();

	}

	public void ClickonStarIconOfTank(String tankname) {
		WebElement starIconofTank = getStarIcon(tankname);
		String classValue = starIconofTank.getAttribute("id");
		if (!classValue.contains("fa-star-solid-AId")) {
			starIconofTank.click();
		}
	}

	public int GetWatchListCount() {
		int num = Integer.parseInt(watchlistcount.getText());
		return num;

	}

	public void ClickonTankcontainer(String tankname) {
		if (alltanksNamelist.size() > 0) {
			WebElement tank = getTank(tankname);
			tank.click();
		}

	}

	public boolean VerifyTankIsExpanded() {
		return expandedtank.isDisplayed();

	}
	
	public boolean VerifyTankDetailsButtonIsDisplayed() {
		return tankDetailButton.isDisplayed();
	}
	
	public void ClickTankDetailsButton() {
		if (tankDetailButton.isDisplayed()== true) {
			tankDetailButton.click();		
		}
		else {
			System.out.println("Tank Details is not displayed.");
		}
				
	}	
	public boolean VerifyTankNoteButtonIsDisplayed() {
		return tankNoteButton.isDisplayed();
	}
	
	public void ClickTankNoteButton() {
		 new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(tankNoteButton));
		if (tankNoteButton.isDisplayed()) {
			tankNoteButton.click();		
		}
		else {
			System.out.println("Tank Note is not displayed.");
		}
				
	}
	
	public void EnterDetailsinNoteInTankDetails(String notes) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(tankNoteField));
		tankNoteField.click();
		tankNoteField.sendKeys(notes);
	}
	
	public String GetTextFromNoteInTankDetails() {
		return tankNoteField.getText();
	}
	
	public void ClickonNoteButton(String buttonName) {
		try {
			if (buttonName != null) {
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
				switch (buttonName.toLowerCase()) {
				case "save":
					wait.until(ExpectedConditions.elementToBeClickable(tankNoteSaveButton));
					tankNoteSaveButton.click();
					 wait.until(ExpectedConditions.invisibilityOf(tankNoteSaveButton)); 
					break;
				case "cancel":
					tankNoteCancelButton.click();
					wait.until(ExpectedConditions.invisibilityOf(tankNoteCancelButton));
					break;
				case "clearnote":
					tankNoteClearNoteButton.click();
					wait.until(ExpectedConditions.elementToBeClickable(tankNoteField));
					tankNoteField.click();
					break;
				default:
					throw new IllegalArgumentException("Button not presnt: " + buttonName);
				}
			}
		} catch (TimeoutException e) {
	        throw new NoSuchElementException("Button '" + buttonName + "' was not clickable");
		}			
	}
	
	public boolean VerifyNoteIconisPresent() {
		try {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  
	           return tankNoteCommentIcon.size()>1;
	           
	    } 
		catch (TimeoutException e) {
	        return false;
	    }
	}
	

}
