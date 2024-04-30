package com.day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	@Test
	void testCookies() {

		given()

				.when().get("https://www.google.com/")

				.then().cookie("AEC", "Ae3NU9O_H1LRDi8pLEhQcSXWIB7Mc9g3ndUMrpRYNak1SNC7H6x7V0Zl_dw").log().all();

	}

	@Test(priority=1)
	void getCOokiesInfo() {

		Response res = given()

				.when().get("https://www.google.com/");

		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of single cookie  is ====> " + cookie_value);
	
		 Map<String, String> cookies = res.getCookies();
		 System.out.println("keySet");
		 System.out.println(cookies.keySet());
		 
		 for(String k:cookies.keySet()) {
			 String cookies_value = res.getCookie(k);
			 System.out.println(k+"     "+cookie_value);
		 }
	
	}

}
