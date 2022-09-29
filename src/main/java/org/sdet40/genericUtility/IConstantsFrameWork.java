package org.sdet40.genericUtility;

public interface IConstantsFrameWork {
	
	String PROJECT_PATH = System.getProperty("user.dir");
	String EXCEL_PATH = PROJECT_PATH+"/src/test/resources/hari.xlsx";
	String PROPERTIES_PATH = PROJECT_PATH+"/src/test/resources/HariData.properties";
	String DB_URL = "jdbc:mysql://localhost:3306/rmb";

}
