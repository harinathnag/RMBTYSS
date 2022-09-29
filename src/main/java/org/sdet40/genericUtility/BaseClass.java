package org.sdet40.genericUtility;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.sdet40.ObjectRepository.ApplyDebitCardPage;
import org.sdet40.ObjectRepository.ApprovePendingAccPage;
import org.sdet40.ObjectRepository.CommonPage;
import org.sdet40.ObjectRepository.CreditCustomerActoin;
import org.sdet40.ObjectRepository.DeleteCustomerPage;
import org.sdet40.ObjectRepository.OpeningFormPage;
import org.sdet40.ObjectRepository.StaffCommonPage;
import org.sdet40.ObjectRepository.StaffLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	
	private List<Map<String, String>> commonData;
	protected Map<String, String> testData;
	protected ExcelUtility excelUtility;
	protected JavaUtility javaUtility;
	protected static JavaUtility sjavaUtility;
	protected WebdriverUtility webdriverUtility;
	protected WebDriver driver;
	public static WebDriver sdriver;
	protected CommonPage commonPage;
	protected StaffLoginPage staffLoginPage;
	protected StaffCommonPage staffCommonPage;
	protected OpeningFormPage openingFormPage;
	protected FileUtility fileUtility;
	protected DatabaseUtility databaseUtility;
	protected String staffid;
	protected String password;
	protected ApprovePendingAccPage approvePendingAccPage;
	protected ApplyDebitCardPage applyDebitCardPage;
	protected CreditCustomerActoin creditCustomerActoin;
	protected DeleteCustomerPage deleteCustomerPage;


	@BeforeClass
	public void classSetup() throws IOException
	{
		//create instance for the genericUtility
		excelUtility = new ExcelUtility();
		fileUtility= new FileUtility();
		javaUtility = new JavaUtility();
		sjavaUtility=javaUtility;
		webdriverUtility=new WebdriverUtility();
		//initialize property file and excel file
		excelUtility.openExcel(IConstantsFrameWork.EXCEL_PATH);
		fileUtility.initializePropertyFile(IConstantsFrameWork.PROPERTIES_PATH);
	}

	@BeforeMethod
	public void testDataSetup()
	{


		commonData = excelUtility.getDataFromExcelInList("formSheet");
		testData= excelUtility.getDataFromExcelInMap("formSheet");

		String url = fileUtility.getDataFromPropertyFile("url");
		staffid = fileUtility.getDataFromPropertyFile("StaffId");
		password= fileUtility.getDataFromPropertyFile("Password");

		driver = webdriverUtility.openBrowserWithApplication("chrome", url);
		sdriver=driver;
		webdriverUtility.maximizeBrowser(driver);
		commonPage = new CommonPage(driver);
		openingFormPage = new OpeningFormPage(driver);
		staffLoginPage = new StaffLoginPage(driver);
		approvePendingAccPage = new ApprovePendingAccPage(driver);
		staffCommonPage = new StaffCommonPage(driver);
		applyDebitCardPage=new ApplyDebitCardPage(driver);
		CreditCustomerActoin creditCustomerActoin = new CreditCustomerActoin(driver);
		deleteCustomerPage = new DeleteCustomerPage(driver);

	}

	@AfterMethod
	public void tearLogins()
	{

		webdriverUtility.closeBrowser(driver);
	}    
	@AfterClass
	public void classTearDown()
	{
		excelUtility.closeExcelWorkBook();
	}
}
