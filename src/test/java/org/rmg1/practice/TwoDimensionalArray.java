package org.rmg1.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class TwoDimensionalArray {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/hari.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("sheet1");
		DataFormatter df = new DataFormatter();
		 String  value = null;
		 for(int i=0; i<sheet.getLastRowNum(); i++){
		            String key = df.formatCellValue(sheet.getRow(i).getCell(0));
		            if(key.equalsIgnoreCase("password")) {
		            	value = df.formatCellValue(sheet.getRow(i).getCell(1));
		            	break;
		            }
			 
		 }
		 System.out.println(value);
	}

}
