package org.rmg1.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase1 {
	
         public static void main(String[] args) throws SQLException {
			
        	 Driver dbdriver = new Driver();
        	 DriverManager.registerDriver(dbdriver);
        	 Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:/rmb", "root", "root");
        	 try {
        		 Statement statement = connection.createStatement();
        		 ResultSet result = statement.executeQuery("select * from barclays;");
        		 while(result.next()) {
        			 System.out.println(result.getString("emp_name"));
        		 }
        	 }finally {
        		 connection.close();
        		 System.out.println("connection closed successfully");
        	 }
		}
}
