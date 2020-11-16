package com.w2a.testcases;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.utilities.DataUtilTwo;

import io.restassured.response.Response;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APIs.CreateCustomerAPI;
import com.w2a.utilities.DataUtilTwo;

import io.restassured.response.Response;

public class BusinessSpecInSeperate 
{
	   @Test(priority = 1,dataProviderClass = DataUtilTwo.class,dataProvider = "data")
	   public void validateCreateCustWithValidKey(Hashtable<String,String> data)
	   {
		   CreateCustomerAPI csapi = new CreateCustomerAPI();
		   
		   Response response = csapi.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
				   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	   
	   @Test(priority = 2,dataProviderClass = DataUtilTwo.class, dataProvider = "data")
	   public void validateCreateCustWithInValidKey(Hashtable<String,String> data)
	   {
		   CreateCustomerAPI csapi = new CreateCustomerAPI();
		   
		   Response response = csapi.sendPostRequestToCreateCustomerAPIWithinValidAuthKey(data);
		  
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }

}
