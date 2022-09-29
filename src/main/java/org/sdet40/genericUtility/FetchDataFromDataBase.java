package org.sdet40.genericUtility;

import java.util.List;

public class FetchDataFromDataBase {
	
	       public  static void main(String[] args) {
	    	   
	    	  DatabaseUtility databaseUtility = new DatabaseUtility();
	    	  databaseUtility.openDBConnection(IConstantsFrameWork.DB_URL, "root", "root");
	    	  
	    	  List<String> data = databaseUtility.getDataFromDataBase("select * from barclays;", "phone_number");
	    	  List<String> data1 = databaseUtility.getDataFromDataBase("select * from barclays;", "phone_number");
	    	  List<String> data2 = databaseUtility.getDataFromDataBase("select * from barclays;", "phone_number");
	    	  
	    	  System.out.println(data);
	    	  System.out.println(data1);
	    	  System.out.println(data2);
	    	  databaseUtility.closeDB();

	    	  
	    	   
	    	   
	       }
	

}
