package com.Insane.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Insane.base.TestBase;

public class TemplatePage extends TestBase {

	public TemplatePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "// h1[@class='display-3']")
	WebElement header;

	@FindBy(xpath = "// input[@name='search']")
	WebElement searchInput;

	public WebElement getHeader() {
		return header;
	}

}
