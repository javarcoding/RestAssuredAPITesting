package RestAssured;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_GetWeatherDetails {


	@Test
	public void GetWeatherDetails() {
	       //Specify Base URI
			RestAssured.baseURI="https://restapi.demoqa.com/utilities/weather/city";
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
			
			//Response object
			Response response=httprequest.request(Method.GET,"/Hyderabad");
			
			JsonPath jsonpath=response.jsonPath();
			
			System.out.println(jsonpath.get("City"));
			System.out.println(jsonpath.get("Temperature"));
			System.out.println(jsonpath.get("Humidity"));
			System.out.println(jsonpath.get("WeatherDescription"));
			System.out.println(jsonpath.get("windSpeed"));
			System.out.println(jsonpath.get("WindDirectionDegree"));
			
			Assert.assertEquals(jsonpath.get("Temperature"), "39 Degree celsius");
			
			
	}
}
