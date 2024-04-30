package com.day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadesrDemo {
	@Test
	void testHeaders() {
		given()

				.when().get("https://www.google.com/")

				.then().header("Content-Type", "text/html; charset=ISO-8859-1").and().header("Content-Encoding", "gzip")
				.and().header("Server", "gws");

	}

	@Test(priority = 1)
	void getHeaders() {

		Response res = given()

				.when().get("https://www.google.com/");
		// get single header info

		String headervalue = res.getHeader("Content-Type");

		System.out.println("The value of content type header is :");
		System.out.println((headervalue));

// get all headers
		Headers myheaders = res.getHeaders();

		for (Header hd : myheaders)

			System.out.println(hd.getName() + "  " + hd.getValue());
		{
		}
	}

}
