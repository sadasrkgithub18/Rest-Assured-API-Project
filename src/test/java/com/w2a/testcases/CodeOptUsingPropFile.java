package com.w2a.testcases;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CodeOptUsingPropFile 
{
	
	   @Test
	   public void validateCreateCustWithValidKey()
	   {
		   RestAssured.baseURI = "https://api.stripe.com";
		   RestAssured.basePath = "/v1";
		   
		   
		   Response response = given().auth().basic("sk_test_51Hg2xUERu8sF3Rkwiftmh6IIpJSb3kDdgskqWr0q00pDOOhCjJ7Nsu2Ld1odh54PNmMYGvXOxHGk1MX7N8ijDS1600WQ9GR20l","")
	              .formParam("email", "hishapal@hrservices.com").formParam("description", "First User Uing TestNG 2")
	              .post("/customers");
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	
	   @Test
	   public void validateCreateCustWithInValidKey()
	   {
		   RestAssured.baseURI = "https://api.stripe.com";
		   RestAssured.basePath = "/v1";
		   
		   
		   Response response = given().auth().basic("123sk_test_51Hg2xUERu8sF3Rkwiftmh6IIpJSb3kDdgskqWr0q00pDOOhCjJ7Nsu2Ld1odh54PNmMYGvXOxHGk1MX7N8ijDS1600WQ9GR20l","")
	              .formParam("email", "hishapal@hrservices.com").formParam("description", "First User Using TestNG")
	              .post("/customers");
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
}
