package org.sdet40.ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage 
{
	
		@FindBy(xpath="//input[@placeholder='Account Holder Name']")
		private WebElement accHolderName;
		
		// Date Of Birth
		@FindBy(xpath="//input[@placeholder='Date of Birth']")
		private WebElement dateOfBirth;
		
		@FindBy(xpath="//input[@placeholder='PAN']")
		private WebElement panNo;
		
		@FindBy(xpath="//input[@placeholder='Registered Mobile (10 Digit)']")
		private WebElement registerMobNo;
		
		@FindBy(xpath="//input[@placeholder='Account No']")
		private WebElement accNo;
		
		@FindBy(xpath="name=\"dbt_crd_submit\"")
		private WebElement submitQueryButton;
		
		public ApplyDebitCardPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void applyDebitCard(Map<String, String>testData,String accno)
		{
			accHolderName.sendKeys(testData.get("NAME"));
	
			dateOfBirth.sendKeys(testData.get("DATE OF BIRTH"));
			
			panNo.sendKeys(testData.get("PAN NO"));
			
			registerMobNo.sendKeys(testData.get("MOBILE NUMBER"));
			
			accNo.sendKeys(accno);
			
			submitQueryButton.click();
		}
}

