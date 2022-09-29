package org.sdet40.testNGpractice;

import org.testng.annotations.Test;

public class AnnotationsFortestNG {
	
	      @Test(priority = 1)
	      public void openAccountTest()
	      {
	    	  System.out.println("account no is generated");
	      }
	      @Test(priority = 2)
	      public void debitCardTest()
	      {
	    	  System.out.println("debit card no is generated");
	      }
	      @Test(priority = 3)
	      public void deleteCustomerTest()
	      {
	    	  System.out.println("customer account is deleted");
	      }
	      @Test(priority = 4)
	      public void creditCustomerTest()
	      {
	    	  System.out.println("credit money to customer");
	      }
	      
	

}
