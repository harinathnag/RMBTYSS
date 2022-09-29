package org.rmg1.practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafCalender {

	public static void main(String[] args) {
		    
		     WebDriverManager.firefoxdriver().setup();
		    FirefoxDriver driver = new FirefoxDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    
		    String requiredDate = "17";
		    String requiredMonth = "December";
		    String requiredYear = "2022";
		    
		    int requiredMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(requiredMonth).get(ChronoField.MONTH_OF_YEAR);
		    int requiredYearInNumber = Integer.parseInt(requiredYear);
		    
		    driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		    driver.findElement(By.id("datepicker")).click();
		   
		    String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		    String[] str = actualMonthYear.split(" ");
		    String actualMonth = str[0];
		    String actualYear = str[1]; 
		    
		    int actualMonthInNumber =   DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		   
		    int actualYearInNumber = Integer.parseInt(actualYear);
		  
		    while(requiredMonthInNumber>actualMonthInNumber || requiredYearInNumber>actualYearInNumber) {
		    	
		    	driver.findElement(By.xpath("//span[.='Next']")).click();
		    	actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		    	str = actualMonthYear.split(" ");
		    	 actualMonth = str[0];
		    	 actualYear = str[1];
		    	actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		    	actualYearInNumber = Integer.parseInt(actualYear);
		    	
		           } 
		    while(requiredMonthInNumber<actualMonthInNumber || requiredYearInNumber<actualYearInNumber) 
		     {	    	
		    	driver.findElement(By.xpath("//span[.='Prev']")).click();
		    	actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		    	str = actualMonthYear.split(" ");
		    	 actualMonth = str[0];
		    	 actualYear = str[1];
		    	actualMonthInNumber = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);
		    	actualYearInNumber = Integer.parseInt(actualYear);
		              }  
		    driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click(); 
		    
	}

}
