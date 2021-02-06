package learnassert;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertWithbody {

	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{    \"short_description\": \"Created a new Incident as String\",    \"category\": \"software\"}")
				.post()
				.then()
				.assertThat()
//				.body("result.short_description", equalTo("Created a new Incident as String"))
				.body("result.short_description", containsString("new Incident"))
				.extract()
				.response()
				;
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
}
