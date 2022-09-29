package org.sdet40.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCustomerByAccNo {
	
	   @FindBy(xpath="//input[@placeholder='Customer Account No']")
	   private WebElement customerAccNo;
	   
	   @FindBy(xpath="//input[@value='Submit']")
	   private WebElement submitButton;
	   
	   public ViewCustomerByAccNo(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   
	   public void ViewByAccNo(String accno)
	   {
		   customerAccNo.sendKeys(accno);
		   
		   submitButton.click();
	   }

}
