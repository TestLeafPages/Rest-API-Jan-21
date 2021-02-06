package learnassert;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertWithStatusCodeAndContentType {

	@Test
	public void getAllIncident() {
		RestAssured.baseURI = "https://dev102438.service-now.com//api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		String response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get()
				.then()
				.assertThat()
				.statusCode(201)
				.contentType(ContentType.JSON)
				.extract()
				.response()
				.prettyPrint();
	}
}
