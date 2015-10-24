/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
  
/** 
 * @author Amr Mostafa
 *  
 */  
public class ReadCsv {  
 public void readCsv() {  
  String csvFileToRead = "./tunables.csv";  
  BufferedReader br = null;  
  String line = "";  
  String splitBy = ",";  
  
  try {  
  
   br = new BufferedReader(new FileReader(csvFileToRead));  
   while ((line = br.readLine()) != null) {  
  
    String[] props = line.split(splitBy);  
//    System.out.println("props [propoerty= " + props[0] + " , folder="  
//      + props[1] + " , file=" + props[2]+",Regular Expresions = "+props[3]+"]" );  
  
   }  
  
  } catch (FileNotFoundException e) {  
   e.printStackTrace();  
  } catch (IOException e) {  
   e.printStackTrace();  
  } finally {  
   if (br != null) {  
    try {  
     br.close();  
    } catch (IOException e) {  
     e.printStackTrace();  
    }  
   }  
  }  
  
  System.out.println("Done with reading CSV");  
 }  
}  
