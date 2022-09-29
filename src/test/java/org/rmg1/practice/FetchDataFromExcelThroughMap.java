package org.rmg1.practice;

import java.util.Map;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantsFrameWork;

public class FetchDataFromExcelThroughMap {
	
	      public static void main(String[] args) {
			
	    	ExcelUtility excelUtility = new ExcelUtility();
	    	excelUtility.openExcel(IConstantsFrameWork.EXCEL_PATH);
	    	Map<String, String> map = excelUtility.getDataFromExcelInMap("formSheet");
	    	System.out.println(map.get("NOMINEE NO"));
	    	
	    	  
		}
	

}
