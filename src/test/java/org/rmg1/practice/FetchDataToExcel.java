package org.rmg1.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataToExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/hari.xlsx");
		Workbook book = WorkbookFactory.create(fisExcel);
		Sheet sheet = book.getSheet("Sheet2");
		Row row = sheet.createRow(2);
		Cell cell = row.createCell(3);
		cell.setCellValue("Harinath");
		System.out.println("Data updated successfully");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/hari.xlsx");
		book.write(fos);
	}

}
