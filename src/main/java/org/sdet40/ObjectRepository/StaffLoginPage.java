package org.sdet40.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.FileUtility;

public class StaffLoginPage {



	//Declaration
	@FindBy(xpath ="//input[@type='text']")
	private WebElement staffIdTextField;

	@FindBy(xpath ="//input[@type='password']")
	private WebElement passwordTextField;

	@FindBy(xpath ="//input[@type='submit']")
	private WebElement logInButton;



	//initialization
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void StaffLoginAction(String StaffId,String Password)
	{
		staffIdTextField.sendKeys(StaffId);
		passwordTextField.sendKeys(Password);
		logInButton.click();

	}

}
