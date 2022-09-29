package org.rmg1.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		
	   FileInputStream fis = new FileInputStream("./src/test/resources/HariData.properties");
	   Properties property =new Properties();
	   property.load(fis);
	   String url= property.getProperty("url");
	   System.out.println(url);
	}

}
