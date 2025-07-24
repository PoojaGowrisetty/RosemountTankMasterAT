package com.bdd.stepdefinitions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import com.bdd.pages.LoginPage;
import com.bdd.utils.ConfigManager;
import com.bdd.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
	private WebDriver driver;
	private LoginPage loginPage;
	
 public LoginSteps() {
	 driver = DriverManager.getDriver();
     loginPage = new LoginPage(driver);
 }
 

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver.get(ConfigManager.getProperty("base_url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@When("the user enters a valid username and password")
	public void the_user_enters_a_valid_username_and_password() {
		String username = ConfigManager.getProperty("username");
		String password = ConfigManager.getProperty("password");
		loginPage.EnterSignInDetails(username, password);
	}

	@When("clicks the login button")
	public void clicks_the_login_button() {
		loginPage.ClickSignInButton();
	}
	
	@Given("User is SignedIn to RosemountTankMaster Page")
	public void user_is_signedIn_to_rosemounttankMaster_page() {
		the_user_is_on_the_login_page();
		the_user_enters_a_valid_username_and_password();
		clicks_the_login_button();

	}


}
