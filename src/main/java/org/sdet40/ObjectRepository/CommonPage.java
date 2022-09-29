package org.sdet40.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage 
{
	//declaration
	@FindBy(xpath="//li[.='Open Account']")
	private WebElement openAccountButton;
	
	@FindBy(xpath="//li[.='Apply Debit Card']")
	private WebElement applyDebitCardButton;
	
/*   @FindBy(xpath="//a[@id='ebanking']")
	private WebElement internetBanking;  
	
	@FindBy(xpath="")
	private WebElement loginButton;    */
	
	@FindBy(xpath="//li[.='Fund Transfer']")
	private WebElement fundTransfer; 
	
	@FindBy(xpath="//h5[.=' Online Banking System']")
	private WebElement onlineBankingSystem; 
	
	@FindBy(xpath="//a[.='Staff Login']")
	private WebElement staffLoginLink;
	
	@FindBy(xpath="//a[.='Home']")
	private WebElement custHome;
	
	//Initialization
	public CommonPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	} 
	//Utilization
	public void OpenAccountButton()
	{
		openAccountButton.click();
	}
	
	public void applyDebitCard()
	{
		applyDebitCardButton.click();
	}
	
	/*public void InternetBanking()
	{
		internetBanking.click();
	}  */
	public void FundTransfer()
	{
		fundTransfer.click();
	}
	public void OnlineBankingSystem()
	{
		onlineBankingSystem.click();
	}
	public void StaffLoginLink()
	{
		staffLoginLink.click();
	}
	public void custHome()
	{
		custHome.click();
	}
	
}
