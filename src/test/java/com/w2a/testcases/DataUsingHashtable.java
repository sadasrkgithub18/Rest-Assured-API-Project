package com.w2a.testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.listeners.ExtentListeners;
import com.w2a.utilities.DataUtilTwo;

import io.restassured.response.Response;

public class DataUsingHashtable extends BaseTest
{
	   @Test(priority = 1,dataProviderClass = DataUtilTwo.class,dataProvider = "getData")
	   public void validateCreateCustWithValidKey(Hashtable<String,String> data)
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("validSecretKey"),"")
	              .formParam("email", data.get("email")).formParam("description", data.get("description"))
	              .post(config.getProperty("customerAPIEndPoint"));
		   
		   ExtentListeners.testReport.get().info(data.toString());		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	   
	   @Test(priority = 2,dataProviderClass = DataUtilTwo.class, dataProvider = "getData")
	   public void validateCreateCustWithInValidKey(Hashtable<String,String> data)
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("inValidSecretKey"),"")
	              .formParam("email",data.get("email")).formParam("description", data.get("description"))
	              .post(config.getProperty("customerAPIEndPoint"));
		   ExtentListeners.testReport.get().info(data.toString());
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }

}
