package org.sdet40.ObjectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebdriverUtility;

public class OpeningFormPage {

	//Declaration
	@FindBy(xpath ="//input[@placeholder='Name']")
	private WebElement nameTextField;

	@FindBy(xpath ="//input[@placeholder='Mobile no']")
	private WebElement mobileTextField;

	@FindBy(xpath ="//input[@placeholder='Email id']")
	private WebElement emailIdTextField;

	@FindBy(xpath ="//input[@placeholder='Landline no']")
	private WebElement landLineNoTextField;

	@FindBy(xpath ="//input[@placeholder='PAN Number']")
	private WebElement panNoTextField;

	@FindBy(xpath ="//input[@placeholder='Citizenship Number']")
	private WebElement citizenNoTextField;

	@FindBy(xpath ="//input[@placeholder='Home Address']")
	private WebElement homeAddTextField;

	@FindBy(xpath ="//input[@placeholder='Office Address']")
	private WebElement officeAddTextField;

	@FindBy(xpath ="//input[@placeholder='Pin Code']")
	private WebElement pinCodeTextField;

	@FindBy(xpath ="//input[@placeholder='Area/Locality']")
	private WebElement AreaLocTextField;

	@FindBy(xpath ="//input[@placeholder='Nominee Name (If any)']")
	private WebElement nomNameTextField;

	@FindBy(xpath ="//input[@placeholder='Nominee Account no']")
	private WebElement nomAccNoTextField;

	@FindBy(xpath="//select[@name='gender']")
	private  WebElement genderDropDown;

	@FindBy(xpath="//select[@name='state']")
	private WebElement stateDropDown;

	@FindBy(xpath="//select[@name='city']")
	private WebElement cityDropDown;

	@FindBy(xpath="//select[@name='acctype']")
	private WebElement accTypeDropDown;


	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;

	@FindBy(xpath="//input[@placeholder='Date of Birth']")
	private WebElement dateOfBirth;
	
	@FindBy(xpath="//input[@value='Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath="//input[@value='Go back']")
	private WebElement goBackButton;

	//Initialization
	public OpeningFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization 
	public void openingAccForm(Map<String, String> testData )
	{
		nameTextField.sendKeys(testData.get("NAME"));

		mobileTextField.sendKeys(testData.get("MOBILE NUMBER"));

		emailIdTextField.sendKeys(testData.get("EMAIL ID"));

		landLineNoTextField.sendKeys(testData.get("LANDLINE NO"));

		panNoTextField.sendKeys(testData.get("PAN NO"));

		citizenNoTextField.sendKeys(testData.get("CITIZENSHIP"));

		homeAddTextField.sendKeys(testData.get("HOME ADDRESS"));

		officeAddTextField.sendKeys(testData.get("OFFICE ADDRESS"));

		pinCodeTextField.sendKeys(testData.get("PIN CODE"));

		AreaLocTextField.sendKeys(testData.get("AREA LOC"));

		nomNameTextField.sendKeys(testData.get("NOMINEE NAME"));

		nomAccNoTextField.sendKeys(testData.get("NOMINEE ACCNO"));

		WebdriverUtility webdriverUtility= new WebdriverUtility();
		webdriverUtility.selectClass(genderDropDown,"Male");
		webdriverUtility.selectClass(stateDropDown, "Alaska" );
		webdriverUtility.selectClass(cityDropDown, "Olympia");
		webdriverUtility.selectClass(accTypeDropDown, "Saving");
		dateOfBirth.click();
		dateOfBirth.sendKeys("17-01-1995");
		submit.click();
	/*	goBackButton.click();
		submit.click();     */
		confirmButton.click();
		
		
		
		

	}









}
