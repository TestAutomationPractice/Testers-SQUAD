package com.Insane.tests;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apiResources.ReusableMethods;
import apiResources.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MoviesAPITest {

	public static final Logger log = Logger.getLogger(MoviesAPITest.class.getName());
	public String AdminId, UserId, titleOfMovie;

	@BeforeClass
	public void loginToGenerateID() {
		RestAssured.baseURI = "https://autothon-nagarro-backend-b06.azurewebsites.net";

		// Code to generate id for admin
		Response res = given().header("Content-Type", "application/json")
				.body("{\"username\":\"admin\",\"password\":\"password\"} ").when().post("/login").then().log().all()
				.assertThat().statusCode(200).extract().response();

		JsonPath js = ReusableMethods.rawToJson(res);
		AdminId = js.getString("id");
		System.out.println("Id of Admin account = " + AdminId);

		// Code to generate id for a user
		Response resUser = given().header("Content-Type", "application/json")
				.body("{\"username\":\"user\",\"password\":\"password\"} ").when().post("/login").then().log().all()
				.assertThat().statusCode(200).extract().response();

		JsonPath jsUser = ReusableMethods.rawToJson(resUser);
		UserId = jsUser.getString("id");
		System.out.println("Id of user account = " + UserId);

	}

	@Test(priority = 1)
	public void addMovieByAdminAccount() {

		log.info("-------Test case to add a new movie-------");
		RestAssured.baseURI = "https://autothon-nagarro-backend-b06.azurewebsites.net";

		try {
			Response res = given().header("user", AdminId).header("Content-Type", "application/json")
					.body(payLoad.getAddMovieBody()).when().post("/movies").then().log().all().assertThat()
					.statusCode(200).extract().response();

			JsonPath jsUser = ReusableMethods.rawToJson(res);
			titleOfMovie = jsUser.getString("title");

			log.info("Response : " + res.body().prettyPrint() + "\n");
		} catch (Exception e) {
			log.info(e);

		}
	}

	@Test
	public void getAllMoviesFromUserAccount() {

		log.info("-------Test case to add a new movie-------");
		RestAssured.baseURI = "https://autothon-nagarro-backend-b06.azurewebsites.net";

		try {
			Response res = given().header("user", UserId).header("Content-Type", "application/json")
					.body(payLoad.getAddMovieBody()).when().get("/movies").then().log().all().assertThat()
					.statusCode(200).extract().response();

			Assert.assertTrue(res.body().asString().contains(titleOfMovie), "The expected movie not found");

			log.info("Movie found by user account successfully");
			log.info("Response : " + res.body().prettyPrint() + "\n");
		} catch (Exception e) {
			log.info(e);

		}
	}

}
