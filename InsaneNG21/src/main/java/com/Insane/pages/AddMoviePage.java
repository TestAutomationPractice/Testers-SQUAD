package com.Insane.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Insane.base.TestBase;

public class AddMoviePage extends TestBase {

	public AddMoviePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'add movie')]")
	WebElement AddMovieLink;

	@FindBy(xpath = "//input[@name='title']/../div[@class='invalid-feedback']")
	WebElement invalidTitleValidation;

	@FindBy(xpath = "//input[@name='title']")
	WebElement titleInput;

	@FindBy(xpath = "//input[@name='director']")
	WebElement directorInput;

	@FindBy(xpath = "//button[contains(text(),'Save Movie')]")
	WebElement saveMovieButton;

	@FindBy(xpath = "//div[contains(text(),'longer name')]")
	WebElement longerName;

	@FindBy(xpath = "//div[contains(text(),'movie description')]")
	WebElement movieDescription;

	@FindBy(xpath = "//div[contains(text(),'one category')]")
	WebElement movieCategory;

	@FindBy(xpath = "//div[contains(text(),'URL to me')]")
	WebElement invalidUrlMessage;

	public void verifyAddMovieButton() {
		AddMovieLink.click();
		waitForPageToLoad();
		wait(3);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("addMovieUrl");
		TestBase.assertTrue(currentUrl.contains(expectedUrl), "Admin navigated to add movie page",
				"Admin navigated to wrong url:" + currentUrl);
	}

	public void verifyAdminAddMovieBlankClick() {
		// -- Clicking on save movie button
		saveMovieButton.click();
		waitForElement(invalidTitleValidation);
		// -- Verify Invalid messages are displayed.
		TestBase.assertTrue(invalidTitleValidation.isDisplayed() == true, "Invalid title validation is displayed.",
				"Invalid message is not displayed.");
		TestBase.assertTrue(longerName.isDisplayed() == true, "Invalid director message is displayed.",
				"Invalid message for longer Name is not displayed.");
		TestBase.assertTrue(movieDescription.isDisplayed() == true, "Invalid description message is displayed.",
				"Invalid message for movie description is not displayed.");
		TestBase.assertTrue(movieCategory.isDisplayed() == true, "Invalid description message is displayed.",
				"Invalid message for movie category is not displayed.");
		TestBase.assertTrue(invalidUrlMessage.isDisplayed() == true, "Invalid url message is displayed.",
				"Invalid message for Url is not displayed.");

	}

	public void verifyAdminAddMovie() {

		titleInput.sendKeys(prop.getProperty("title"));
		directorInput.sendKeys(prop.getProperty("directorInput"));
	}
}
