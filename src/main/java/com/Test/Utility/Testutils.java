package com.Test.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Testutils {
	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   

   try {

	   FileInputStream ExcelFile = new FileInputStream("C:\\Users\\varun\\Desktop\\TestData.xlsx");

	   // Access the required test data sheet

	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet("Sheet1");

	   int startRow = 1;

	   int startCol = 1;

	   
	   int totalRows = ExcelWSheet.getLastRowNum();

	  
	   Row=ExcelWSheet.getRow(0);
	   
	   
	 
	   int totalCols = Row.getLastCellNum();

	   String[][] tabArray=new String[totalRows][totalCols];

	  
	   for (int i=1;i<=totalRows;i++) {           	   
         Row =ExcelWSheet.getRow(i);
		  
		   for (int j=0;j<=totalCols;j++){
			   Cell =Row.getCell(j);

			   try {
					if (Cell.getCellType() == Cell.CELL_TYPE_STRING) {
						tabArray[i - 1][j] = Cell.getStringCellValue();
					} 
					else
					 {
						tabArray[i - 1][j] = String.valueOf(Cell.getNumericCellValue());
					}
					} catch (Exception e) {
					     e.printStackTrace();
					}
					   }
					  }
					  return tabArray;}finally{
						  
					  }
}
					}