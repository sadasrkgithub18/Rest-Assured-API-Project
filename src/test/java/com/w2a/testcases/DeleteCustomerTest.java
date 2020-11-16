package com.w2a.testcases;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;
import com.w2a.utilities.DataUtilTwo;
import com.w2a.utilities.TestUtil;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest
{
	   @Test(priority = 1,dataProviderClass = DataUtilTwo.class,dataProvider = "data")
	   public void deleteCustomer(Hashtable<String,String> data)
	   {
		   
		   
		   Response response = DeleteCustomerAPI.sendDeleteRequestWithValidID(data);
		   
		   response.prettyPrint();
		   
			/*
			 * String actual_id = response.jsonPath().get("id").toString();
			 * 
			 * System.out.println("Getting id from json path:-->"+actual_id);
			 * 
			 * Assert.assertEquals(actual_id, data.get("id"));
			 */ 
		   
	   
			/*
			 * JSONObject jsonObject = new JSONObject(response.asString());
			 * System.out.println(jsonObject.has("id"));
			 * Assert.assertTrue(jsonObject.has("id"),"ID is not present");
			 */
		   
		   System.out.println("Check presence of Object key:->"+TestUtil.jsonHasKey(response.asString(), "object"));
		   System.out.println("Check presence of Delete key:->"+TestUtil.jsonHasKey(response.asString(), "deleted"));
		   
		   
		   Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"));
		   
		   String actual_id = TestUtil.getjsonKeyValue(response.asString(), "id");
		   System.out.println(actual_id);
		   Assert.assertEquals(actual_id, data.get("id"));
		   
		   System.out.println("Object Key Value is:"+TestUtil.getjsonKeyValue(response.asString(), "object"));
		   System.out.println("Deleted Key Value is:"+TestUtil.getjsonKeyValue(response.asString(), "deleted"));
			
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	
}
