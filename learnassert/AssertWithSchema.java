package learnassert;

import org.testng.annotations.Test;
import java.io.File;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class AssertWithSchema {

	@Test
	public void createIncidentWithoutBody() {
		
		File file = new File("./Data/CISchema.json");
		
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
//		Step2: Authentication (basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
//		Step3: Request Type (Post) -> Ctrl+2 , l
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat()
				.body(matchesJsonSchema(file))
				.extract()
				.response();
//		Step5: Print Response 
		response.prettyPrint();
//		Step4: print status code -> 201
		System.out.println(response.getStatusCode());
	}
	
}
