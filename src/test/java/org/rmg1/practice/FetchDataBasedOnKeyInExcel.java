package org.rmg1.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataBasedOnKeyInExcel {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/hari.xlsx");
		Workbook book = WorkbookFactory.create(fisExcel);
		Sheet sheet = book.getSheet("Sheet1");
		DataFormatter df = new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++) {
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j))+" || ");
			}
			
			System.out.println();
			
		}
		
		
}
}