package com.datadriven.test;
                          //Data Driven Approche(Datadriven Framework:- Driving the Test Data from Excel Files)

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader;

public class Dynamic_ParameterizeTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		// Launch WebDriver
		WebDriver d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		d.get("http://toolsqa.com/automation-practice-form/");
		
		//Get The Data From Excel File
		Xls_Reader reader = new Xls_Reader("D:\\rameshsoft\\workspace\\DataDrivenFramework\\src\\com\\excel\\data\\Half_EbayExcelData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		
		
		reader.addColumn("RegTestData", "Status");             // add a colomn to excel
		
		
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++)
		{
			
			System.out.println("************************************************************");
			String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastname);

			String date = reader.getCellData("RegTestData", "date", rowNum);
			System.out.println(date);
			
			
			d.findElement(By.xpath("//input[@name='firstname']")).clear();
			d.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
					
		    d.findElement(By.xpath("//input[@name='lastname']")).clear();
		    d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
			
			d.findElement(By.xpath("//input[@id='datepicker']")).clear();
			d.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(date);
			
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass");    //write the data into a cell
			
			Thread.sleep(3000);


		}
		
		Thread.sleep(3000);
		d.close();

		
	}

}
