package org.rmg1.practice;



import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/hari.xlsx");
		Workbook book=WorkbookFactory.create(fisExcel);
		Sheet sheet =book.getSheet("Sheet1");
		 org.apache.poi.ss.usermodel.Row row = sheet.getRow(0);
		Cell cell=row.getCell(1);
		String username =cell.getStringCellValue();
		System.out.println(username);
		book.close();
		
		
		
	}

}
