package com.w2a.testdatarough;

import com.w2a.utilities.ExcelReader;

public class ReadingExceldata 
{
	
	public static void main(String[] args) 
	{
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\com\\w2a\\testdata\\RestTestData.xlsx");
		
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are:"+rows);
		
		String testName = "validateCreateCustWithValidKey";
		int testCaseRowNum = 1;
		
		for(testCaseRowNum = 1; testCaseRowNum<=rows; testCaseRowNum++)
		{
			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
		    
			if(testCaseName.equalsIgnoreCase(testName))
			{
				break;
			}
		}
		
		System.out.println("Test case starts from row num: "+testCaseRowNum);
		
		
		// Checking total rows in test case
		int dataStartRowNum = testCaseRowNum+2;
		int testRows = 0;
		
		while(!excel.getCellData(Constants.DATA_SHEET,0,dataStartRowNum+testRows).equals(""))
		{
			testRows++;
		}
		
		System.out.println("Total rows of data are:"+testRows);
		
		// Checking total cols in test case
		int colStartColNum = testCaseRowNum+1;
		int testCols = 0;
		 
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals(""))
		{
			testCols++;
		}
		
		System.out.println("Total cols are:"+testCols);
		
		
		// Printing data
		for(int rNum=dataStartRowNum; rNum<(dataStartRowNum+testRows);rNum++)
		{
			for(int cNum=0; cNum<testCols ; cNum++)
			{
				System.out.println(excel.getCellData(Constants.DATA_SHEET,cNum,rNum));
			}
		}
	}
	
}
