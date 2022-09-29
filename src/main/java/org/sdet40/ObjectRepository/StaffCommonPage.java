package org.sdet40.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffCommonPage {

	//Declaration
	@FindBy(xpath="//input[@value='View Active Customer']")
	private WebElement viewActiveCustomer;

	@FindBy(xpath="//input[@value=\"View Customer by A/c No\"]")
	private WebElement viewCustomerByAccNo;

	@FindBy(xpath="//input[@value='Approve Pending Account']")
	private WebElement approvePendingAcc;

	@FindBy(xpath="//input[@value='Delete Customer A/c']")
	private WebElement deleteCustomerAcc;

	@FindBy(xpath="//input[@value='Credit Customer']")
	private WebElement creditCustomer;

	@FindBy(xpath="//input[@value='Home']")
	private WebElement home;

	@FindBy(xpath="//input[@value='Logout']")
	private WebElement logOut;

	//Initialization
	public StaffCommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void ViewActiveCustomer()
	
	{
	    viewActiveCustomer.click();
	}
	public void ViewCustomerByAccNo()
	{
		viewCustomerByAccNo.click();
	}
	public void ApprovePendingAcc()
	{
		approvePendingAcc.click();
	}
	public void DeleteCustomerAcc()
	{
		deleteCustomerAcc.click();
	}
	public void creditCustomer()
	{
	   creditCustomer.click();
	}
	public void Home()
	{
		home.click();
	}
	public void LogOut()
	{	
		logOut.click();
	}

	

}
