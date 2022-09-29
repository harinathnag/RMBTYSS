package org.rmg1.practice;

import java.io.IOException;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class CreditCustomerTC3 extends BaseClass {
	
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
		commonPage.StaffLoginLink();
		staffCommonPage.creditCustomer();
		creditCustomerActoin.creditAction(testData, accNo);	
		String poPupSuccess = webdriverUtility.alertHandle(driver);
		String sucessText = javaUtility.fetchNumberFromAlert(poPupSuccess);
		System.out.println(sucessText);	
		webdriverUtility.screenShot(driver, javaUtility, "RMBTc11");	
}
}




	/*	commonPage.StaffLoginLink();
		staffCommonPage.creditCustomer();
		creditCustomerActoin.creditAction(testData, accNo);
		
		
		System.out.println("Done");
		
		
	 }
}         */


