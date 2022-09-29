package org.rmg1.practice;

import java.io.IOException;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class ApplyDebitCardTC2 extends BaseClass {
	
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
		System.out.println(accNo);
		commonPage.OnlineBankingSystem();	
		commonPage.applyDebitCard();	
		String poPupText3 = webdriverUtility.alertHandle(driver);
		String DebitSccess = javaUtility.fetchNumberFromAlert(poPupText3);
		System.out.println(DebitSccess);
		applyDebitCardPage.applyDebitCard(testData, accNo); 
		webdriverUtility.screenShot(driver, javaUtility, "RMBTc11");	
		
}
}
