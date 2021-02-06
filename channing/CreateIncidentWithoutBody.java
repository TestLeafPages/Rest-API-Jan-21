package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends BaseRequest{

	@Test
	public void createIncidentWithoutBody() {

		Response response = request
						.post();
		//		Step5: Print Response 
		response.prettyPrint();
		//		Step4: print status code -> 201
		System.out.println(response.getStatusCode());

		JsonPath jsonPath = response.jsonPath();
		sysID = jsonPath.get("result.sys_id");

	}

}
