package org.rmg1.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingMethodChaining {
	
			
	    public static void main(String[] args) throws EncryptedDocumentException, IOException {
			
	    	FileInputStream fisExcel = new FileInputStream("./src/test/resources/hari.xlsx");
	    	Workbook book = WorkbookFactory.create(fisExcel);
	    	try {    	
	    	 org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Sheet1");
	    	String username = sheet.getRow(2).getCell(1).getStringCellValue();
	    	String password = sheet.getRow(1).getCell(1).getStringCellValue();
	    	String url = sheet.getRow(0).getCell(1).getStringCellValue();
	    	String browser = sheet.getRow(3).getCell(1).getStringCellValue();
	    	
	    	}
	    	   finally {
	    		      
	    		   book.close();
	    	   }
}
}

