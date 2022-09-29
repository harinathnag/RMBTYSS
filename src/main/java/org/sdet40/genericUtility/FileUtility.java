package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	      
	        Properties properties;
	        
	        public String getDataFromPropertyFile(String key) {
	        	String value = properties.getProperty(key).trim();
	        	return value;
	        	
	        }
	        public void initializePropertyFile(String propertyFilePath) throws IOException {
	        	FileInputStream fis = new FileInputStream(propertyFilePath);
	        	properties = new Properties();
	        	properties.load(fis);
	        }
	

}
