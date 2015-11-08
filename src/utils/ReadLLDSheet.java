/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author user
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadLLDSheet{

    @SuppressWarnings("unchecked")
    public static List ReadLLDSheet(String FileName, int SheetNo) throws IOException{
        //
        //
        // Create an ArrayList to store the data read from excel sheet.
        //
        List sheetData = new ArrayList();

        FileInputStream fis = null;
        try {
            //
            // Create a FileInputStream that will be use to read the excel file.
            //
            fis = new FileInputStream(FileName);

            //
            // Create an excel workbook from the file system.
            //
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //
            // Get the first sheet on the workbook.
            //
            XSSFSheet sheet = workbook.getSheetAt(SheetNo);

            //
            // When we have a sheet object in hand we can iterator on each
            // sheet's rows and on each row's cells. We store the data read
            // on an ArrayList so that we can printed the content of the excel
            // to the console.
            //
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    data.add(cell);
                }

                sheetData.add(data);
            }
        } catch (IOException e) {
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return sheetData;

   }

   
    public static void main(String[] args) throws IOException{
//    ReadLLDSheet("./LLD.xlsx",2);
    }
}

