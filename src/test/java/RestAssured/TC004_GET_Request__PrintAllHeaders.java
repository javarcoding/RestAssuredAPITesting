package RestAssured;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request__PrintAllHeaders 
{

	@Test
	public void googleMapTest() {
	       //Specify Base URI
			RestAssured.baseURI="https://maps.googleapis.com";
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
			
			//Response object
			Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch\r\n"
					+ "/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
			
			//Print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response body is"+responsebody);
			
			//capture all the headers from response
			Headers allheaders=response.headers();
			
			for (Header header:allheaders) 
			{
				System.out.println(header.getName()+" "+header.getValue());
			}
			
	}
}
