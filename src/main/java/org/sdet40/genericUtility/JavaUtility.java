package org.sdet40.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility{
              
	
	        public  int getRandomNumber(int limit) {
	        	return new Random().nextInt(limit);
	        	
	        }
	        public Object covertStringIntoAnyDataType(String data, DataType strategy) {
	        	Object obj = null;
	        	if(strategy.toString().equalsIgnoreCase("long")) {
	        		obj = Long.parseLong(data);
	        		
	        	}else if(strategy.toString().equalsIgnoreCase("int")) {
	        		obj = Integer.parseInt(data);
	        	}else if(strategy.toString().equalsIgnoreCase("double")) {
	        		obj = Double.parseDouble(data);
	        	}
	        	return obj;
	        }
	        
	        public String fetchNumberFromAlert(String value) {
	        	
	        	String appno = "";
	        	
	        	for(int i=0; i<value.length(); i++)
	    		{
	    			if(value.charAt(i)>='0'&& value.charAt(i)<='9')
	                {
	    				appno=appno+value.charAt(i);
	                }
	    		
	             }
	        	return appno;
	        	
	        }     
	         /**
	          * This method is used to convert the current date and time into "dd_MM_yyyy_hh_mm_sss" Format
	          * @return
	          */
	                            
	        public String currentTime()
	        {
	         Date date	= new Date();
	         SimpleDateFormat sDateForm = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
	         String actualDate = sDateForm.format(date);
	         
	         return actualDate;
	        }
	        
	

}
