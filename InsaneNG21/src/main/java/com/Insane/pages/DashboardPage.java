package com.Insane.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Insane.base.TestBase;

public class DashboardPage extends TestBase {

	public DashboardPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@name='Login']")
	WebElement loginLink;

	public void verifyPageTitle() {
		String title = driver.getTitle();
		String expectedTitle = prop.getProperty("expectedtitle");
		TestBase.assertTrue(title.contains(expectedTitle), "Title is correct.",
				"Title is wrong. We received :" + title);
	}
}
