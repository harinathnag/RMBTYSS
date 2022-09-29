package org.rmg1.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMytrip {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		      
			FileInputStream fis = FileInputStream("");
			Workbook book = WorkbookFactory.create(fis);
			Sheet sheet = book.getSheet("");
				
		      WebDriverManager.firefoxdriver().setup();
		      WebDriver driver =new FirefoxDriver();
		      driver.get("https://www.makemytrip.com/flights/");
		      driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chTrains']")).click();
		      
	
	   
		
		
		}

	private static FileInputStream FileInputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
