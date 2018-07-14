package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil 
{
	
	static Xls_Reader reader;

	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		
		try 
		{
			reader = new Xls_Reader("D:\\rameshsoft\\workspace\\DataDrivenFramework\\src\\com\\excel\\data\\Half_EbayExcelData.xlsx");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		
		for(int rowNum=2; rowNum<= reader.getRowCount("RegTestData"); rowNum++)
		{
			
			System.out.println("************************************************************");
			String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastname);

			String date = reader.getCellData("RegTestData", "date", rowNum);
			System.out.println(date);
			
			
			Object ob[] = {firstname, lastname, date};
			myData.add(ob);
					
		}
		return myData;
		
	}

}
