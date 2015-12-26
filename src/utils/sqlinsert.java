/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
//STEP 1. Import required packages
import java.sql.*;
import java.util.List;
/**
 *
 * @author user
 */
public class sqlinsert {



   // JDBC driver name and database URL
   

   
   @SuppressWarnings("empty-statement")
   public static void sqlinsert(String DatabaseName, List Values, int sheetNo) {
    Connection conn = null;
    Statement stmt = null;
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//  Database credentials
    String USER = "root";
    String PASS = "password";
    String DB_URL = "jdbc:mysql://localhost/"+DatabaseName;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();

         switch (sheetNo){
             case 0:
                  for (int i =0; Values.size()> i ;i++){
                  List list = (List) Values.get(i+1);
                  String SystemName = list.get(0).toString();
                  String InstalledCores = list.get(0).toString();
                  String ActivatedCores = list.get(0).toString();
                  String InstalledMem = list.get(0).toString();
                  String ActivatedMem = list.get(0).toString();
                  String GB4PortFCAdapter = list.get(0).toString();
                  String GB2PortFCAdapter = list.get(0).toString();
                  String SASAdapter = list.get(0).toString();
                  String GBFCOE1GB = list.get(0).toString();
                  String multiFunction = list.get(0).toString();
                  String SFFSSD387GB = list.get(0).toString();
                       String sql0 = "INSERT INTO `testdb`.`hwsummary` (`SystemName`, `InstalledCores`, `ActivatedCores`, `InstalledMem`, `ActivatedMem`, `8GB4PortFCAdapter`, `8GB2PortFCAdapter`, `SASAdapter`, `10GBFCOE1GB`, `multiFunction`, `SFFSSD387GB`) VALUES  ('"+SystemName+ "','" +InstalledCores+ "','" +ActivatedCores+ "','" +InstalledMem+ "','" +ActivatedMem+ "','" +GB4PortFCAdapter+ "','" +GB2PortFCAdapter+ "','" +SASAdapter+ "','" +GBFCOE1GB+ "','" +multiFunction+ "','" +SFFSSD387GB+"'); ";
      stmt.executeUpdate(sql0);
                  }
                 break;
             case 1:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql1 = "INSERT INTO `testdb`.`lparplacement` (`id`, `Frame`, `type`, `partition`, `Mem`, `Cores`, `MaxCores`, `HBAport`, `10GBEth`, `1GBeth`, `internalStorage`) VALUES (<{id: }>, <{Frame: }>, <{type: }>, <{partition: }>, <{Mem: }>, <{Cores: }>, <{MaxCores: }>, <{HBAport: }>, <{10GBEth: }>, <{1GBeth: }>, <{internalStorage: }>);";
      stmt.executeUpdate(sql1);
                 break;
             case 2:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql2 = "INSERT INTO `testdb`.`lparconfig` (`id`, `frame`, `function`, `node`, `Cores`, `RAM`, `HostName`, `SerialNo`, `OS`, `OSLEVEL`, `ProcType`, `ProcSpeed`, `SMT`, `mode`, `pool`,  `wieght`, `availiability`, `EtherPorts`, `VLANS`, `IPAdd`, `subnet`, `GateWay`, `FCports`, `maxvadapters`, `storageTyoe`, `tapeDrives`, `InternalDisk`, `SANDisk`) VALUES (<{id: }>,  <{frame: }>, <{function: }>, <{node: }>, <{Cores: }>, <{RAM: }>, <{HostName: }>, <{SerialNo: }>, <{OS: }>, <{OSLEVEL: }>, <{ProcType: }>, <{ProcSpeed: }>, <{SMT: }>, <{mode: }>, <{pool: }>, <{wieght: }>, <{availiability: }>, <{EtherPorts: }>, <{VLANS: }>, <{IPAdd: }>, <{subnet: }>, <{GateWay: }>, <{FCports: }>, <{maxvadapters: }>, <{storageTyoe: }>, <{tapeDrives: }>, <{InternalDisk: }>,  <{SANDisk: }>);";
      stmt.executeUpdate(sql2);
                 break;
             case 3:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql3 = "INSERT INTO `testdb`.`cpumemvirt`(`id`,`frame`,`app`,`hostname`,`partionID`,`Cores`,`mem`,`cputype`,`mode`,`pool`,`weight`,`phycpumin`,`phycpudes`,`phycpumax`,`vircpumin`,`vircpudes`,`vircpumax`,`memmin`,`memdes`,`memmax`,`poolid`,`poolname`,`poolmaxcpu`)VALUES(<{id: }>,<{frame: }>,<{app: }>,<{hostname: }>,<{partionID: }>,<{Cores: }>,<{mem: }>,<{cputype: }>,<{mode: }>,<{pool: }>,<{weight: }>,<{phycpumin: }>,<{phycpudes: }>,<{phycpumax: }>,<{vircpumin: }>,<{vircpudes: }>,<{vircpumax: }>,<{memmin: }>,<{memdes: }>,<{memmax: }>,<{poolid: }>,<{poolname: }>,<{poolmaxcpu: }>);";
      stmt.executeUpdate(sql3);
                 break;
             case 4:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql4 = "INSERT INTO `testdb`.`vscsimap`(`id`,`frame`,`lpar`,`vio1vhostslotidrv`,`vio1rootvgvhostnamerv`,`vio1clientadapnamerv`,`vio1vscsiclientslotidrv`,`vio1vhostslotiddv1`,`vio1rootvgvhostnamedv1`,`vio1clientadapnamedv1`,`vio1vscsiclientslotiddv1`,`vio1vhostslotiddv2`,`vio1rootvgvhostnamedv2`,`vio1clientadapnamedv2`,`vio1vscsiclientslotiddv2`,`vio1vhostslotiddv3`,`vio1rootvgvhostnamedv3`,`vio1clientadapnamedv3`,`vio1vscsiclientslotiddv3`,`vio1vhostslotiddv4`,`vio1rootvgvhostnamedv4`,`vio1clientadapnamedv4`,`vio1vscsiclientslotiddv4`,`vio2vhostslotidrv`,`vio2rootvgvhostnamerv`,`vio2clientadapnamerv`,`vio2vscsiclientslotidrv`,`vio2vhostslotiddv1`,`vio2rootvgvhostnamedv1`,`vio2clientadapnamedv1`,`vio2vscsiclientslotiddv1`,`vio2vhostslotiddv2`,`vio2rootvgvhostnamedv2`,`vio2clientadapnamedv2`,`vio2vscsiclientslotiddv2`,`vio2vhostslotiddv3`,`vio2rootvgvhostnamedv3`,`vio2clientadapnamedv3`,`vio2vscsiclientslotiddv3`,`vio2vhostslotiddv4`,`vio2rootvgvhostnamedv4`,`vio2clientadapnamedv4`,`vio2vscsiclientslotiddv4`)VALUES (<{id: }>,<{frame: }>,<{lpar: }>,<{vio1vhostslotidrv: }>,<{vio1rootvgvhostnamerv: }>,<{vio1clientadapnamerv: }>,<{vio1vscsiclientslotidrv: }>,<{vio1vhostslotiddv1: }>,<{vio1rootvgvhostnamedv1: }>,<{vio1clientadapnamedv1: }>,<{vio1vscsiclientslotiddv1: }>,<{vio1vhostslotiddv2: }>,<{vio1rootvgvhostnamedv2: }>,<{vio1clientadapnamedv2: }>,<{vio1vscsiclientslotiddv2: }>,<{vio1vhostslotiddv3: }>,<{vio1rootvgvhostnamedv3: }>,<{vio1clientadapnamedv3: }>,<{vio1vscsiclientslotiddv3: }>,<{vio1vhostslotiddv4: }>,<{vio1rootvgvhostnamedv4: }>,<{vio1clientadapnamedv4: }>,<{vio1vscsiclientslotiddv4: }>,<{vio2vhostslotidrv: }>,<{vio2rootvgvhostnamerv: }>,<{vio2clientadapnamerv: }>,{vio2vscsiclientslotidrv: }>,<{vio2vhostslotiddv1: }>,<{vio2rootvgvhostnamedv1: }>,<{vio2clientadapnamedv1: }>,<{vio2vscsiclientslotiddv1: }>,<{vio2vhostslotiddv2: }>,<{vio2rootvgvhostnamedv2: }>,<{vio2clientadapnamedv2: }>,<{vio2vscsiclientslotiddv2: }>,<{vio2vhostslotiddv3: }>,<{vio2rootvgvhostnamedv3: }>,<{vio2clientadapnamedv3: }>,<{vio2vscsiclientslotiddv3: }>,<{vio2vhostslotiddv4: }>,<{vio2rootvgvhostnamedv4: }>,<{vio2clientadapnamedv4: }>,<{vio2vscsiclientslotiddv4: }>);";
      stmt.executeUpdate(sql4);
                 break;
             case 5:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql5 = "INSERT INTO `testdb`.`vfibermap`(`id`,`frame`,`lpar`,`vio1vfchostslotidrv`,`vio1rootvgvfchostnamerv`,`vio1clientadapnamerv`,`vio1vfiberclientslotidrv`,`vio1vfchostslotiddv1`,`vio1rootvgvfchostnamedv1`,`vio1clientadapnamedv1`,`vio1vfiberclientslotiddv1`,`vio1vfchostslotiddv2`,`vio1rootvgvfchostnamedv2`,`vio1clientadapnamedv2`,`vio1vfiberclientslotiddv2`,`vio1vfchostslotiddv3`,`vio1rootvgvfchostnamedv3`,`vio1clientadapnamedv3`,`vio1vfiberclientslotiddv3`,`vio1vfchostslotiddv4`,`vio1rootvgvfchostnamedv4`,`vio1clientadapnamedv4`,`vio1vfiberclientslotiddv4`,`vio2vfchostslotidrv`,`vio2rootvgvfchostnamerv`,`vio2clientadapnamerv`,`vio2vfiberclientslotidrv`,`vio2vfchostslotiddv1`,`vio2rootvgvfchostnamedv1`,`vio2clientadapnamedv1`,`vio2vfiberclientslotiddv1`,`vio2vfchostslotiddv2`,`vio2rootvgvfchostnamedv2`,`vio2clientadapnamedv2`,`vio2vfiberclientslotiddv2`,`vio2vfchostslotiddv3`,`vio2rootvgvfchostnamedv3`,`vio2clientadapnamedv3`,`vio2vfiberclientslotiddv3`,`vio2vfchostslotiddv4`,`vio2rootvgvfchostnamedv4`,`vio2clientadapnamedv4`,`vio2vfiberclientslotiddv4`)VALUES (<{id: }>,<{frame: }>,<{lpar: }>,<{vio1vfchostslotidrv: }>,<{vio1rootvgvfchostnamerv: }>,<{vio1clientadapnamerv: }>,<{vio1vfiberclientslotidrv: }>,<{vio1vfchostslotiddv1: }>,<{vio1rootvgvfchostnamedv1: }>,<{vio1clientadapnamedv1: }>,<{vio1vfiberclientslotiddv1: }>,<{vio1vfchostslotiddv2: }>,<{vio1rootvgvfchostnamedv2: }>,<{vio1clientadapnamedv2: }>,<{vio1vfiberclientslotiddv2: }>,<{vio1vfchostslotiddv3: }>,<{vio1rootvgvfchostnamedv3: }>,<{vio1clientadapnamedv3: }>,<{vio1vfiberclientslotiddv3: }>,<{vio1vfchostslotiddv4: }>,<{vio1rootvgvfchostnamedv4: }>,<{vio1clientadapnamedv4: }>,<{vio1vfiberclientslotiddv4: }>,<{vio2vfchostslotidrv: }>,<{vio2rootvgvfchostnamerv: }>,<{vio2clientadapnamerv: }>,<{vio2vfiberclientslotidrv: }>,<{vio2vfchostslotiddv1: }>,<{vio2rootvgvfchostnamedv1: }>,<{vio2clientadapnamedv1: }>,<{vio2vfiberclientslotiddv1: }>,<{vio2vfchostslotiddv2: }>,<{vio2rootvgvfchostnamedv2: }>,<{vio2clientadapnamedv2: }>,<{vio2vfiberclientslotiddv2: }>,<{vio2vfchostslotiddv3: }>,<{vio2rootvgvfchostnamedv3: }>,<{vio2clientadapnamedv3: }>,<{vio2vfiberclientslotiddv3: }>,<{vio2vfchostslotiddv4: }>,<{vio2rootvgvfchostnamedv4: }>,<{vio2clientadapnamedv4: }>,<{vio2vfiberclientslotiddv4: }>);";
                       stmt.executeUpdate(sql5);
                 break;
             case 6:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql6 = "INSERT INTO `testdb`.`phyethports` (`id`,`frame`,`function`,`app`,`hostname`,`theportvfg`,`ethportsassigned`,`ethportscanbecfg`,`vlancount`,`ipcount`,`vlanid`,`backupip`,`bckupipvlanid`,`interconectip`,`inteconipvlanid`,`mgmtip`,`mgmtvlanid`)VALUES (<{id: }>,<{frame: }>,<{function: }>,<{app: }>,<{hostname: }>,<{theportvfg: }>,<{ethportsassigned: }>,<{ethportscanbecfg: }>,<{vlancount: }>,<{ipcount: }>,<{vlanid: }>,<{backupip: }>,<{bckupipvlanid: }>,<{interconectip: }>,<{inteconipvlanid: }>,<{mgmtip: }>,<{mgmtvlanid: }>);";
                       stmt.executeUpdate(sql6);                 
                 break;
             case 7:
                 for (int i =0; Values.size()> i ;i++){
                 List list = (List) Values.get(i+1);}
                       String sql7 = "INSERT INTO `testdb`.`seacfg` (`id`,`frame`,`vios`,`sea`,`locationcode`,`contoswitch`,`portspeed`,`lyncagg`,`hashmode`,`mode`,`interval`,`vlantagids`,`pvideth1`,`veth1slotid`,`veth1ieee`,`veth1vlans`,`tunkveth1prio`,`veth1adapname`,`seacfgcol`,`pvideth2`,`veth2slotid`,`veth2ieee`,`veth2vlans`,`tunkveth2prio`,`veth2adapname`,`pvideth2_copy1`,`veth3slotid`,`veth3ieee`,`veth3vlans`,`tunkveth3prio`,`veth3adapname`,`pvideth4`,`veth4slotid`,`veth4ieee`,`veth4vlans`,`tunkveth4prio`,`veth4adapname`,`threading`,`ctlchanslotid`,`ctlchanvlanid`,`ctlchanadap`,`hamode`,`jumboframes`,`largesend`,`largerecive`,`flowcontrol`,`accounting`)VALUES (<{id: }>,<{frame: }>,<{vios: }>,<{sea: }>,<{locationcode: }>,<{contoswitch: }>,<{portspeed: }>,<{lyncagg: }>,<{hashmode: }>,<{mode: }>,<{interval: }>,<{vlantagids: }>,<{pvideth1: }>,<{veth1slotid: }>,<{veth1ieee: }>,<{veth1vlans: }>,<{tunkveth1prio: }>,<{veth1adapname: }>,<{seacfgcol: }>,<{pvideth2: }>,<{veth2slotid: }>,<{veth2ieee: }>,<{veth2vlans: }>,<{tunkveth2prio: }>,<{veth2adapname: }>,<{pvideth2_copy1: }>,<{veth3slotid: }>,<{veth3ieee: }>,<{veth3vlans: }>,<{tunkveth3prio: }>,<{veth3adapname: }>,<{pvideth4: }>,<{veth4slotid: }>,<{veth4ieee: }>,<{veth4vlans: }>,<{tunkveth4prio: }>,<{veth4adapname: }>,<{threading: }>,<{ctlchanslotid: }>,<{ctlchanvlanid: }>,<{ctlchanadap: }>,<{hamode: }>,<{jumboframes: }>,<{largesend: }>,<{largerecive: }>,<{flowcontrol: }>,<{accounting: }>);";
                       stmt.executeUpdate(sql7);                 
                 break;
             case 8:
                       for (int i =0; Values.size()> i ;i++){
                  List list = (List) Values.get(i);
            String taget = list.get(0).toString();
            String tunable = list.get(1).toString();
            String appliedonvio = list.get(2).toString();
            String appliedonaix7 = list.get(3).toString();
            String appliedonaix6 = list.get(4).toString();           
             String sql8 = "INSERT INTO `testdb`.`tunables`(`taget`,`tunable`,`appliedonvio`,`appliedonaix7`,`appliedonaix6`)VALUES('" +taget+ "','" + tunable+ "','" +appliedonvio+ "','" +appliedonaix7+ "','" +appliedonaix6+ "');";
            stmt.executeUpdate(sql8);         
                       }
                 break;
             default:
                 break;
                     
                        
      
      }
   

      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample    

