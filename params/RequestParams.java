package params;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class RequestParams {

	// Step 2: Received the data provider -> data as argument
	@Test
	public void requestParams() {

		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";

		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");


		// Step 3: requestParams -> formParam (or) queryParam
		Response response = RestAssured
				.given()
				.log().all()
				.params("sysparm_fields", "number,sys_id")
				.post();

		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());

		// Print the response time as well
		System.out.println(response.getTime());

		// Check what is the response format
		System.out.println(response.getContentType());

		// print the response
		response.prettyPrint();

		// Need to parse JSON
		JsonPath jsonResponse = response.jsonPath();

		// Get the incident.numbers
		List<String> listOfNumbers = jsonResponse.getList("result.number");

		// How to count of numbers?
		System.out.println(listOfNumbers.size());




	}


}
