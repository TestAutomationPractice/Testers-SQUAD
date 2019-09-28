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

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	WebElement profileLink;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(),'add movie')]")
	WebElement AddMovieLink;

	@FindBy(xpath = "//button[contains(text(),'#')]")
	WebElement HashButton;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutButton;

	/**
	 * Verify user login
	 * 
	 */

	public void verifyAdminUserLogin() throws InterruptedException {
		// -- clickhash button
		HashButton.click();
		waitForElement(loginLink);
		String loginInput = prop.getProperty("adminLogin");
		String passwordInput = prop.getProperty("adminPswd");
		// -- click login button
		loginLink.click();
		waitForElement(userName);
		// -- login and password send keys
		userName.sendKeys(loginInput);
		password.sendKeys(passwordInput);
		loginButton.click();
		waitForPageToLoad();
		waitForElement(AddMovieLink);
	}

	public void userLoginCheck() {
		HashButton.click();
		waitForElement(loginLink);
		loginLink.click();
		waitForElement(userName);
		userName.sendKeys(prop.getProperty("userUsername"));
		password.sendKeys(prop.getProperty("userPassword"));
		loginButton.click();
		waitForPageToLoad();
		wait(4);
		TestBase.assertTrue(logoutButton.isDisplayed(), "Logout button is displayed.", "Logout button is not present");

	}

}
