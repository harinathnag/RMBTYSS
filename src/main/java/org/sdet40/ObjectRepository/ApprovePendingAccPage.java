package org.sdet40.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAccPage {
	
		@FindBy(xpath="//input[@placeholder='Application number']")
		private WebElement applicationNo;
		
		@FindBy(xpath="//input[@value='Search']")
		private WebElement searchButton;
		
		@FindBy(xpath="//input[@value='Approve']")
		private WebElement approveButton;
		
		public ApprovePendingAccPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void approveAcc(String appno ) throws InterruptedException
		{
			applicationNo.sendKeys(appno);
			Thread.sleep(3000);
			searchButton.click();
			Thread.sleep(3000);
			approveButton.click();
			Thread.sleep(3000);
		}

}
