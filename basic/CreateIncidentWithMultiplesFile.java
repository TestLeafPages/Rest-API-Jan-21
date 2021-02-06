package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithMultiplesFile {
	
	@DataProvider(name = "JsonFile")
	public String[] getData() {
		String[] fileName =  new String[2];
		//1st file name
		fileName[0]  = "CreateIncident1.json";
		//2nd file name
		fileName[1]  = "CreateIncident2.json";
		return fileName;
	}	

	@Test(dataProvider = "JsonFile")
	public void createIncidentWithoutBody(String fName) {
		//Read json file
		File file = new File("./Data/"+fName+"");
		
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
//		Step2: Authentication (basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
//		Step3: Request Type (Post) -> Ctrl+2 , l
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(file)
				.post();
//		Step5: Print Response 
		response.prettyPrint();
//		Step4: print status code -> 201
		System.out.println(response.getStatusCode());
	}
	
}
