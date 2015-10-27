package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amrmostafa
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;

public class ReadWriteExcelFile {

	public static void readXLSFile(String aFile) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(aFile);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet=wb.getSheetAt(0);
		HSSFRow row; 
		HSSFCell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next();
		
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	
	}
	
	public static void writeXLSFile(String aFile, String aSheet) throws IOException {
		
		String excelFileName = aFile;//name of excel file

		String sheetName = aSheet;//name of sheet

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;

		//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			HSSFRow row = sheet.createRow(r);
	
			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				HSSFCell cell = row.createCell(c);
				
				cell.setCellValue("Cell "+r+" "+c);
			}
		}
		
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public static void readXLSXFile(String aFile,int SheetNo) throws IOException
	{
            
		InputStream ExcelFileToRead = new FileInputStream(aFile);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(SheetNo);
		XSSFRow row; 
		XSSFCell cell;
                CTSheetDimension dimension = sheet.getCTWorksheet().getDimension();
                String sheetDimensions = dimension.getRef();
                System.out.println(sheetDimensions);
                
		Iterator rows = sheet.rowIterator();
//                ArrayList[][] TableName = new ArrayList[10][10];
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	
	}
	
	public static void writeXLSXFile(String aFile,String aSheet) throws IOException {
		
		String excelFileName = aFile;//name of excel file

		String sheetName = aSheet;//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
                
		//iterating r number of rows
//		for (int r=0;r < 5; r++ )
//		{
//			XSSFRow row = sheet.createRow(r);
//
//			//iterating c number of columns
//			for (int c=0;c < 5; c++ )
//			{
//				XSSFCell cell = row.createCell(c);
//	
//				cell.setCellValue("Cell "+r+" "+c);
//			}
//		}

		FileOutputStream fileOut = new FileOutputStream(excelFileName);

		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}

	public static void main(String[] args) throws IOException {
		
//		writeXLSFile("./test.xls","testSheet");
//		readXLSFile("test.xls");
//		
//		writeXLSXFile("test.xlsx","testSheet");
		readXLSXFile("./LLD.xlsx",1);

	}

}