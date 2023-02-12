package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request 
{

	@Test
	void googleMapTest() {
	       //Specify Base URI
			RestAssured.baseURI="https://maps.googleapis.com";
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
			
			//Response object
			Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?"
					+ "location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
			
			//Print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response body is"+responsebody);
			
			//capture details of headers from response
			String contentType=response.header("Content-Type");  //capture details of Content-Type header
			System.out.println("Content Type is:"+contentType);
			Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
			
			String contentEncoding=response.header("Content-Encoding");  //capture details of Content-Encoding header
			System.out.println("Content Type is:"+contentEncoding);
			Assert.assertEquals(contentEncoding, "gzip");
			
	}
}
