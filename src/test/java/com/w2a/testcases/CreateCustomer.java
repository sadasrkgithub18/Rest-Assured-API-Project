package com.w2a.testcases;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCustomer 
{
   @Test
   public void validateCreateCustWithValidKey()
   {
	   Response response = given().auth().basic("sk_test_51Hg2xUERu8sF3Rkwiftmh6IIpJSb3kDdgskqWr0q00pDOOhCjJ7Nsu2Ld1odh54PNmMYGvXOxHGk1MX7N8ijDS1600WQ9GR20l","")
              .formParam("email", "hishapal@hrservices.com").formParam("description", "First User Uing TestNG")
              .post("https://api.stripe.com/v1/customers");
	   
	   response.prettyPrint();
	   
	   System.out.println(response.statusCode());
	   
	   Assert.assertEquals(response.statusCode(), 200);
   }
   
   @Test
   public void validateCreateCustWithInValidKey()
   {
	   Response response = given().auth().basic("123sk_test_51Hg2xUERu8sF3Rkwiftmh6IIpJSb3kDdgskqWr0q00pDOOhCjJ7Nsu2Ld1odh54PNmMYGvXOxHGk1MX7N8ijDS1600WQ9GR20l","")
              .formParam("email", "hishapal@hrservices.com").formParam("description", "First User Using TestNG")
              .post("https://api.stripe.com/v1/customers");
	   
	   response.prettyPrint();
	   
	   System.out.println(response.statusCode());
	   
	   Assert.assertEquals(response.statusCode(), 200);
   }
}
