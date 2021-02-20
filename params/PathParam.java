package params;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PathParam {
	
	// Step 2: Received the data provider -> data as argument
	@Test
	public void deleteIncident() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		
		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Step 3: Request type - Post wth Content Type -> Response
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.pathParam("sys_id", "60a6bb7f2f3d101064df2d6df699b6e8")
				.delete("{sys_id}");
				
				
		// Step 4: Validate (Response -> Status Code : 204)
		System.out.println(response.getStatusCode());
		
		// Print the response time as well
		System.out.println(response.getTime());
		
		// Check what is the response format
		System.out.println(response.getContentType());
		
		// print the response
		response.prettyPrint();
			
	}
	

}
