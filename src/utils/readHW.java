/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import objects.LPARs;



/** Assumes UTF-8 encoding. JDK 7+. */
public class readHW {

  public static void main(String... aArgs) throws IOException {
    readHW parser = new readHW("dx978");
    parser.processLineByLine();
//    System.out.println(String.valueOf(lpar.getLparName()+" : "+lpar.getLparID()+" : "+lpar.getHostname()+" : "+lpar.getEntCapacity()));

    log("Done.");
  }
  
  /**
   Constructor.
   @param lparName full name of an existing, readable file.
  */
  public readHW(String lparName){
      String aFileName = "./Systems/"+lparName+"/hw/lparstat-i.txt";
    fFilePath = Paths.get(aFileName);
  }
  
  
  /** Template method that calls {@link #processLine(String)}.
     * @throws java.io.IOException */
  public final void processLineByLine() throws IOException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){

        while (scanner.hasNextLine()){
             String line = scanner.nextLine();
//       System.out.println(scanner.nextLine());
             if (line.startsWith(":",43)) { 
        processLine(line);

    } else {

          }
      }      
    }
//        printLparsList(lparsList);
//        System.out.println();
  }
  
//  List<LPARs> lparsList = new ArrayList<>(); 
  public static LPARs lpar = new LPARs();
  /** 
   Overridable method for processing lines in different ways.
     * @param aLine
  */
  protected void processLine(String aLine){
             
    //use a second Scanner to parse the content of each line 
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter(":");
//    lparsList.add(lpar);
//    log("size"+lparsList.size());
//    scanner.nextLine();
    if (scanner.hasNext()){

      //assumes the line has a certain structure
      
      String name = scanner.next();
      String value = scanner.next();
//      log(name.replaceAll("\\s+", " "));
      switch (name.replaceAll("\\s+", " ")){
          
          case "Partition Name ":
              lpar.setLparName(value);
//                   lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break;
          case "Entitled Capacity ":
              lpar.setEntCapacity(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break;
          case "Node Name ":
              lpar.setHostname(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break; 
          case "Maximum Virtual CPUs ":
              lpar.setMaxVirtCPU(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break; 
          case "Desired Memory ":
              lpar.setDesiredMem(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break;               
          case "Minimum Memory ":
              lpar.setMinMem(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break; 
          case "Desired Capacity ":
              lpar.setDesiredCPU(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break; 
          case "Minimum Capacity ":
              lpar.setMinCPU(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break; 
          case "Maximum Capacity ":
              lpar.setMaxCPU(value);   
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());     
              break; 
          case "Desired Variable Capacity Weight ":
              lpar.setWieght(value);   
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break; 
          case "Partition Number ":
              lpar.setLparID(value);
//              lparsList.set(0, lpar);
//              System.out.println(name.toString()+" : "+value.toString());
              break;
          case "Maximum Memory ":
              lpar.setMaxMem(value);
//              lparsList.set(0, lpar);
              break;
          case "Desired Virtual CPUs ":
              lpar.setDesVirtCPU(value);
//              lparsList.set(0, lpar);
              break;
          case "Memory Mode ":
              lpar.setMemMode(value);
//              lparsList.set(0, lpar);
              break;
          case "Type ":
              lpar.setCpuMode(value);
//              lparsList.set(0, lpar);
              break;
          case "Mode ":
              lpar.setCpuMode(value);
//              lparsList.set(0, lpar);
              break;
          case "Minimum Virtual CPUs ":
              lpar.setMinVirtCPU(value);
//              lparsList.set(0, lpar);
              break;
          default:
//              System.out.println(name.toString()+" : "+value.toString());
//              log("not a paramiter of the listplease add "+name.replaceAll("\\s+", " ")+"to the tunables.csv file along with the folder, file, and the reg expresion to use");
              break;
//          case "":
//              lpar.setHostname(value);
//              break;               
      }
    
    }
    else {
      log("Empty or invalid File. Unable to process.");
    }

//     ^     
//     System.out.println(String.valueOf(lpar.getLparName()));
  } 
 
  // PRIVATE 
  private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  public static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "\"";
    return QUOTE + aText + QUOTE;
  }
   public static void printLparsList(List<LPARs> lparsListToPrint) {  
   log("List Size is "+lparsListToPrint.size());
//   log("Partition Name :" + lparsListToPrint.get(0).getLparName()
//     + ",   Node Name :" + lparsListToPrint.get(0).getHostname()+",  Entitled Capacity :"+lparsListToPrint.get(0).getDesiredCPU());  
  }  
 
} 
