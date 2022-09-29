package org.sdet40.ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerActoin {
	
		@FindBy(xpath="//input[@placeholder='Customer A/c No']")
		private WebElement customerAccountNo;
       
		@FindBy(xpath="//input[@placeholder='Amount']")
		private WebElement ammount;
		
		@FindBy(xpath="//input[@value='Credit']")
		private WebElement CreditButton;
		
		//Initialization
		public CreditCustomerActoin(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Utilization
		public void creditAction(Map<String, String>testData, String accno)
		{
			customerAccountNo.sendKeys(accno);
			
			ammount.sendKeys("MONEY");
			
			CreditButton.click();
			
			
		}
}
