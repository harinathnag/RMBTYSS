package org.sdet40.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	   @FindBy(xpath="//input[@placeholder='Customer Account No']")
	   private WebElement customerAccNo;

	   @FindBy(xpath="//input[@placeholder='Customer ID']")
	   private WebElement customerId;
	   
	   @FindBy(xpath="//input[@placeholder='Reason']")
	   private WebElement reason;  
	   
	   @FindBy(xpath="value=\"Delete\"")
	   private WebElement  accDelete;  
	 
	   //Initialization
	   public DeleteCustomerPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   
	   //Utilization 
	   public void deleteCustomerAction(String AccNo , String Id, String issue)
	   {
		   customerAccNo.sendKeys(AccNo);
		   
		   customerId.sendKeys(Id);
		   
		   reason.sendKeys(issue);
		   
		   accDelete.click();
	   }
}
