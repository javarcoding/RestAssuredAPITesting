package RestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request 
{
	@Test
	void getweatherdetails() 
	{
		//Specify Base URI
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/Hyderabad");
		
		//Print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response body is"+responsebody);
		
		//Status code validation
		int statuscode=response.getStatusCode();
		System.out.println("Status code is :"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//Status line verification
		String statusline=response.getStatusLine();
		System.out.println("Status line is:"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}
	
}
