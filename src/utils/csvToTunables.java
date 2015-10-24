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
import java.util.ArrayList;  
import java.util.List;  
import objects.tunables;  
/**
 *
 * @author elasly
 */
public class csvToTunables {
    
  
/** 
 * @author Nagesh Chauhan 
 *  
 */  
public class CsvToJavaObject {  
  
 public void convertCsvToJava() {  
  String csvFileToRead = "./tunables.csv";  
  BufferedReader br = null;  
  String line = "";  
  String splitBy = ",";  
  List<tunables> tunablesList = new ArrayList<tunables>();  
  
  try {  
  
   br = new BufferedReader(new FileReader(csvFileToRead));  
   while ((line = br.readLine()) != null) {  
  
    // split on comma(',')  
    String[] tunables = line.split(splitBy);  
  
    // create car object to store values  
    tunables tunableObject = new tunables();  
  
    // add values from csv to object  
    tunableObject.setProperty(tunables[0]);  
    tunableObject.setFolder(tunables[1]);  
    tunableObject.setFile(tunables[2]);  
    tunableObject.setRegExpresion(tunables[3]);  
  
    // adding  objects to a list  
    tunablesList.add(tunableObject);  
  
   }  
   // print values stored in tunablesList  
   printTunablesList(tunablesList);  
  
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
 }  
  
 public void printTunablesList(List<tunables> tunableListToPrint) {  
  for (int i = 0; i < tunableListToPrint.size(); i++) {  
   System.out.println("tunabnles [property= " + tunableListToPrint.get(i).getProperty()
     + " , Folder=" + tunableListToPrint.get(i).getFolder()
     + " , File=" + tunableListToPrint.get(i).getFile()
     + " , Regular Expresion="  
     + tunableListToPrint.get(i).getRegExpresion() );  
  }  
 }  
 public void getPropValues(List<tunables> tunableListToValue) {  
  for (int i = 0; i < tunableListToValue.size(); i++) {  
      
   System.out.println("tunabnles [property= " + tunableListToValue.get(i).getProperty()
     + " , Folder=" + tunableListToValue.get(i).getFolder()
     + " , File=" + tunableListToValue.get(i).getFile()
     + " , Regular Expresion="  
     + tunableListToValue.get(i).getRegExpresion() );  
  }  
 }  
}  
}
