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
import objects.caa;
import static utils.readHW.log;

/**
 *
 * @author amrmostafa
 */
public class readCaa {
    private Path fFilePath;

    public readCaa(String lparName) throws IOException{
        String aFileName="./Systems/"+lparName+"/caa/lscluster-m.txt";
            fFilePath = Paths.get(aFileName);
        
    }
    
public static caa CAA = new caa();
public int clusterSize;
   
    
  public final void processingLineByLine() throws IOException {

    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){

        while (scanner.hasNextLine()){
             String line = scanner.nextLine();
//       System.out.println(line);
             if (line.startsWith("====",0)) { 
    } else {
                 if (line.contains(":")){
//                 System.out.println("Check One Line is not empty - readCaa54 : "+line);
        processLine(line);}else{
//                 System.out.println(line);
                     if(line.startsWith("----",0)){
                     }
                     else{
                         if(line.isEmpty()){
                             
                         }else
                         if(line.startsWith("\t-----")){
                             
                         }else
                         if(line.contains("Calling")){
                             
                         }else{
                     String aLine=line;
                     String bLine=scanner.nextLine();
                     String cLine=scanner.nextLine();
                     String dLine=scanner.nextLine();
                     
                     processTable(aLine,bLine,cLine,dLine);
        }
                 }}
          }
      }      
    }
//        System.out.println();
  }

  /** 
   Overridable method for processing lines in different ways.
  */
  ;
    /** 
   Overridable method for processing lines in different ways.
     * @param aLine
     * @param bLine
     * @param cLine
     * @param dLine
  */
  protected void processTable(String aLine,String bLine,String cLine,String dLine){
  Scanner scannerA = new Scanner(aLine);
  scannerA.useDelimiter("  +");
  if (scannerA.hasNext()){
  String name1 = scannerA.next();
  String name2 = scannerA.next();
  String name3 = scannerA.next();
  }
  Scanner scannerB = new Scanner(bLine);
  if(bLine.contains("-------")){}else 
      if(bLine.contains("Interface")){}else
          if(bLine.contains("->")){}else{
  scannerB.useDelimiter("  +");
  if (scannerB.hasNext()){
  String value1 = scannerB.next();
  String value2 = scannerB.next();
  String value3 = scannerB.next();  
    CAA.setCLUSTER_NAME(value1);

  }
  }
  }
   
    /**
     *
     * @param aLine
     * @throws java.io.IOException
     */
    protected void processLine(String aLine) throws IOException{
             
    //use a second Scanner to parse the content of each line 
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter(":");
    if (scanner.hasNext()){

      //assumes the line has a certain structure
      
      String name = scanner.next();
      String value = scanner.next();
//      log(name.replaceAll("\\s+", " "));
      if ("Node query number of nodes examined".equals(name)){
      clusterSize=Integer.parseInt(value.replaceAll("\\s+", ""));
      }else {
      
      
      switch (name.replaceAll("\\s+", " ")){
          
          case " CLUSTER NAME ":
              CAA.setCLUSTER_NAME(value);
              scanner.hasNext();
//              System.out.println(value+" : "+CAA.CLUSTER_NAME);
              break;
          case " Cluster shorthand id for node":
              CAA.setCluster_shorthand_id_for_node(value);
              scanner.hasNext();
//              System.out.println(value+" : "+CAA.Cluster_shorthand_id_for_node);
              break;
          case " Mean Deviation in network rtt to node":
              CAA.setMean_Deviation_in_network_rtt_to_node(value);
              scanner.hasNext();
//              System.out.println(name+" : "+CAA.Mean_Deviation_in_network_rtt_to_node);
              break; 
          case " Node name":
                CAA.setNode_name(value);
              scanner.hasNext();
//              System.out.println(name+" : "+CAA.Node_name);
              break; 
          case " Number of clusters node is a member in":
                CAA.setNumber_of_clusters_node_is_a_member_in(value);
              scanner.hasNext();
//              System.out.println(name+" : "+CAA.Number_of_clusters_node_is_a_member_in);
              break;               
          case " Smoothed rtt to node":
              CAA.setSmoothed_rtt_to_node(value);
              scanner.hasNext();
//              System.out.println(name+" : "+CAA.Smoothed_rtt_to_node);
              break; 
          case " State of node":
                CAA.setState_of_node(value);
              scanner.hasNext();
//              System.out.println(CAA.getState_of_node()+" : ");
              break; 
          case " UUID for node":
              CAA.setUUID_for_node(value);
              scanner.hasNext();
//              System.out.println(CAA.UUID_for_node+" : "+value);
              break; 
         
          default:
              scanner.hasNext();
//              System.out.println(name+" : SSSS  "+value);
//              log("not a paramiter of the listplease add "+name.replaceAll("\\s+", " ")+"to the tunables.csv file along with the folder, file, and the reg expresion to use");
              break;
//          case "":
//              lpar.setHostname(value);
//              break;               
      }
      
      }}
//     System.out.println("Test 2 readCaa line130");
    
    else {
      log("Empty or invalid File. Unable to process.");
    }

//          
//          
//     System.out.println(String.valueOf(lpar.getLparName()));
  } 
 // PRIVATE 
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
       public static void printcaaList(List<caa> caaListToPrint) throws Exception{
   log("List Size is "+caaListToPrint.size());

//   log("Partition Name :" + lparsListToPrint.get(0).getLparName()
//     + ",   Node Name :" + lparsListToPrint.get(0).getHostname()+",  Entitled Capacity :"+lparsListToPrint.get(0).getDesiredCPU());  
  }    
       public static void main(String[] args) throws IOException, Exception {
        readCaa parser = new readCaa("dx1010");

       parser.processingLineByLine();
//           printcaaList();\
          System.out.println(String.valueOf(CAA.CLUSTER_NAME+" : "+CAA.Cluster_shorthand_id_for_node+" : "+CAA.Mean_Deviation_in_network_rtt_to_node+" : "+CAA.Node_name+" : "+CAA.Number_of_clusters_node_is_a_member_in+" : "+CAA.Smoothed_rtt_to_node+" : "+CAA.State_of_node+" : "+CAA.UUID_for_node));
//           log(CAA);

                      
       }
    
}
