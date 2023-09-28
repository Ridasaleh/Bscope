package foodicstests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ScopeBtest {
	
   @Test
	public void test_1() {
		
		// store response 
		Response response = RestAssured.get("https://pay2.foodics.dev/cp_internal/login\r\n");
		
		// Verify time in milliseconds and status line and print the data 
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		
	   // Verify that the response has a 200 OK status code 
		
	    int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
		
		
	}
	
//	@Test 
	public void test_2() {
		
		// perform login & test response 
		
		RestAssured.given()
		.when()
		.log()
		.all()
		.get("https://pay2.foodics.dev/cp_internal/login");
		
		System.out.println("_______ After recevieng the response ____________");
		
		RestAssured.given()
		.when()
		.get("https://pay2.foodics.dev/cp_internal/login")
		.then()
		.log()
		.all();	
		
	}
	
 // @Test
	public void test_3() {
		
		// test post 
		
		JSONObject request = new JSONObject();
		
		request.put("email", "merchants@foodics.com");
		request.put("password", "123456");
		
		System.out.println(request.toJSONString());
		
		
		 String baseURI = "https://pay2.foodics.dev/cp_internal/whoami";
		
		
	}

}
