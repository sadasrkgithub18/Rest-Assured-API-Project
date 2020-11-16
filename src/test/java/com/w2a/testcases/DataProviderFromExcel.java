package com.w2a.testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;

import io.restassured.response.Response;

public class DataProviderFromExcel extends BaseTest
{
	   @Test(dataProvider = "getData")
	   public void validateCreateCustWithValidKey(String name, String email, String description)
	   {
		   
		   
		   Response response = given().auth().basic(config.getProperty("validSecretKey"),"")
	              .formParam("email", email).formParam("description", description)
	              .post(config.getProperty("customerAPIEndPoint"));
		   
		   response.prettyPrint();
		   
		   System.out.println(response.statusCode());
		   
		   Assert.assertEquals(response.statusCode(), 200);
	   }
	
	   @DataProvider
	   public Object[][] getData()
	   {
		   String sheetName = "validateCreateCustomerAPI";
		   
		   int rows = excel.getRowCount(sheetName);
		   int cols = excel.getColumnCount(sheetName);
		   
		   System.out.println("Total rows are:"+rows);
		   System.out.println("Total cols are:"+cols);
		   
		   Object[][] data = new Object[rows-1][cols];
		   
//		   data[0][0] = excel.getCellData(sheetName, 0, 2);
//		   data[0][1] = excel.getCellData(sheetName, 1, 2);
//		   data[0][2] =	excel.getCellData(sheetName, 2, 2);
//		   
//		   data[1][0] = excel.getCellData(sheetName, 0, 3);
//		   data[1][1] = excel.getCellData(sheetName, 1, 3);
//		   data[1][2] =	excel.getCellData(sheetName, 2, 3);

		   for(int rowNum=2; rowNum<= rows; rowNum++)
		   {
			 for(int colNum = 0; colNum<cols; colNum++)
			 {
				 data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			 }
		   }
		   
		   return data;
	   }
	   
}
