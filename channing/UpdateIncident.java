package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends BaseRequest{
	//							packageName.className.@testMethod
	@Test(dependsOnMethods = "channing.CreateIncidentWithoutBody.createIncidentWithoutBody")
	public void updateIncident() {
		Response response = request
							.pathParam("SysID", sysID)
							.body("{\"short_description\": \"Update a old Incident with patch\", \"category\": \"Software\"}")
							.put("{SysID}");
		//		Step5: Print Response 
		response.prettyPrint();
		//		Step4: print status code -> 201
		System.out.println(response.getStatusCode());
	}

}
