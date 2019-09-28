package com.Insane.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Insane.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@name='Login']")
	WebElement loginLink;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	WebElement profileLink;

	@FindBy(xpath = "//input[@name='password']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='username']")
	WebElement password;

	@FindBy(xpath = "// button[contains(text(),'Login')]")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'add movie')]")
	WebElement AddMovieLink;

	/**
	 * Verify user login
	 * 
	 */

	public void verifyUserLogin() throws InterruptedException {
		String loginInput = prop.getProperty("adminLogin");
		String passwordInput = prop.getProperty("adminPswd");
		loginLink.click();
		waitForElement(userName);
		userName.sendKeys(loginInput);
		password.sendKeys(passwordInput);
		loginButton.click();
		waitForPageToLoad();
		waitForElement(AddMovieLink);
	}

}
