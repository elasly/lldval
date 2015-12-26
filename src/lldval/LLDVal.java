/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lldval;

/*import static java.util.Arrays.toString;
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import objects.pcatFolders;
import objects.pcatLparFolders;
import objects.vfcMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.*;
import static utils.ReadWriteExcelFile.writeXLSXFile;
import static utils.readCaa.CAA;
import static utils.readHW.lpar;
import static utils.readVFCMap.vfcs;




/**
 *
 * @author elasly
 */
public class LLDVal {

    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
  // reading data from a csv file  
  System.out.println("Reading data from csv :");  
  ReadCsv readCsv = new ReadCsv();  
  readCsv.readCsv("./tunables.csv");  
  writeXLSXFile("./PCAT_AnalysisFile.xlsx", "Info");
  Workbook wb = new XSSFWorkbook(new FileInputStream("./PCAT_AnalysisFile.xlsx"));
  XSSFSheet clusterSheet = (XSSFSheet) wb.createSheet("caaConfigurations");
  XSSFSheet hwSheet = (XSSFSheet) wb.createSheet("HWConfigurations");
  XSSFSheet vfcSheet = (XSSFSheet) wb.createSheet("VFC Mappings");
  // reading data from a csv file and convert to java object  
  System.out.println("Reading data from csv and convert to java object:");  
//  csvToTunables csvToJavaObject = new csvToTunables();  
//  csvToJavaObject.convertCsvToJava();  
    pcatFolders pcatFolder=new pcatFolders("./systems");
    
//    System.out.println(Arrays.toString(pcatFolder.pcatFolderList));
      String[] lparName = pcatFolder.pcatFolderList;
      System.out.println(Arrays.toString(lparName));
//      caa CAA = new caa();
//      readCaa readCaas = new readCaa("dx980");
      for (int j=0; j < lparName.length -1 ; j++){
    pcatLparFolders lparFolders = new pcatLparFolders("./systems",lparName[j]);
    System.out.print("LparName : "+String.valueOf(lparName[j]) + "  : ");
    System.out.println(Arrays.toString(lparFolders.fileList));
    for (int t = 0; t < lparFolders.fileList.length ; t++){
    System.out.println(lparFolders.fileList[t]);
    switch (lparFolders.fileList[t]){
        case "caa":
            readCaa caa = new readCaa(lparName[j]);
            caa.processingLineByLine();
            System.out.println("Cluster Configuration Populating");
//            System.out.println(caa.toString());
//            System.out.println(String.valueOf(CAA.CLUSTER_NAME+" : "+CAA.Cluster_shorthand_id_for_node+" : "+CAA.Mean_Deviation_in_network_rtt_to_node+" : "+CAA.Node_name+" : "+CAA.Number_of_clusters_node_is_a_member_in+" : "+CAA.Smoothed_rtt_to_node+" : "+CAA.State_of_node+" : "+CAA.UUID_for_node));
            int sheetLength = clusterSheet.getPhysicalNumberOfRows();
            if(sheetLength == 0){
                Row row = clusterSheet.createRow((short)sheetLength);
                Cell cell = row.createCell(0);
                cell.setCellValue("CLUSTER_NAME");
                Cell cell1 = row.createCell(1);
                cell1.setCellValue("Node_name");
                Cell cell2 = row.createCell(2);
                cell2.setCellValue("Number_of_clusters_node_is_a_member_in");
                Cell cell3 = row.createCell(3);
                cell3.setCellValue("State_of_node");
                Cell cell4 = row.createCell(4);
                cell4.setCellValue("UUID_for_node");
                Cell cell5 = row.createCell(5);
                cell5.setCellValue("Cluster_shorthand_id_for_node");
                Cell cell6 = row.createCell(6);
                cell6.setCellValue("Smoothed_rtt_to_node");
                Cell cell7 = row.createCell(7);
                cell7.setCellValue("Mean_Deviation_in_network_rtt_to_node");}else
              if (CAA.CLUSTER_NAME != null && !CAA.CLUSTER_NAME.isEmpty()){
                Row row = clusterSheet.createRow((short)sheetLength+1);
                Cell cell = row.createCell(0);
                cell.setCellValue(CAA.CLUSTER_NAME);
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(CAA.Node_name);
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(CAA.Number_of_clusters_node_is_a_member_in);
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(CAA.State_of_node);
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(CAA.UUID_for_node);
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(CAA.Cluster_shorthand_id_for_node);
                Cell cell6 = row.createCell(6);
                cell6.setCellValue(CAA.Smoothed_rtt_to_node);
                Cell cell7 = row.createCell(7);
                cell7.setCellValue(CAA.Mean_Deviation_in_network_rtt_to_node);
              }
                    try {
        FileOutputStream out = new FileOutputStream("./PCAT_AnalysisFile.xlsx");
        wb.write(out);
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
            break;
//        case "emc":
//            System.out.println("EMC Storage Configuration Populating");
//            break;
//        case "hmc":
//            System.out.println("HMC Configuration Populating");
//            break;
        case "hw":
            System.out.println("Hardware  Configuration Populating");
            readHW hw = new readHW(lparName[j]);
            hw.processLineByLine();
            System.out.println(lpar.lparID +" : "+lpar.lparName+" : "+lpar.hostname+" : "+lpar.entCapacity+" : "+lpar.maxCPU+" : "+lpar.desiredCPU+" : "+lpar.minCPU+" : "+lpar.MaxVirtCPU+" : "+lpar.DesVirtCPU+" : "+lpar.minVirtCPU);
            int hwsheetLength = hwSheet.getPhysicalNumberOfRows();
            if(hwsheetLength == 0){
                Row row = hwSheet.createRow((short)hwsheetLength);
                Cell cell = row.createCell(0);
                cell.setCellValue("LparID");
                Cell cell1 = row.createCell(1);
                cell1.setCellValue("lparName");
                Cell cell2 = row.createCell(2);
                cell2.setCellValue("hostname");
                Cell cell3 = row.createCell(3);
                cell3.setCellValue("maxMem");
                Cell cell4 = row.createCell(4);
                cell4.setCellValue("desiredMem");
                Cell cell5 = row.createCell(5);
                cell5.setCellValue("maxMem");
                Cell cell6 = row.createCell(6);
                cell6.setCellValue("MemMode");
                Cell cell7 = row.createCell(7);
                cell7.setCellValue("maxCPU");
                Cell cell8 = row.createCell(8);
                cell8.setCellValue("desiredCPU");
                Cell cell9 = row.createCell(9);
                cell9.setCellValue("minCPU");
                Cell cell10 = row.createCell(10);
                cell10.setCellValue("MaxVirtCPU");
                Cell cell11 = row.createCell(11);
                cell11.setCellValue("DesVirtCPU");
                Cell cell12 = row.createCell(12);
                cell12.setCellValue("minVirtCPU");
                Cell cell13 = row.createCell(13);
                cell13.setCellValue("entCapacity");
                Cell cell14 = row.createCell(14);
                cell14.setCellValue("weight");
                Cell cell15 = row.createCell(15);
                cell15.setCellValue("SMTType");
                Cell cell16 = row.createCell(16);
                cell16.setCellValue("cpuMode");}else
              if (lpar.lparID != null && !lpar.lparID.isEmpty()){
                Row row = hwSheet.createRow((short)hwsheetLength+1);
                Cell cell = row.createCell(0);
                cell.setCellValue(lpar.lparID);
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(lpar.lparName);
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(lpar.hostname);
                Cell cell3 = row.createCell(3);
                cell3.setCellValue(lpar.maxMem);
                Cell cell4 = row.createCell(4);
                cell4.setCellValue(lpar.desiredMem);
                Cell cell5 = row.createCell(5);
                cell5.setCellValue(lpar.maxMem);
                Cell cell6 = row.createCell(6);
                cell6.setCellValue(lpar.MemMode);
                Cell cell7 = row.createCell(7);
                cell7.setCellValue(lpar.maxCPU);
                Cell cell8 = row.createCell(8);
                cell8.setCellValue(lpar.desiredCPU);
                Cell cell9 = row.createCell(9);
                cell9.setCellValue(lpar.minCPU);
                Cell cell10 = row.createCell(10);
                cell10.setCellValue(lpar.MaxVirtCPU);
                Cell cell11 = row.createCell(11);
                cell11.setCellValue(lpar.DesVirtCPU);
                Cell cell12 = row.createCell(12);
                cell12.setCellValue(lpar.minVirtCPU);
                Cell cell13 = row.createCell(13);
                cell13.setCellValue(lpar.entCapacity);
                Cell cell14 = row.createCell(14);
                cell14.setCellValue(lpar.weight);
                Cell cell15 = row.createCell(15);
                cell15.setCellValue(lpar.SMTType);
                Cell cell16 = row.createCell(16);
                cell16.setCellValue(lpar.cpuMode);}
                 try {
        FileOutputStream out = new FileOutputStream("./PCAT_AnalysisFile.xlsx");
        wb.write(out);
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
            break;
//        case "network":
//            System.out.println("Network Configuration Populating");
//            break;
//        case "os":
//            System.out.println("Operating System Configuration Populating");
//            break;
//        case "perf":
//            System.out.println("Performance Configuration Populating");
//            break;
//        case "secure":
//            System.out.println("Security Configuration Populating");
//            break;
//        case "storage":
//            System.out.println("Storage Configuration Populating");
//            break;
//        case "tsm":
//            System.out.println("TSM Configuration Populating");
//            break;
        case "vio":
            vfcs.clear();
            System.out.println("VIO Configuration Populating");
            readVFCMap vfcmapd = new readVFCMap(lparName[j]);
            vfcmapd.processPatern();
            vfcMap vfcmap = new vfcMap();
            System.out.println(vfcs.size());
            for (int vfcRows=0; vfcRows <= vfcs.size() - 1; vfcRows++){
            System.out.println(vfcs.get(vfcRows).vfcName+" | "+vfcs.get(vfcRows).physLoc+" | "+vfcs.get(vfcRows).clntId+" | "+vfcs.get(vfcRows).clntName+" | "+vfcs.get(vfcRows).status+" | "+vfcs.get(vfcRows).fc_name+" | "+vfcs.get(vfcRows).fc_loc_code+" | "+vfcs.get(vfcRows).flags+" | "+vfcs.get(vfcRows).VFC_client_name+" | "+vfcs.get(vfcRows).VFC_client_DRC);
            int vfcsheetLength = vfcSheet.getPhysicalNumberOfRows();
            if(vfcsheetLength == 0){
                Row row = vfcSheet.createRow((short)vfcsheetLength);
               int count=0;
                Cell cell = row.createCell(0);
                cell.setCellValue("Lpar Name");
                for (Field field : vfcmap.getClass().getDeclaredFields()) {
                    count++;
//                System.out.println(field.getName());
                Cell nextcell = row.createCell(count);
                 nextcell.setCellValue(field.getName());
                 
                }
//                Row row1 = vfcSheet.createRow(1);
//                System.out.println("value row"+row1);
//                Cell valuecell = row1.createCell(0);
//                valuecell.setCellValue(lparName[j]);
//                Cell vfcNamecell = row1.createCell(vfcRows);
//                vfcNamecell.setCellValue(vfcs.get(vfcRows).vfcName);
//                Cell physLoccell = row1.createCell(vfcRows);
//                physLoccell.setCellValue(vfcs.get(vfcRows).physLoc);
//                Cell clntIdcell = row1.createCell(vfcRows);
//                clntIdcell.setCellValue(vfcs.get(vfcRows).clntId);
//                Cell clntNamecell = row1.createCell(vfcRows);
//                clntNamecell.setCellValue(vfcs.get(vfcRows).clntName);
//                Cell statuscell = row1.createCell(vfcRows);
//                statuscell.setCellValue(vfcs.get(vfcRows).status);
//                Cell fc_namecell = row1.createCell(vfcRows);
//                fc_namecell.setCellValue(vfcs.get(vfcRows).fc_name);
//                Cell fc_loc_codecell = row1.createCell(vfcRows);
//                fc_loc_codecell.setCellValue(vfcs.get(vfcRows).fc_loc_code);
//                Cell flagscell = row1.createCell(vfcRows);
//                flagscell.setCellValue(vfcs.get(vfcRows).flags);
//                Cell VFC_client_namecell = row1.createCell(vfcRows);
//                VFC_client_namecell.setCellValue(vfcs.get(vfcRows).VFC_client_name);
//                Cell VFC_client_DRCcell = row1.createCell(vfcRows);
//                VFC_client_DRCcell.setCellValue(vfcs.get(vfcRows).VFC_client_DRC);
//vfcs.get(vfcRows).vfcName+" | "+vfcs.get(vfcRows).physLoc+" | "+vfcs.get(vfcRows).clntId+" | "+vfcs.get(vfcRows).clntName+" | "+vfcs.get(vfcRows).status+" | "+vfcs.get(vfcRows).fc_name+" | "+vfcs.get(vfcRows).fc_loc_code+" | "+vfcs.get(vfcRows).flags+" | "+vfcs.get(vfcRows).VFC_client_name+" | "+vfcs.get(vfcRows).VFC_client_DRC
            }else
              if (vfcs.get(vfcRows).vfcName != null && !vfcs.get(vfcRows).vfcName.isEmpty()){
                Row valuerow = vfcSheet.createRow((short)vfcsheetLength);
                System.out.println("value row"+valuerow);
                Cell valuecell = valuerow.createCell(0);
                valuecell.setCellValue(lparName[j]);
                Cell vfcNamecell = valuerow.createCell(vfcRows);
                vfcNamecell.setCellValue(vfcs.get(vfcRows).vfcName);
                Cell physLoccell = valuerow.createCell(vfcRows);
                physLoccell.setCellValue(vfcs.get(vfcRows).physLoc);
                Cell clntIdcell = valuerow.createCell(vfcRows);
                clntIdcell.setCellValue(vfcs.get(vfcRows).clntId);
                Cell clntNamecell = valuerow.createCell(vfcRows);
                clntNamecell.setCellValue(vfcs.get(vfcRows).clntName);
                Cell statuscell = valuerow.createCell(vfcRows);
                statuscell.setCellValue(vfcs.get(vfcRows).status);
                Cell fc_namecell = valuerow.createCell(vfcRows);
                fc_namecell.setCellValue(vfcs.get(vfcRows).fc_name);
                Cell fc_loc_codecell = valuerow.createCell(vfcRows);
                fc_loc_codecell.setCellValue(vfcs.get(vfcRows).fc_loc_code);
                Cell flagscell = valuerow.createCell(vfcRows);
                flagscell.setCellValue(vfcs.get(vfcRows).flags);
                Cell VFC_client_namecell = valuerow.createCell(vfcRows);
                VFC_client_namecell.setCellValue(vfcs.get(vfcRows).VFC_client_name);
                Cell VFC_client_DRCcell = valuerow.createCell(vfcRows);
                VFC_client_DRCcell.setCellValue(vfcs.get(vfcRows).VFC_client_DRC);
 
//                    valueCount++;
//                Cell value1cell = valuerow.createCell(valueCount);
//                value1cell.setCellValue(map.clntName);// i am stuck here to iterate around the values of each instance of the object.
           }}
            FileOutputStream out = new FileOutputStream("./PCAT_AnalysisFile.xlsx");
            wb.write(out);
            out.close();
            break;
        default:
//            System.out.println("Nothing to do");
            break;
                    
    }
    };
    };

  
  
//  getPropValue testRun = new getPropValue("./Systems/dx1010/hw/lparstat-vfcRows.txt");

 
  }  
    
}  
 
                                            
    

