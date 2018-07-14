package com.datadriven.test;
                                       // Excel Sheet Methods
import com.excel.utility.Xls_Reader;

public class ExcelOperations 
{
	
	public static void main(String[] args) 
	{
		
		
		Xls_Reader reader = new Xls_Reader("D:\\rameshsoft\\workspace\\DataDrivenFramework\\src\\com\\excel\\data\\Book15.xlsx");
		
		
		
		if(!reader.isSheetExist("HomePage"))               // if HomePage sheet is not Exist(not there)---plz add HomePage Sheet 
		{
			reader.addSheet("HomePage");
		}
		
		
		int colCount = reader.getColumnCount("RegTestData");
		System.out.println("Total columns present in RegTestData:---  "+colCount);
		
		
		int cellRowNum = reader.getCellRowNum("RegTestData", "firstname", "milky");
		System.out.println("milky row number is:--  " +cellRowNum);
		

		
	}

}
