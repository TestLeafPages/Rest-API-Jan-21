package mock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class LearnWireMock {
	
//	@BeforeMethod
//	public void mockPost() {
//		stubFor(post("/api/now/table/incident")
//				.willReturn(aResponse()
//						.withStatus(201)
//						.withHeader("content-type", "application/json")
//						.withBody("{ 'org' : 'TestLeaf' }")
//						));
//	}
	

	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}
	
	
}
