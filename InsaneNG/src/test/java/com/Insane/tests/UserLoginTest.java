package com.Insane.tests;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Insane.base.TestBase;
import com.Insane.pages.DashboardPage;
import com.Insane.pages.LoginPage;

public class UserLoginTest extends TestBase {

	public UserLoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void openBrowser() throws IOException {
		TestBase.initialization();
	}

	@Test(description = "Verify correct title is displayed.", priority = 1)
	public void verifyTitle() throws IOException, InterruptedException {
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.verifyPageTitle();
	}

	@Test(description = "Verify admin user gets logged in.", priority = 2)
	public void verifyUsergetsLoggedIn() throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.userLoginCheck();
	}
}
