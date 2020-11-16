package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest 
{
	public static  Properties config = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\com\\w2a\\testdata\\RestTestData.xlsx");
	
  @BeforeSuite	
  public void setUp() throws IOException
  {
	  fis = new FileInputStream(".\\src\\test\\resources\\com\\w2a\\properties\\config.properties");
	  config.load(fis);
	  
	  RestAssured.baseURI = config.getProperty("baseURI");
	  RestAssured.basePath = config.getProperty("basePath");
	  
  }
  
  @AfterSuite
  public void tearDown()
  {
	  
  }
  
}
