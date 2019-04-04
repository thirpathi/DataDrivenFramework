package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader;

public class Hard_CodeDataDrivenTest
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		//Data Driven Approche(Datadriven Framework:- Driving the Test Data from Excel Files)
		//Get The Data From Excel File
		Xls_Reader reader = new Xls_Reader("D:\\rameshsoft\\workspace\\DataDrivenFramework\\src\\com\\excel\\data\\Half_EbayExcelData.xlsx");
		
		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		//System.out.println(firstname);
		
		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);

		String date = reader.getCellData("RegTestData", "date", 2);
		System.out.println(date);

		
		
		// Launch WebDriver
		//WebDriver d = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\ChromeDriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();	
		d.get("http://toolsqa.com/automation-practice-form/");

		
		d.findElement(By.xpath("//input[@name='firstname']")).clear();
		d.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
				
	    d.findElement(By.xpath("//input[@name='lastname']")).clear();
	    d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		d.findElement(By.xpath("//input[@id='datepicker']")).clear();
		d.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(date);

		Thread.sleep(5000);
		
		d.close();
	}

}
