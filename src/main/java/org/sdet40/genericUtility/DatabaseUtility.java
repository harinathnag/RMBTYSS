package org.sdet40.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;


public class DatabaseUtility {
            
	      Connection connection;
	      
	      public List<String>getDataFromDataBase(String query, String columName) {
	    	  
	    	     Statement Statement = null;
	    	     
				try {
					
					Statement = connection.createStatement();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
	    	  ResultSet result = null;
	    	  
			try {
				
				result = Statement.executeQuery(query);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
	    	     List<String> list = new ArrayList<>();
	    	     
	    	     try {
	    	    	 
					while(result.next()) {
						 
						 list.add(result.getString(columName));
						 
					 }
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
	    	     return list;
	    	  
	      }
	       public void openDBConnection(String dbURL, String dbUserName, String dbPassword) {
	    	        
	    	 Driver dbDriver = null;
	    	 
			try {
				
				dbDriver = new Driver();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	 try {
	    		 
				DriverManager.registerDriver(dbDriver);
				
			} catch (SQLException e1) {
				

				e1.printStackTrace();
				
			}
	    	try {
	    		
				connection =  DriverManager.getConnection(dbURL, dbUserName, dbPassword);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
	    	 
	    	   
	       }
	       
	       public void closeDB() {
	    	   
	    	   try {
	    		   
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	       }
	        
}
