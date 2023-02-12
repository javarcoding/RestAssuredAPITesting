package Data_Driven_Test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class DataDrivenTest_AddNewEmployees {
 
		
		@Test(dataProvider = "empdataprovider")
		 void postNewEmplooyee(String ename,String eage,String esal)
		 {
			// Specify Base URI
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

			// Request Object
			RequestSpecification httprequest = RestAssured.given();
			
			//Here we created data which we can send along with the post request 
			JSONObject requestParams=new JSONObject();
			
			requestParams.put("name", ename);
			requestParams.put("salary", eage);
			requestParams.put("age", esal);
			
			//Add a header stating the Request body is  a JSON
			httprequest.header("Content-Type", "application/json");
			
			//Add the JSON to the body of the request
			httprequest.body(requestParams.toJSONString());
			
			//POST Request
			Response response=httprequest.request(Method.POST,"/create");
			
			//capture response body to perform validations
			String responseBody=response.getBody().asString();
			
			System.out.println("EResponse body is:"+responseBody);
			Assert.assertEquals(responseBody.contains(ename), true);
			Assert.assertEquals(responseBody.contains(eage), true);
			Assert.assertEquals(responseBody.contains(esal), true);
			
			int statuscode=response.getStatusCode();
			Assert.assertEquals(statuscode, 200);
			
			
			
			
		 }
		
		@DataProvider(name="empdataprovider")
		String [][] getEmpData() throws IOException
		{
			//Read data from excel
			String path=System.getProperty("user.dir")+"/src/test/java/testData/empdata.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String empdata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					empdata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
			//String empdata[][]= {{"abc123","30000","40"},{"xyz123","40000","30"},{"pqr123","80000","50"}};
			
		return(empdata);
		}
	

}
