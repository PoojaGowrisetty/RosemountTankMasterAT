package com.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver driver;

    @FindBy(id = "EmailAId")
    private WebElement usernameField;

    @FindBy(id = "PasswordAId")
    private WebElement passwordField;

    @FindBy(id = "SignInButtonAId")
    private WebElement signinButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void EnterSignInDetails(String username, String password) {
    	usernameField.click();
    	usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        
    }
    
    public void ClickSignInButton() {
    	signinButton.click();
    }
}


