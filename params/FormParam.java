package params;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FormParam {
	
	@Test
	public void loginLeaftaps() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "http://leaftaps.com/opentaps/control/login%";
		RestAssured.urlEncodingEnabled = false;
		
		//Key & Value
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("USERNAME", "DemoCSR2");
		map.put("PASSWORD", "crmsfa");
		
		
		// Step 2: Request type - Post + form param
		Response post = RestAssured
			.given()
//			.contentType(ContentType.URLENC)
			.when()
			.formParams(map)
//			.formParam("USERNAME", "DemoCSR2")
//			.formParam("PASSWORD", "crmsfa")
//			.body("")
			.post();
			
		post.prettyPrint();
		
	}
	

}
