package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties 
{
  public static void main(String[] args) throws IOException 
  {
	Properties config = new Properties();
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\com\\w2a\\properties\\config.properties");
	config.load(fis);
	
	System.out.println(config.getProperty("baseURI"));
  }
}
