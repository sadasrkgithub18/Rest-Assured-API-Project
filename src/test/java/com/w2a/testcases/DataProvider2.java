package com.w2a.testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.utilities.DataUtil;

import io.restassured.response.Response;

public class DataProvider2 extends BaseTest
{
	   @Test(priority = 1,dataProviderClass = DataUtil.class,dataProvider = "getData")
	   public void validateCreateCustomerAPI(String name, String email, String description)
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("validSecretKey"),"")
	              .formParam("email", email).formParam("description", description)
	              .post(config.getProperty("customerAPIEndPoint"));
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	   
	   @Test(priority = 2,dataProviderClass = DataUtil.class, dataProvider = "getData")
	   public void inValidateCreateCustomerAPI(String name, String email, String description)
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("inValidSecretKey"),"")
	              .formParam("email",email).formParam("description", description)
	              .post(config.getProperty("customerAPIEndPoint"));
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }

}
