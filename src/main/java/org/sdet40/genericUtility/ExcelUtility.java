package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	     Workbook workbook;
	     
	     public void  openExcel(String excelPath) 
	     {
	    	 
	    	 FileInputStream fisExcel = null;
	    	 
			try {
				
				fisExcel = new FileInputStream(excelPath);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				
			}
			
			
	    	 try {
	    		 
				workbook = WorkbookFactory.create(fisExcel);
				
			} catch (EncryptedDocumentException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
	     }
	     
	     
			public String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
				
				Sheet sheet = workbook.getSheet(sheetName);
				
				String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
				
				return data;
				
			}
			
			
			 public void closeExcelWorkBook() 
			 {
				 
				 try {
					 
					workbook.close();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
			 }
			 
			 
			 public void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String text) {
				    
				Sheet sheet = workbook.getSheet(sheetName);
				
				sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(text);
				
			 }
			 
			 
			 public void saveDataIntoExcel(String outputPath) {
				 
				 try {
					 
					workbook.write(new FileOutputStream(outputPath));
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
					
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
			 }
			 
			 public Map<String, String> getDataFromExcelInMap(String sheetName){
				 
				 Sheet sheet = workbook.getSheet(sheetName);
				 
				 Map<String, String> map = new HashMap<>();
				DataFormatter df = new DataFormatter();
				
				for(int i=0; i<=sheet.getLastRowNum(); i++) {
					
					   map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),df.formatCellValue(sheet.getRow(i).getCell(1)));
				}
				return map;
				}
			 
			 public List<Map<String, String>> getDataFromExcelInList(String sheetName){
				 
				Sheet sheet = workbook.getSheet(sheetName);
				List<Map<String, String>> list = new ArrayList<>();
				DataFormatter df = new DataFormatter();
				
				for(int k=1; k<sheet.getRow(0).getLastCellNum(); k++) {
					
				Map<String, String>	map = new HashMap<>();	
				for(int i=0; i <=sheet.getLastRowNum(); i++) {
					
					map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue( sheet.getRow(i).getCell(k)));
					
				}
				list.add(map);
			 }
			 return list;
			 }	 
				 
				 
			 }
			 
				 
			 
	     

