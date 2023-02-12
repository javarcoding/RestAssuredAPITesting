package RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request 
{
	@Test
	void RegistrationSuccessfull() 
	{
		// Specify Base URI
		RestAssured.baseURI = "https://restapi.demoqa.com/customer";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestParam=new JSONObject();
		
		requestParam.put("FirstName", "JohnXYZ");
		requestParam.put("LastName", "XYZJohn");
		requestParam.put("UserName", "JohnXYZ");
		requestParam.put("password", "JohnXYZxyz");
		requestParam.put("Email", "JohnXYZ@gmail.com");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParam.toJSONString());
		
		//Response object
		Response response=httprequest.request(Method.POST,"/register");
				
		

		// Print response in console window
		String responsebody = response.getBody().asString();
		System.out.println("Response body is" + responsebody);

		// Status code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status code is :" + statuscode);
		Assert.assertEquals(statuscode, 201);
		
		//success code validation
		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");

		

	}
}
