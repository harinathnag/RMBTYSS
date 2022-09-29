package org.rmg1.practice;

import java.io.IOException;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class OpenAccountTC1 extends BaseClass {

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
		webdriverUtility.tcValidationUsingSoftAssert(poPupText2, "Account Created Successfully");
		
		String accNo = javaUtility.fetchNumberFromAlert(poPupText2);
		System.out.println(accNo);	
		
		webdriverUtility.screenShot(driver, javaUtility, "RMBTc11");		 
	}
}