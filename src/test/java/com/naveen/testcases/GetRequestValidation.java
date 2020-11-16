package com.naveen.testcases;

import static io.restassured.RestAssured.given;

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetRequestValidation 
{
  @Test
  public void getUsersFromPageTwo()
  {
	  Response response = given().get("https://reqres.in/api/users?page=2");

	  // response.prettyPrint();
	  
		/*
		 * JSONObject jsonObject = new JSONObject(response.asString());
		 * System.out.println("Json Object Lenght is:-->"+jsonObject.length());
		 * 
		 * for(int i = 0 ; i<jsonObject.length() ; i++) { if(jsonObject.has("id")) {
		 * 
		 * } }
		 */
	  
	  
	  JSONObject jsonObject = new JSONObject(response.toString().trim());
	  Iterator<String> keys = jsonObject.keys();

	  while(keys.hasNext()) 
	  {
	      String key = keys.next();
	      if (jsonObject.get("id").equals(12) )
	      {
	            //if(id==12)
	            {
	            	System.out.println("Howell");
	            }
	      }
	  }
  }

}
