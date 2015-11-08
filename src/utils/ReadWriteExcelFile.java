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
import com.mysql.jdbc.StringUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetDimension;
import static utils.CharToInt.CharToInt;

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
                List<String> dimensions = StringUtils.split(sheetDimensions, ":", true);
                String[] Dimensions = dimensions.get(1).toString().split("(?<=\\D)(?=\\d)");
                int Colums = CharToInt(Dimensions[0]);
                int Rows = Integer.parseInt(Dimensions[1]);
                System.out.println();
		Iterator rows = sheet.rowIterator();
                ArrayList[][] TableName = new ArrayList[Rows][Colums];
                System.out.println(TableName.length);
                int currentRow=0;
		while (rows.hasNext())
		{
                    
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
                        int currentCell=0;
//			System.out.println("currentRow="+currentRow+" And Current Colum is ="+currentCell);
                        while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                
                                if(cell.getStringCellValue().isEmpty()){
                                    TableName[cell.getRowIndex()][cell.getColumnIndex()].add(" - ");                                                                            
//					System.out.print(cell.getStringCellValue()+" ");
//                                        TableName[currentRow][currentCell].add(" ");
//				System.out.println("Cell Value is : "+cell.toString());
//                                System.out.println("Empty cell currentRow="+currentRow+" And Current Colum is ="+currentCell);
                                        
				} else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
                                    System.out.println("current Row="+cell.getRowIndex()+" And Current Colum is ="+cell.getColumnIndex());
                                    System.out.println(cell.getRichStringCellValue());
                                    TableName[cell.getRowIndex()][cell.getColumnIndex()].add(cell.getRichStringCellValue().toString());
//                                    System.out.println("Cell Type is :"+cell.getCellType());
//                                    System.out.println("Cell Value is : "+cell.getRichStringCellValue());
                                    }
                                    else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                                    TableName[cell.getRowIndex()][cell.getColumnIndex()].add(cell.getNumericCellValue());                                    
//                                    System.out.println("Cell Type is :"+cell.getCellType());
//                                    System.out.println("current Row="+cell.getRowIndex()+" And Current Colum is ="+cell.getColumnIndex());
//                                    int numericValue = (int) cell.getNumericCellValue();
//                                    System.out.println("Cell Value is : "+numericValue);
                                    
                                    }
//				else
//				{
//					//U Can Handel Boolean, Formula, Errors
//				}
                                currentCell++;
			}
			System.out.println();
                        currentRow++;
		}
for (int i=0;TableName.length>i;i++){
    for (int j=0;TableName[i].length>j;j++){
System.out.println(TableName[i][j].toString());    
    }

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
		readXLSXFile("./LLD.xlsx",2);

	}

}