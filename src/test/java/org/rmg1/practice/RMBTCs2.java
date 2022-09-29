package org.rmg1.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.FileUtility;
import org.sdet40.genericUtility.IConstantsFrameWork;
import org.sdet40.genericUtility.JavaUtility;
import org.sdet40.genericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMBTCs2 {
	      
	  WebDriver driver = null;

		public static void main(String[] args) throws IOException, AWTException, InterruptedException  {
			
			//Fetch Data From Property File
			
			FileUtility fileUtility = new FileUtility();
			fileUtility.initializePropertyFile(IConstantsFrameWork.PROPERTIES_PATH);
			
			String url = fileUtility.getDataFromPropertyFile("url");
			String staffId = fileUtility.getDataFromPropertyFile("StaffId");
			String passWord = fileUtility.getDataFromPropertyFile("Password");
			System.out.println(url);
			
	         //Fetch Data From Excel
			
			ExcelUtility excelUtility = new ExcelUtility();
			 excelUtility.openExcel(IConstantsFrameWork.EXCEL_PATH);
			 
			 //Fetch Data From JAva Utility
			 
			JavaUtility javaUtility = new JavaUtility();
			int randomNumber = javaUtility.getRandomNumber(1000);
			 
			String name = excelUtility.getDataFromExcel("Sheet1", 1, 0)+randomNumber;
			
			WebdriverUtility webDriverUtility = new WebdriverUtility();
			
			String mobileNo = excelUtility.getDataFromExcel("Sheet1", 1, 1);
			String mailId = excelUtility.getDataFromExcel("Sheet1", 1, 2);
			String landLineNo = excelUtility.getDataFromExcel("Sheet1", 1, 3);
			String panNo = excelUtility.getDataFromExcel("Sheet1", 1, 4);
			String citizenShipNo = excelUtility.getDataFromExcel("Sheet1", 1, 5);
			String homeAddress = excelUtility.getDataFromExcel("Sheet1", 1, 6);
			String officeAddress = excelUtility.getDataFromExcel("Sheet1", 1, 7);
			String pinCode = excelUtility.getDataFromExcel("Sheet1", 1, 8);
			String areaLocality = excelUtility.getDataFromExcel("Sheet1", 1, 9);
			String nomineeName = excelUtility.getDataFromExcel("Sheet1", 1, 10);
			String nomineeAccNo = excelUtility.getDataFromExcel("Sheet1", 1, 11);
			
			
			
			
			
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver= new FirefoxDriver();
			driver.get(url);
			
			driver.findElement(By.xpath("//li[.='Open Account']")).click();
			driver.findElement(By.name("name")).sendKeys(name);			
			driver.findElement(By.name("mobile")).sendKeys(mobileNo);
			driver.findElement(By.name("email")).sendKeys(mailId);
			driver.findElement(By.name("landline")).sendKeys(landLineNo);		
			driver.findElement(By.name("pan_no")).sendKeys(panNo);
			driver.findElement(By.name("citizenship")).sendKeys(citizenShipNo);
			driver.findElement(By.name("homeaddrs")).sendKeys(homeAddress);
			driver.findElement(By.name("officeaddrs")).sendKeys(officeAddress);
			driver.findElement(By.name("pin")).sendKeys(pinCode);
			driver.findElement(By.name("arealoc")).sendKeys(areaLocality);
			driver.findElement(By.name("nominee_name")).sendKeys(nomineeName);
			driver.findElement(By.name("nominee_ac_no")).sendKeys(nomineeAccNo);
			
			WebElement element = driver.findElement(By.name("gender"));
			webDriverUtility.selectClass(element, "Male");
			
			WebElement ele1 = driver.findElement(By.name("state"));
			webDriverUtility.selectClass(ele1, "Texas");
			
			WebElement ele2 = driver.findElement(By.name("city"));
			webDriverUtility.selectClass(ele2, "San Diego");
			
			WebElement ele3= driver.findElement(By.name("acctype"));
			webDriverUtility.selectClass(ele3, "Saving");
			
			
			driver.findElement(By.name("dob")).click();
			driver.findElement(By.name("dob")).click();
			Robot rbt=new Robot();
			rbt.keyPress(KeyEvent.VK_0);
			rbt.keyRelease(KeyEvent.VK_0);
			rbt.keyPress(KeyEvent.VK_1);
			rbt.keyRelease(KeyEvent.VK_1);
			rbt.keyPress(KeyEvent.VK_0);
			rbt.keyRelease(KeyEvent.VK_0);
			rbt.keyPress(KeyEvent.VK_1);
			rbt.keyRelease(KeyEvent.VK_1);
			rbt.keyPress(KeyEvent.VK_1);
			rbt.keyRelease(KeyEvent.VK_1);
			rbt.keyPress(KeyEvent.VK_9);
			rbt.keyRelease(KeyEvent.VK_9);
			rbt.keyPress(KeyEvent.VK_9);
			rbt.keyRelease(KeyEvent.VK_9);
			rbt.keyPress(KeyEvent.VK_5);
			rbt.keyRelease(KeyEvent.VK_5);
			
			driver.findElement(By.name("submit")).click();   
			
			driver.findElement(By.name("cnfrm-submit")).click();
			
			
			String popupMessage = webDriverUtility.alertHandle(driver);
			System.out.println(popupMessage);
			
			
			String appNo = javaUtility.fetchNumberFromAlert(popupMessage);
			System.out.println(appNo);
		
	     	driver.findElement(By.xpath("//a[.='Staff Login']")).click();
			driver.findElement(By.name("staff_id")).sendKeys(staffId);
			driver.findElement(By.name("password")).sendKeys(passWord);
			driver.findElement(By.name("staff_login-btn")).click();
			driver.findElement(By.name("apprvac")).click();
			Thread.sleep(5000);
			driver.findElement(By.name("application_no")).sendKeys(appNo);
			driver.findElement(By.name("search_application")).click();
			driver.findElement(By.name("approve_cust")).click();
		
		    String popupMessageApprove = webDriverUtility.alertHandle(driver);
			System.out.println(popupMessageApprove);
			
			String ACCNO = javaUtility.fetchNumberFromAlert(popupMessageApprove);
			System.out.println(ACCNO);
			
			driver.findElement(By.xpath("//h5[.=' Online Banking System']"));
			
			driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
			
			
			
			
			   
		                                             

	}
	
	
	
	
	
}
