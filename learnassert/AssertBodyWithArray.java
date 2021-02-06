package learnassert;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertBodyWithArray {

	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.contentType(ContentType.JSON)
				.get()
				.then()
				.assertThat()
				.body("result.number", hasItem("INC0000010"))// Array 
				.extract()
				.response()
				;
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
}
