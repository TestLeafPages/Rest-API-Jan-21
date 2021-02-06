package channing;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	public static String sysID; 
	public static RequestSpecification request;

	@BeforeMethod
	public void Init() {
		RestAssured.baseURI = "https://dev102438.service-now.com/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","Tuna@123");
		request = RestAssured
		.given()
		.log().all()
		.contentType(ContentType.JSON);
	}

}
