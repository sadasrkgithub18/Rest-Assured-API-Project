package com.w2a.testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UsingPropClass extends BaseTest
{
	   @Test
	   public void validateCreateCustWithValidKey()
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("validSecretKey"),"")
	              .formParam("email", "hishapal@hrservices.com").formParam("description", "First User Uing TestNG 4")
	              .post(config.getProperty("customerAPIEndPoint"));
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	
	   @Test
	   public void validateCreateCustWithInValidKey()
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("inValidSecretKey"),"")
	              .formParam("email", "hishapal@hrservices.com").formParam("description", "First User Using TestNG")
	              .post(config.getProperty("customerAPIEndPoint"));
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }

}
