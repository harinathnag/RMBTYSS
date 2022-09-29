package org.rmg1.practice;

import java.io.IOException;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class DeleteCustomerTC4 extends BaseClass {
	
	 @Test
	 public void testcase1() throws IOException, InterruptedException
		
	 {
		commonPage.OpenAccountButton();
		openingFormPage.openingAccForm(testData);   
		String poPupText = webdriverUtility.alertHandle(driver);
		String applicationNo = javaUtility.fetchNumberFromAlert(poPupText);
		commonPage.StaffLoginLink();
		staffLoginPage.StaffLoginAction(staffid,password);	
		staffCommonPage.ApprovePendingAcc();
		approvePendingAccPage.approveAcc(applicationNo);	
		String poPupText2 = webdriverUtility.alertHandle(driver);
		String accNo = javaUtility.fetchNumberFromAlert(poPupText2);	
		String poPupText3 = webdriverUtility.alertHandle(driver);
		String customerId = javaUtility.fetchNumberFromAlert(poPupText3);
		staffCommonPage.Home();
		staffCommonPage.DeleteCustomerAcc();
		deleteCustomerPage.deleteCustomerAction(accNo, customerId, "duplicate");	
		String poPupText4 = webdriverUtility.alertHandle(driver);
		String deleteScucces = javaUtility.fetchNumberFromAlert(poPupText4);
		System.out.println(deleteScucces);
    	webdriverUtility.screenShot(driver, javaUtility, "RMBTc11");	 
}
}
	
	


