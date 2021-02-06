package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest{

	@Test(dependsOnMethods = "channing.UpdateIncident.updateIncident")
	public void deleteIncident() {
		Response response = request
							.pathParam("sys_id1", sysID)
							.delete("{sys_id1}");
		//		Step5: Print Response 
		response.prettyPrint();
		//		Step4: print status code -> 201
		System.out.println(response.getStatusCode());
	}

}
