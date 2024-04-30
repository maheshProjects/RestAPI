package com.day2;

import org.testng.annotations.Test;

import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

/*
 * Different ways to create POST request body
// 1)  Post request body using Hashmap
 *2) using  Org.JSON
 *3) POJO Class
 *external json file data

*/@Test

public class DiEWaysToPostRequestBody {
	// 1 method use Hash Map

	void testPostusingHashmap() {

		HashMap data = new HashMap();
		
		data.put("name", "scot");
		data.put("location", "france");
		data.put("phone", "123456");

		String courseArr[] = { "C", "C++" };
		data.put("courses", courseArr);

		given().contentType("application/json").body(data);

		when().post();

		then()
		.statusCode(201)
		.body("name", equals("scot"))
		.body("location", equals("france"))
				.body("phone", equals("123456"))
				.body("courses[0]", "C")
				.body("courses[0]", "C++")
				.header("Content-Type", "application/json;charset=utf-8").log().all();
	}

	// deleting student record
	@Test(priority = 2)
	void testDelete() {
		given()

				.when().delete("/students/4")

				.then();

	}

	// *2) using Org.JSON libraray

	void testPostusingJSON() {
        
		
		
		
		JSONObject data=new   JSONObject();
		data.put("name", "scot");
		data.put("location", "france");
		data.put("phone", "123456");
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		
		
		
		
   given()
		 .contentType("application/json")
		  .body(data);
		
		
    when()
		   .post();
		
	 then();
		.statusCode(201)
		.body("name",equals("scot"))
		.body("location",equals("france"))
		.body("phone",equals("123456"))
		.body("courses[0]","C")
		.body("courses[0]","C++")
		.header("Content-Type","application/json;charset=utf-8")
		.log().all();
	}

	// 3 Pojo class

	void testPostusingPOJO() {
		
	     Pojo_PostRequest  data= new Pojo_PostRequest();
	  
	         data.setName("scot");
	         data.setLocation("france");
	         data.setPhone("123456");
	         String coursesArr[]= {"C","C++"};
	         data.setCourse(coursesArr);
		
	   given()
			 .contentType("application/json")
			  .body(data);
			
			
	    when()
			   .post();
			
		 then();
			.statusCode(201)
			.body("name",equals("scot"))
			.body("location",equals("france"))
			.body("phone",equals("123456"))
			.body("courses[0]","C")
			.body("courses[0]","C++")
			.header("Content-Type","application/json;charset=utf-8")
			.log().all();

}
}
