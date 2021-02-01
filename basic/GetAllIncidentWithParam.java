package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithParam {

	@Test
	public void getAllIncident() {
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev102438.service-now.com//api/now/table/incident";
//		Step2: Authentication (basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
//		Step3: Request Type (Get) with param
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.get();
//		Step5: Print Response 
//		response.prettyPrint();
//		Step4: print status code -> 200
		System.out.println(response.getStatusCode());
		
		//need to parse the response to json
		JsonPath jsonPath = response.jsonPath();
//		get only one field from response
//		String object = jsonPath.get("path");
		List<String> ListOfsysID = jsonPath.getList("result.sys_id");
		System.out.println(ListOfsysID.get(0));
		
	}
	
}
