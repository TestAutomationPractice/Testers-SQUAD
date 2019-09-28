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

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement descriptionInput;

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

	@FindBy(xpath = "//select[@name='categories']/option[2]")
	WebElement selectCategoryTwo;

	@FindBy(xpath = "//input[@name='file']")
	WebElement url;

	@FindBy(xpath = "//label[contains(text(),'Rating')]/..//*[name()='svg'][2]")
	WebElement ratingSelect;

	public void verifyAddMovieButton() {
		AddMovieLink.click();
		waitForPageToLoad();
		wait(4);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("addMovieUrl");
		TestBase.assertTrue(currentUrl.contains(expectedUrl), "Admin navigated to add movie page",
				"Admin navigated to wrong url:" + currentUrl);
	}

	/**
	 * Clicking on Add movie with blank details
	 */
	public void verifyAdminAddMovieBlankClick() {
		// -- Clicking on save movie button
		saveMovieButton.click();
		wait(3);
		// -- Element wait
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
		// -- Details are passed
		titleInput.sendKeys(prop.getProperty("title"));
		directorInput.click();
		wait(1);
		directorInput.sendKeys(prop.getProperty("director"));
		descriptionInput.sendKeys(prop.getProperty("description"));
		selectCategoryTwo.click();
		wait(2);
		url.sendKeys(prop.getProperty("imageUrl"));
		// -- Click add movie button
		saveMovieButton.click();
		ratingSelect.click();
		wait(3);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("devUrl");
		// -- Verify user is navigated to dashboard page
		TestBase.assertTrue(currentUrl.contains(expectedUrl), "User is navigated to HomePage",
				"User failed to navigate to dashboard page.");
	}
}
