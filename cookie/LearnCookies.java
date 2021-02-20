package cookie;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LearnCookies {


	@Test
	public void getAllIncident() {
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
//		Step2: Authentication (basic Auth)
//		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
//		Step3: Request Type (Get) -> Ctrl+2 , l
		Response response = RestAssured
				.given()
				.cookie("JSESSIONID","59E4B8410B7DBCFE24D8578C6D59095F")
				.get();
//		Step4: print status code -> 200
		System.out.println(response.getStatusCode());
		
		response.prettyPrint();
//		
//		Map<String, String> cookies = response.getCookies();
//		
//		for (Entry<String, String> eachItem : cookies.entrySet()) {
//			System.out.println("keys : "+eachItem.getKey()+" ---> "+eachItem.getValue());
//		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
