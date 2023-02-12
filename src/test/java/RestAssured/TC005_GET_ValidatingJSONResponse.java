package RestAssured;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidatingJSONResponse 
{

	@Test
	public void GetWeatherDetails() {
	       //Specify Base URI
			RestAssured.baseURI="https://restapi.demoqa.com/utilities/weather/city";
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
			
			//Response object
			Response response=httprequest.request(Method.GET,"/Hyderabad");
			
			//Print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response body is"+responsebody);
			
			Assert.assertEquals(responsebody.contains("Hyderabad"), true);
			
			
	}
}
