package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request_Authorization {

	@Test
	void getweatherdetails() 
	{
		//Specify Base URI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/ChackForAuthentication";
		
		//Basic authentication
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
		
		
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/");
		
		//Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body is"+responsebody);
		
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println("Status code is :"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
	}
	
}
