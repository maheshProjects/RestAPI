package com.day4;

import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJsonResponse {

	@Test
	void testJsonRespons() {

//Approach
		
		given()
		.contentType("ContentType.JSON")
		
		
		.when()
		  .get("http://localhost:3000/store")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
	    .body("book[3].tittle", equalTo("The Lord of the Rings"));	
		
	}

}
