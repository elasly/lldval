/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author user
 */
public class CreateDB {

   // JDBC driver name and database URL
   

   @SuppressWarnings("empty-statement")
   public static void createdb(String DatabaseName) {
    Connection conn = null;
    Statement stmt = null;
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//  Database credentials
    String USER = "root";
    String PASS = "password";
    String DB_URL = "jdbc:mysql://localhost/sys";
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
String sql0="CREATE DATABASE `"+DatabaseName+"` /*!40100 DEFAULT CHARACTER SET utf8 */; CREATE TABLE `"+DatabaseName+"`.`cpumemvirt` (   `id` int(11) NOT NULL AUTO_INCREMENT,`frame` varchar(256) DEFAULT NULL,   `app` varchar(45) DEFAULT NULL,   `hostname` varchar(45) DEFAULT NULL,   `partionID` int(11) DEFAULT NULL,   `Cores` int(11) DEFAULT NULL,   `mem` int(11) DEFAULT NULL,   `cputype` varchar(45) DEFAULT NULL,   `mode` varchar(45) DEFAULT NULL,   `pool` varchar(45) DEFAULT NULL,   `weight` int(11) DEFAULT NULL,   `phycpumin` int(11) DEFAULT NULL,   `phycpudes` int(11) DEFAULT NULL,   `phycpumax` int(11) DEFAULT NULL,   `vircpumin` int(11) DEFAULT NULL,   `vircpudes` int(11) DEFAULT NULL,   `vircpumax` int(11) DEFAULT NULL,   `memmin` int(11) DEFAULT NULL,   `memdes` int(11) DEFAULT NULL,   `memmax` int(11) DEFAULT NULL,   `poolid` int(11) DEFAULT NULL,   `poolname` varchar(45) DEFAULT NULL,   `poolmaxcpu` int(11) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8; CREATE TABLE `"+DatabaseName+"`. `hwsummary` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `SystemName` varchar(256) DEFAULT NULL,   `InstalledCores` int(11) DEFAULT NULL,   `ActivatedCores` int(11) DEFAULT NULL,   `InstalledMem` int(11) DEFAULT NULL,   `ActivatedMem` int(11) DEFAULT NULL,   `8GB4PortFCAdapter` int(11) DEFAULT NULL,   `8GB2PortFCAdapter` int(11) DEFAULT NULL,   `SASAdapter` int(11) DEFAULT NULL,   `10GBFCOE1GB` int(11) DEFAULT NULL,   `multiFunction` int(11) DEFAULT NULL,   `SFFSSD387GB` int(11) DEFAULT NULL,   PRIMARY KEY (`id`),   UNIQUE KEY `idCPU-Mem_Virtualization_UNIQUE` (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8; CREATE TABLE `"+DatabaseName+"`. `lparconfig` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `frame` varchar(256) DEFAULT NULL,   `function` varchar(45) DEFAULT NULL,   `node` varchar(45) DEFAULT NULL,   `Cores` int(11) DEFAULT NULL,   `RAM` int(11) DEFAULT NULL,   `HostName` varchar(45) DEFAULT NULL,   `SerialNo` varchar(256) DEFAULT NULL,   `OS` varchar(45) DEFAULT NULL,   `OSLEVEL` varchar(45) DEFAULT NULL,   `ProcType` varchar(45) DEFAULT NULL,   `ProcSpeed` varchar(45) DEFAULT NULL,   `SMT` varchar(45) DEFAULT NULL,   `mode` varchar(45) DEFAULT NULL,   `pool` varchar(45) DEFAULT NULL,   `wieght` int(11) DEFAULT NULL,   `availiability` int(11) DEFAULT NULL,   `EtherPorts` varchar(45) DEFAULT NULL,   `VLANS` varchar(256) DEFAULT NULL,   `IPAdd` varchar(45) DEFAULT NULL,   `subnet` varchar(45) DEFAULT NULL,   `GateWay` varchar(45) DEFAULT NULL,   `FCports` varchar(45) DEFAULT NULL,   `maxvadapters` int(11) DEFAULT NULL,   `storageTyoe` varchar(45) DEFAULT NULL,   `tapeDrives` varchar(45) DEFAULT NULL,   `InternalDisk` varchar(45) DEFAULT NULL,   `SANDisk` int(11) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8; CREATE TABLE `"+DatabaseName+"`. `lparplacement` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `Frame` varchar(256) DEFAULT NULL,   `type` varchar(356) DEFAULT NULL,   `partition` varchar(45) DEFAULT NULL,   `Mem` int(11) DEFAULT NULL,   `Cores` int(11) DEFAULT NULL,   `MaxCores` int(11) DEFAULT NULL,   `HBAport` varchar(45) DEFAULT NULL,   `10GBEth` varchar(45) DEFAULT NULL,   `1GBeth` varchar(45) DEFAULT NULL,   `internalStorage` varchar(45) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		'; CREATE TABLE `"+DatabaseName+"`. `phyethports` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `frame` varchar(256) DEFAULT NULL,   `function` varchar(45) DEFAULT NULL,   `app` varchar(45) DEFAULT NULL,   `hostname` varchar(45) DEFAULT NULL,   `theportvfg` varchar(256) DEFAULT NULL,   `ethportsassigned` int(11) DEFAULT NULL,   `ethportscanbecfg` int(11) DEFAULT NULL,   `vlancount` int(11) DEFAULT NULL,   `ipcount` int(11) DEFAULT NULL,   `vlanid` int(11) DEFAULT NULL,   `backupip` int(11) DEFAULT NULL,   `bckupipvlanid` int(11) DEFAULT NULL,   `interconectip` int(11) DEFAULT NULL,   `inteconipvlanid` int(11) DEFAULT NULL,   `mgmtip` int(11) DEFAULT NULL,   `mgmtvlanid` int(11) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8; CREATE TABLE `"+DatabaseName+"`. `seacfg` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `frame` varchar(256) DEFAULT NULL,   `vios` varchar(45) DEFAULT NULL,   `sea` varchar(256) DEFAULT NULL,   `locationcode` varchar(256) DEFAULT NULL,   `contoswitch` varchar(45) DEFAULT NULL,   `portspeed` varchar(45) DEFAULT NULL,   `lyncagg` varchar(45) DEFAULT NULL,   `hashmode` varchar(45) DEFAULT NULL,   `mode` varchar(45) DEFAULT NULL,   `interval` varchar(45) DEFAULT NULL,   `vlantagids` varchar(256) DEFAULT NULL,   `pvideth1` int(11) DEFAULT NULL,   `veth1slotid` int(11) DEFAULT NULL,   `veth1ieee` varchar(45) DEFAULT NULL,   `veth1vlans` varchar(45) DEFAULT NULL,   `tunkveth1prio` int(11) DEFAULT NULL,   `veth1adapname` varchar(45) DEFAULT NULL,   `seacfgcol` varchar(45) DEFAULT NULL,   `pvideth2` int(11) DEFAULT NULL,   `veth2slotid` int(11) DEFAULT NULL,   `veth2ieee` varchar(45) DEFAULT NULL,   `veth2vlans` varchar(45) DEFAULT NULL,   `tunkveth2prio` int(11) DEFAULT NULL,   `veth2adapname` varchar(45) DEFAULT NULL,   `pvideth2_copy1` int(11) DEFAULT NULL,   `veth3slotid` int(11) DEFAULT NULL,   `veth3ieee` varchar(45) DEFAULT NULL,   `veth3vlans` varchar(45) DEFAULT NULL,   `tunkveth3prio` int(11) DEFAULT NULL,   `veth3adapname` varchar(45) DEFAULT NULL,   `pvideth4` int(11) DEFAULT NULL,   `veth4slotid` int(11) DEFAULT NULL,   `veth4ieee` varchar(45) DEFAULT NULL,   `veth4vlans` varchar(45) DEFAULT NULL,   `tunkveth4prio` int(11) DEFAULT NULL,   `veth4adapname` varchar(45) DEFAULT NULL,   `threading` varchar(45) DEFAULT NULL,   `ctlchanslotid` int(11) DEFAULT NULL,   `ctlchanvlanid` int(11) DEFAULT NULL,   `ctlchanadap` varchar(45) DEFAULT NULL,   `hamode` varchar(45) DEFAULT NULL,   `jumboframes` varchar(45) DEFAULT NULL,   `largesend` varchar(45) DEFAULT NULL,   `largerecive` varchar(45) DEFAULT NULL,   `flowcontrol` varchar(45) DEFAULT NULL,   `accounting` varchar(45) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8; CREATE TABLE  `"+DatabaseName+"`.`tunables` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `taget` varchar(45) DEFAULT NULL,   `tunable` varchar(256) DEFAULT NULL,   `appliedonvio` varchar(45) DEFAULT NULL,   `appliedonaix7` varchar(45) DEFAULT NULL,   `appliedonaix6` varchar(45) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8; CREATE TABLE  `"+DatabaseName+"`.`vfibermap` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `frame` varchar(256) DEFAULT NULL,   `lpar` varchar(45) DEFAULT NULL,   `vio1vfchostslotidrv` int(11) DEFAULT NULL,   `vio1rootvgvfchostnamerv` varchar(45) DEFAULT NULL,   `vio1clientadapnamerv` varchar(45) DEFAULT NULL,   `vio1vfiberclientslotidrv` int(11) DEFAULT NULL,   `vio1vfchostslotiddv1` int(11) DEFAULT NULL,   `vio1rootvgvfchostnamedv1` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv1` varchar(45) DEFAULT NULL,   `vio1vfiberclientslotiddv1` int(11) DEFAULT NULL,   `vio1vfchostslotiddv2` int(11) DEFAULT NULL,   `vio1rootvgvfchostnamedv2` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv2` varchar(45) DEFAULT NULL,   `vio1vfiberclientslotiddv2` int(11) DEFAULT NULL,   `vio1vfchostslotiddv3` int(11) DEFAULT NULL,   `vio1rootvgvfchostnamedv3` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv3` varchar(45) DEFAULT NULL,   `vio1vfiberclientslotiddv3` int(11) DEFAULT NULL,   `vio1vfchostslotiddv4` int(11) DEFAULT NULL,   `vio1rootvgvfchostnamedv4` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv4` varchar(45) DEFAULT NULL,   `vio1vfiberclientslotiddv4` int(11) DEFAULT NULL,   `vio2vfchostslotidrv` int(11) DEFAULT NULL,   `vio2rootvgvfchostnamerv` varchar(45) DEFAULT NULL,   `vio2clientadapnamerv` varchar(45) DEFAULT NULL,   `vio2vfiberclientslotidrv` int(11) DEFAULT NULL,   `vio2vfchostslotiddv1` int(11) DEFAULT NULL,   `vio2rootvgvfchostnamedv1` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv1` varchar(45) DEFAULT NULL,   `vio2vfiberclientslotiddv1` int(11) DEFAULT NULL,   `vio2vfchostslotiddv2` int(11) DEFAULT NULL,   `vio2rootvgvfchostnamedv2` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv2` varchar(45) DEFAULT NULL,   `vio2vfiberclientslotiddv2` int(11) DEFAULT NULL,   `vio2vfchostslotiddv3` int(11) DEFAULT NULL,   `vio2rootvgvfchostnamedv3` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv3` varchar(45) DEFAULT NULL,   `vio2vfiberclientslotiddv3` int(11) DEFAULT NULL,   `vio2vfchostslotiddv4` int(11) DEFAULT NULL,   `vio2rootvgvfchostnamedv4` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv4` varchar(45) DEFAULT NULL,   `vio2vfiberclientslotiddv4` int(11) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8; CREATE TABLE  `"+DatabaseName+"`.`vscsimap` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `frame` varchar(256) DEFAULT NULL,   `lpar` varchar(45) DEFAULT NULL,   `vio1vhostslotidrv` int(11) DEFAULT NULL,   `vio1rootvgvhostnamerv` varchar(45) DEFAULT NULL,   `vio1clientadapnamerv` varchar(45) DEFAULT NULL,   `vio1vscsiclientslotidrv` int(11) DEFAULT NULL,   `vio1vhostslotiddv1` int(11) DEFAULT NULL,   `vio1rootvgvhostnamedv1` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv1` varchar(45) DEFAULT NULL,   `vio1vscsiclientslotiddv1` int(11) DEFAULT NULL,   `vio1vhostslotiddv2` int(11) DEFAULT NULL,   `vio1rootvgvhostnamedv2` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv2` varchar(45) DEFAULT NULL,   `vio1vscsiclientslotiddv2` int(11) DEFAULT NULL,   `vio1vhostslotiddv3` int(11) DEFAULT NULL,   `vio1rootvgvhostnamedv3` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv3` varchar(45) DEFAULT NULL,   `vio1vscsiclientslotiddv3` int(11) DEFAULT NULL,   `vio1vhostslotiddv4` int(11) DEFAULT NULL,   `vio1rootvgvhostnamedv4` varchar(45) DEFAULT NULL,   `vio1clientadapnamedv4` varchar(45) DEFAULT NULL,   `vio1vscsiclientslotiddv4` int(11) DEFAULT NULL,   `vio2vhostslotidrv` int(11) DEFAULT NULL,   `vio2rootvgvhostnamerv` varchar(45) DEFAULT NULL,   `vio2clientadapnamerv` varchar(45) DEFAULT NULL,   `vio2vscsiclientslotidrv` int(11) DEFAULT NULL,   `vio2vhostslotiddv1` int(11) DEFAULT NULL,   `vio2rootvgvhostnamedv1` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv1` varchar(45) DEFAULT NULL,   `vio2vscsiclientslotiddv1` int(11) DEFAULT NULL,   `vio2vhostslotiddv2` int(11) DEFAULT NULL,   `vio2rootvgvhostnamedv2` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv2` varchar(45) DEFAULT NULL,   `vio2vscsiclientslotiddv2` int(11) DEFAULT NULL,   `vio2vhostslotiddv3` int(11) DEFAULT NULL,   `vio2rootvgvhostnamedv3` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv3` varchar(45) DEFAULT NULL,   `vio2vscsiclientslotiddv3` int(11) DEFAULT NULL,   `vio2vhostslotiddv4` int(11) DEFAULT NULL,   `vio2rootvgvhostnamedv4` varchar(45) DEFAULT NULL,   `vio2clientadapnamedv4` varchar(45) DEFAULT NULL,   `vio2vscsiclientslotiddv4` int(11) DEFAULT NULL,   PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;";
      stmt.executeUpdate(sql0);

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
}
    
}
