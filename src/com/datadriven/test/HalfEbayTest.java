package com.datadriven.test;
      //Run to this program   (with the help of TestUtil class only):- "* 3.DataProvider In TestNG - Data Driven Framework in Selenium*"
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class HalfEbayTest
{
	WebDriver d;
	
	@BeforeMethod
	public void setUp() 
	{
	    d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		d.get("http://toolsqa.com/automation-practice-form/");
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() 
	{
		ArrayList<Object[]> testData= TestUtil.getDataFromExcel();
		
		return testData.iterator();

	}
	
	
	@Test(dataProvider="getTestData")
	public void halfEbayRegPageTest(String firstname, String lastname, String date)
	{
		d.findElement(By.xpath("//input[@name='firstname']")).clear();
		d.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
				
	    d.findElement(By.xpath("//input[@name='lastname']")).clear();
	    d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		d.findElement(By.xpath("//input[@id='datepicker']")).clear();
		d.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(date);
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		
		d.quit();
	}
	
}
